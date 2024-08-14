package com.anhvu.exam.service;

import com.anhvu.exam.exception.RouteNotFoundException;
import com.anhvu.exam.model.Route;
import com.anhvu.exam.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteServiceImpl implements RouteService {

    @Autowired
    RouteRepository repository;

    @Override
    public Route findById(Long id) throws RouteNotFoundException {
        return repository.findById(id).orElseThrow(() -> new RouteNotFoundException(id));
    }

    @Override
    public List<Route> findAll() {
        return repository.findAll();
    }

    @Override
    public Route save(Route route) {
        return repository.save(route);
    }

    @Override
    public Route update(Route route) {
        return repository.save(route);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
