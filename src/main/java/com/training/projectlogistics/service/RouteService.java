package com.training.projectlogistics.service;

import com.training.projectlogistics.model.Route;
import com.training.projectlogistics.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class RouteService {
    private RouteRepository routeRepository;

    @Autowired
    public RouteService(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }

    public List<Route> getAllRoutes() {
        return routeRepository.findAll();
    }

    public List<String> getAllRoutesPoints() {
        return Stream.concat(
                routeRepository.findAll()
                    .stream()
                    .map(Route::getPointOne),
                routeRepository.findAll()
                    .stream()
                    .map(Route::getPointTwo))
                .distinct()
                .collect(Collectors.toList());
    }
}
