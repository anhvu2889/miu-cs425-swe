package com.anhvu.exam.service;

import com.anhvu.exam.exception.StationNotFoundException;
import com.anhvu.exam.model.Station;
import com.anhvu.exam.repository.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StationServiceImpl implements StationService {

    @Autowired
    StationRepository repository;

    @Override
    public Station add(Station station) {
        return repository.save(station);
    }

    @Override
    public Station update(Station station) {
        return repository.save(station);
    }

    @Override
    public Station findById(Long id) throws StationNotFoundException {
        return repository.findById(id).orElseThrow(() -> new StationNotFoundException(id));
    }

    @Override
    public List<Station> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
