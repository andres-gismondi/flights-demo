package com.api.demoproject.flights.controller;

import com.api.demoproject.application.exceptions.DataAccessException;
import com.api.demoproject.application.exceptions.EntityNotFoundException;
import com.api.demoproject.flights.dto.FlightTicketDto;
import com.api.demoproject.flights.service.FlightTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/flights")
public class FlightsController {

    @Autowired
    private FlightTicketService flightTicketService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FlightTicketDto> getFlights(@PathVariable("id") Long id) throws EntityNotFoundException {
        FlightTicketDto flightTicketDto = this.flightTicketService.getFligh(id);
        return ResponseEntity.ok(flightTicketDto);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createFlightTicket(@RequestBody FlightTicketDto flightTicketDto) throws DataAccessException {
        this.flightTicketService.createFlightTicket(flightTicketDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
