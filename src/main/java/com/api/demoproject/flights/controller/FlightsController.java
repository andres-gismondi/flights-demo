package com.api.demoproject.flights.controller;

import com.api.demoproject.application.exceptions.DataAccessException;
import com.api.demoproject.application.exceptions.EntityNotFoundException;
import com.api.demoproject.flights.dto.ItineraryIdResponse;
import com.api.demoproject.flights.dto.FlightTicketDto;
import com.api.demoproject.flights.service.FlightTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/flights")
public class FlightsController {

    @Autowired
    private FlightTicketService flightTicketService;

    @GetMapping("/{flight-id}")
    public ResponseEntity<FlightTicketDto> getFlights(@PathVariable("flight-id") String id) throws EntityNotFoundException {
        FlightTicketDto flightTicketDto = this.flightTicketService.getFlight(id);
        return ResponseEntity.ok(flightTicketDto);
    }

    @PostMapping
    public ResponseEntity<ItineraryIdResponse> createFlightTicket(@RequestBody FlightTicketDto flightTicketDto) throws DataAccessException {
        ItineraryIdResponse flightId = this.flightTicketService.createFlightTicket(flightTicketDto);
        return ResponseEntity.ok(flightId);
    }

}
