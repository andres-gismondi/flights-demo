package com.api.demoproject.flights.service;

import com.api.demoproject.application.exceptions.DataAccessException;
import com.api.demoproject.application.exceptions.EntityNotFoundException;
import com.api.demoproject.flights.dto.ItineraryIdResponse;
import com.api.demoproject.flights.dto.FlightTicketDto;
import com.api.demoproject.flights.mapper.FlightTicketMapper;
import com.api.demoproject.flights.model.FlightTicket;
import com.api.demoproject.flights.repository.IFlightTicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FlightTicketService {

    private IFlightTicketRepository flightTicketRepository;
    private FlightTicketMapper flightTicketMapper;

    @Autowired
    public FlightTicketService(IFlightTicketRepository flightTicketRepository, FlightTicketMapper flightTicketMapper) {
        this.flightTicketRepository = flightTicketRepository;
        this.flightTicketMapper = flightTicketMapper;
    }

    public FlightTicketDto getFlight(String id) throws EntityNotFoundException {

        return Optional.of(this.flightTicketRepository
                .findByItineraryId(id))
                .map(this.flightTicketMapper::mapToDto)
                .orElseThrow(() -> new EntityNotFoundException("Entity with id "+ id + " not found"));
    }

    public ItineraryIdResponse createFlightTicket(FlightTicketDto flightTicketDto) throws DataAccessException {
        FlightTicket newFlightTicket = new FlightTicket();
        newFlightTicket = this.flightTicketMapper.mapToModel(flightTicketDto, newFlightTicket);
        this.saveFlight(newFlightTicket);
        return this.flightTicketMapper.mapToFlightId(newFlightTicket.getItineraryId());
    }

    private void saveFlight(FlightTicket flightTicket) throws DataAccessException {
        try{
            this.flightTicketRepository.save(flightTicket);
        } catch (Exception e) {
            throw new DataAccessException("Error saving flight ticket", e);
        }
    }

}
