package com.training.projectlogistics.service;

import com.training.projectlogistics.exceptions.DatabaseFetchException;
import com.training.projectlogistics.model.Route;
import com.training.projectlogistics.repository.RouteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@Service
public class RouteService {
    private RouteRepository routeRepository;

    @Autowired
    public RouteService(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }

    public List<Route> getAllRoutes()
            throws DatabaseFetchException {

        try {
            return routeRepository.findAll();
        } catch (Exception e) {
            throw new DatabaseFetchException();
        }
    }

    public Route getRouteByTwoPoints(String pointOne, String pointTwo)
            throws DatabaseFetchException {

        return routeRepository
                .findByPointOneAndPointTwoOrPointTwoAndPointOne(pointOne, pointTwo, pointOne, pointTwo)
                .orElse(routeRepository
                        .findByPointOneUAAndPointTwoUAOrPointTwoUAAndPointOneUA
                                (pointOne, pointTwo, pointOne, pointTwo)
                        .orElseThrow(DatabaseFetchException::new));
    }

    public List<String> getCitiesOptionsEng()
            throws DatabaseFetchException {

        try {
            return Stream.concat(
                    routeRepository.findAll()
                            .stream()
                            .map(Route::getPointOne),
                    routeRepository.findAll()
                            .stream()
                            .map(Route::getPointTwo))
                    .distinct()
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new DatabaseFetchException();
        }
    }

    public List<String> getCitiesOptionsUa()
            throws DatabaseFetchException {

        try {
            return Stream.concat(
                    routeRepository.findAll()
                            .stream()
                            .map(Route::getPointOneUA),
                    routeRepository.findAll()
                            .stream()
                            .map(Route::getPointTwoUA))
                    .distinct()
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new DatabaseFetchException();
        }
    }
}
