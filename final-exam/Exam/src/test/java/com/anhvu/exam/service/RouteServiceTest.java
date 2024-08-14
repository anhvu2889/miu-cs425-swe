package com.anhvu.exam.service;

import com.anhvu.exam.exception.RouteNotFoundException;
import com.anhvu.exam.model.Route;
import com.anhvu.exam.model.Station;
import com.anhvu.exam.repository.RouteRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalTime;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class RouteServiceTest {
    @Mock
    private RouteRepository routeRepository;

    @InjectMocks
    private RouteServiceImpl routeService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetRouteById() throws RouteNotFoundException {
        Station departureStation = new Station(1L, "Station A");
        Station arrivalStation = new Station(2L, "Station B");
        Route route = Route.build(null,
                departureStation,
                LocalTime.of(8, 30),
                arrivalStation,
                LocalTime.of(9, 15));

        when(routeRepository.findById(1L)).thenReturn(Optional.of(route));

        Route foundRoute = routeService.findById(1L);
        Assertions.assertEquals(departureStation.getName(), foundRoute.getDepartureStation().getName());
    }

    @Test()
    void testGetRouteByIdWithException() throws RouteNotFoundException {
        Exception exception = Assertions.assertThrows(RouteNotFoundException.class, () -> routeService.findById(1L));
        Assertions.assertTrue(exception.getMessage().contains("1"));
    }

    @Test
    void testCreateRoute() {
        Station departureStation = new Station(1L, "Station A");
        Station arrivalStation = new Station(2L, "Station B");
        Route route = Route.build(null,
                departureStation,
                LocalTime.of(8, 30),
                arrivalStation,
                LocalTime.of(9, 15));

        when(routeRepository.save(any(Route.class))).thenReturn(route);

        Route savedRoute = routeService.save(route);

        Assertions.assertEquals(departureStation.getName(), savedRoute.getDepartureStation().getName());
        verify(routeRepository, times(1)).save(route);
    }

    @Test
    void testDeleteRoute() {
        routeService.delete(1L);
        verify(routeRepository, times(1)).deleteById(1L);
    }
}
