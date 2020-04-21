package com.api.demoproject.flights.service;

import com.api.demoproject.application.exceptions.DataAccessException;
import com.api.demoproject.application.exceptions.EntityNotFoundException;
import com.api.demoproject.flights.dto.FlightTicketDto;
import com.api.demoproject.flights.mapper.FlightTicketMapper;
import com.api.demoproject.flights.model.FlightTicket;
import com.api.demoproject.flights.repository.IFlightTicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FlightTicketService {

    private IFlightTicketRepository flightTicketRepository;
    private FlightTicketMapper flightTicketMapper;

    @Autowired
    public FlightTicketService(IFlightTicketRepository flightTicketRepository, FlightTicketMapper flightTicketMapper) {
        this.flightTicketRepository = flightTicketRepository;
        this.flightTicketMapper = flightTicketMapper;
    }

    public FlightTicketDto getFligh(Long id) throws EntityNotFoundException {
        FlightTicket flightTicket = this.flightTicketRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Entity with id "+ id + " not found"));

        return this.flightTicketMapper.mapToDto(flightTicket);
    }

    public void createFlightTicket(FlightTicketDto flightTicketDto) throws DataAccessException {
        FlightTicket newFlightTicket = new FlightTicket();
        newFlightTicket = this.flightTicketMapper.mapToModel(flightTicketDto, newFlightTicket);
        this.saveFlight(newFlightTicket);
    }

    private FlightTicket saveFlight(FlightTicket flightTicket) throws DataAccessException {
        try{
            return this.flightTicketRepository.save(flightTicket);
        } catch (Exception e) {
            throw new DataAccessException("Error saving flight ticket", e);
        }
    }

}
