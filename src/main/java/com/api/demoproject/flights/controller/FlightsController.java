package com.api.demoproject.flights.controller;

import com.api.demoproject.flights.model.FlightTicket;
import com.api.demoproject.flights.service.FlightTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/flights")
public class FlightsController {

    @Autowired
    private FlightTicketService flightTicketService;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FlightTicket> getFlights() {
        FlightTicket flightTicket = this.flightTicketService.getFlightTicket();
        return ResponseEntity.ok(flightTicket);
    }


}
