package com.anhvu.exam.controller;

import com.anhvu.exam.exception.StationNotFoundException;
import com.anhvu.exam.model.Station;
import com.anhvu.exam.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "stations", produces = MediaType.APPLICATION_JSON_VALUE)
public class StationRestController {

    @Autowired
    private StationService stationService;

    @GetMapping
    public ResponseEntity<List<Station>> getStations() {
        return new ResponseEntity<>(stationService.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Station> getStation(@PathVariable Long id) throws StationNotFoundException {
        return new ResponseEntity<>(stationService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Station> createStation(@RequestBody Station station) {
        return new ResponseEntity<>(stationService.add(station), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Station> updateStation(@RequestBody Station station) {
        return new ResponseEntity<>(stationService.add(station), HttpStatus.OK);
    }
}
