package com.api.demoproject.flights.repository;

import com.api.demoproject.flights.model.FlightTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFlightTicketRepository extends JpaRepository<FlightTicket, Long> {

    FlightTicket findByItineraryId(String flightId);

}
