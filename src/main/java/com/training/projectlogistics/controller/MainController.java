package com.training.projectlogistics.controller;

import com.training.projectlogistics.controller.dto.CalculatorDTO;
import com.training.projectlogistics.controller.dto.OrderDTO;
import com.training.projectlogistics.enums.CargoType;
import com.training.projectlogistics.exceptions.DatabaseFetchException;
import com.training.projectlogistics.model.Route;
import com.training.projectlogistics.model.User;
import com.training.projectlogistics.service.RouteService;
import com.training.projectlogistics.service.order.OrderSumCalculationService;
import freemarker.template.DefaultObjectWrapperBuilder;
import freemarker.template.Version;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

import java.math.BigDecimal;

import static com.training.projectlogistics.constants.WebConstants.*;

@Controller
public class MainController {
    private static final String STATICS = "statics";
    private static final String DEFAULT_OBJ_WRAPPER_BUILDER_VERSION = "2.3.28";
    private static final String MAIN_PAGE = "general/main";
    private static final String LOGIN_PAGE = "general/login";
    private static final String AUTH_ERROR_PAGE = "general/authError";
    private static final String CALCULATOR_RESULT_PAGE = "general/calculator";
    private static final String ATTRIBUTE_CALCULATOR_DTO = "calculatorDTO";
    private static final String ATTRIBUTE_POINT_ONE = "point1";
    private static final String ATTRIBUTE_POINT_TWO = "point2";
    private static final String ATTRIBUTE_WEIGHT = "weight";
    private static final String ATTRIBUTE_DELIVERY_COST = "cost";

    private RouteService routeService;
    private OrderSumCalculationService orderSumCalculationService;

    @Autowired
    public MainController(RouteService routeService,
                          OrderSumCalculationService orderSumCalculationService) {
        this.routeService = routeService;
        this.orderSumCalculationService = orderSumCalculationService;
    }

    @GetMapping("/")
    public String greetAll(@AuthenticationPrincipal User user,
                           Model model)
            throws DatabaseFetchException {

        if (user != null) {
            SecurityContextHolder.clearContext();
        }
        model.addAttribute(ATTRIBUTE_ROUTES, routeService.getAllRoutes());
        model.addAttribute(STATICS,
                new DefaultObjectWrapperBuilder(new Version(DEFAULT_OBJ_WRAPPER_BUILDER_VERSION))
                .build().getStaticModels());

        model.addAttribute(ATTRIBUTE_CALCULATOR_DTO, new CalculatorDTO());
        model.addAttribute(ATTRIBUTE_CITIES_EN, routeService.getCitiesOptionsEng());
        model.addAttribute(ATTRIBUTE_CITIES_UA, routeService.getCitiesOptionsUa());

        return MAIN_PAGE;
    }

    @GetMapping("/calculate")
    public String calculateDeliveryCost(@ModelAttribute @Valid CalculatorDTO calculatorDTO,
                                        BindingResult result,
                                        Model model)
            throws DatabaseFetchException {

        if (result.hasErrors()) {
            model.addAttribute(ATTRIBUTE_ROUTES, routeService.getAllRoutes());
            model.addAttribute(STATICS,
                    new DefaultObjectWrapperBuilder(new Version(DEFAULT_OBJ_WRAPPER_BUILDER_VERSION))
                            .build().getStaticModels());

            model.addAttribute(ATTRIBUTE_CITIES_EN, routeService.getCitiesOptionsEng());
            model.addAttribute(ATTRIBUTE_CITIES_UA, routeService.getCitiesOptionsUa());
            return MAIN_PAGE;
        }

        String pointOne = calculatorDTO.getDispatchCity();
        String pointTwo = calculatorDTO.getDeliveryCity();
        Route route = routeService.getRouteByTwoPoints(pointOne, pointTwo);
        BigDecimal cost = orderSumCalculationService.calculateSum(calculatorDTO.getWeight(), route);

        model.addAttribute(ATTRIBUTE_POINT_ONE, calculatorDTO.getDispatchCity());
        model.addAttribute(ATTRIBUTE_POINT_TWO, calculatorDTO.getDeliveryCity());
        model.addAttribute(ATTRIBUTE_WEIGHT, calculatorDTO.getWeight());
        model.addAttribute(ATTRIBUTE_DELIVERY_COST, cost);

        return CALCULATOR_RESULT_PAGE;
    }

    @GetMapping("/login")
    public String enterLogin(@AuthenticationPrincipal User user) {
        if (user != null) {
            SecurityContextHolder.clearContext();
        }
        return LOGIN_PAGE;
    }

    @GetMapping("/login/authError")
    public String failedLoginOutput() {
        return AUTH_ERROR_PAGE;
    }

    @ExceptionHandler(DatabaseFetchException.class)
    public String handleDatabaseFetchException(DatabaseFetchException e, Model model) {
        model.addAttribute(ERROR_MESSAGE, e.toString());
        return GENERAL_ERROR_PAGE;
    }
}
