package com.anhvu.exam.controller;

import com.anhvu.exam.dto.RouteRequest;
import com.anhvu.exam.model.Route;
import com.anhvu.exam.model.Station;
import com.anhvu.exam.repository.RouteRepository;
import com.anhvu.exam.repository.StationRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalTime;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class RouteRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private RouteRepository routeRepository;

    @Autowired
    private StationRepository stationRepository;


    @BeforeEach
    void setUp() {
        routeRepository.deleteAll();
        stationRepository.deleteAll();
    }

    @Test
    void testCreateRoute() throws Exception {
        Station departureStation = new Station(null, "Station A");
        Station arrivalStation = new Station(null, "Station B");
        stationRepository.save(departureStation);
        stationRepository.save(arrivalStation);

        RouteRequest routeRequest = new RouteRequest();
        routeRequest.setDepartureId(departureStation.getId());
        routeRequest.setArrivalId(arrivalStation.getId());
        routeRequest.setDepartureTime(LocalTime.of(8, 30));
        routeRequest.setArrivalTime(LocalTime.of(9, 15));

        mockMvc.perform(post("/routes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"departureStation\": \"" + routeRequest.getDepartureId() + "\", " +
                                "\"arrivalStation\": \"" + routeRequest.getArrivalId() + "\", " +
                                "\"departureTime\": \"08:30\", " +
                                "\"arrivalTime\": \"09:15\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.departureStation.name").value("Station A"))
                .andExpect(jsonPath("$.arrivalStation.name").value("Station B"));
    }

    @Test
    void testGetRouteById() throws Exception {
        Station departureStation = new Station(1L, "Station A");
        Station arrivalStation = new Station(2L, "Station B");
        stationRepository.save(departureStation);
        stationRepository.save(arrivalStation);
        Route route = Route.build(1L,
                departureStation,
                LocalTime.of(8, 30),
                arrivalStation,
                LocalTime.of(9, 15));

        routeRepository.save(route);
        mockMvc.perform(get("/routes/" + route.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.departureStation.name").value("Station A"))
                .andExpect(jsonPath("$.arrivalStation.name").value("Station B"));
    }

    @Test
    void testDeleteRoute() throws Exception {
        Station departureStation = new Station(1L, "Station A");
        Station arrivalStation = new Station(2L, "Station B");
        stationRepository.save(departureStation);
        stationRepository.save(arrivalStation);

        Route route = Route.build(
                1L,
                departureStation,
                LocalTime.of(8, 30),
                arrivalStation,
                LocalTime.of(9, 15));
        routeRepository.save(route);

        mockMvc.perform(delete("/routes/" + route.getId()))
                .andExpect(status().isNoContent());

        mockMvc.perform(get("/routes/" + route.getId()))
                .andExpect(status().isNotFound());
    }
}
