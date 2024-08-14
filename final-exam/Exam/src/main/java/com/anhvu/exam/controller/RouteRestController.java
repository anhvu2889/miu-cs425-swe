package com.anhvu.exam.controller;

import com.anhvu.exam.dto.RouteRequest;
import com.anhvu.exam.exception.RouteNotFoundException;
import com.anhvu.exam.exception.StationNotFoundException;
import com.anhvu.exam.model.Route;
import com.anhvu.exam.model.Station;
import com.anhvu.exam.service.RouteService;
import com.anhvu.exam.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "routes", produces = MediaType.APPLICATION_JSON_VALUE)
public class RouteRestController {
    @Autowired
    private RouteService routeService;

    @Autowired
    private StationService stationService;

    @GetMapping
    public ResponseEntity<List<Route>> getRoutes() {
        return new ResponseEntity<>(routeService.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Route> getRoute(@PathVariable Long id) throws RouteNotFoundException {
        return new ResponseEntity<>(routeService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Route> createRoute(@RequestBody RouteRequest routeRequest) throws StationNotFoundException {
        Station departureStation = stationService.findById(routeRequest.getDepartureId());
        Station arrivalStation = stationService.findById(routeRequest.getArrivalId());

        Route route = Route.build(null,
                departureStation,
                routeRequest.getDepartureTime(),
                arrivalStation,
                routeRequest.getArrivalTime());

        return new ResponseEntity<>(routeService.save(route), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Route> updateRoute(@RequestBody Route route) {
        return new ResponseEntity<>(routeService.save(route), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteRoute(@PathVariable Long id){
        routeService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
