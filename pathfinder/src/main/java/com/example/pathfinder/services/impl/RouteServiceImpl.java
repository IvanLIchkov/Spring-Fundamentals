package com.example.pathfinder.services.impl;

import com.example.pathfinder.models.entities.Route;
import com.example.pathfinder.repositories.RouteRepository;
import com.example.pathfinder.services.RoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RouteServiceImpl implements RoutService {

    private final RouteRepository routeRepository;

    @Autowired
    public RouteServiceImpl(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }

    public Route getMostCommented() {
        return routeRepository.findMostCommented();
    }
}
