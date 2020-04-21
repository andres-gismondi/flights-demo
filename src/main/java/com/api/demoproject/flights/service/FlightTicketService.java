package com.api.demoproject.flights.service;

import com.api.demoproject.flights.model.FlightTicket;
import com.api.demoproject.flights.repository.IFlightTicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FlightTicketService {

    private IFlightTicketRepository flightTicketRepository;

    @Autowired
    public FlightTicketService(IFlightTicketRepository flightTicketRepository) {
        this.flightTicketRepository = flightTicketRepository;
    }

    public FlightTicket getFlightTicket() {
        FlightTicket flightTicket = this.flightTicketRepository.findById(1L).get();
        return flightTicket;
    }

}
