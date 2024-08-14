package com.anhvu.exam.service;

import com.anhvu.exam.exception.StationNotFoundException;
import com.anhvu.exam.model.Station;

import java.util.List;

public interface StationService {
    Station add(Station station);

    Station update(Station station);

    Station findById(Long id) throws StationNotFoundException;

    List<Station> findAll();

    void deleteById(Long id);
}
