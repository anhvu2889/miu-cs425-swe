package com.anhvu.exam.service;

import com.anhvu.exam.exception.RouteNotFoundException;
import com.anhvu.exam.model.Route;

import java.util.List;

public interface RouteService {
    Route findById(Long id) throws RouteNotFoundException;

    List<Route> findAll();

    Route save(Route route);

    Route update(Route route);

    void delete(Long id);
}
