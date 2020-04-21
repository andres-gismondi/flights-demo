package com.api.demoproject.flights.mapper;

import com.api.demoproject.flights.dto.ItineraryIdResponse;
import com.api.demoproject.flights.dto.FlightTicketDto;
import com.api.demoproject.flights.model.FlightTicket;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class FlightTicketMapper {

    public FlightTicketDto mapToDto(FlightTicket flightTicket) {
        FlightTicketDto flightTicketDto = new FlightTicketDto();
        flightTicketDto.setArrivalDate(flightTicket.getArrivalDate());
        flightTicketDto.setArrivalTime(flightTicket.getArrivalTime());
        flightTicketDto.setDepartureDate(flightTicket.getDepartureDate());
        flightTicketDto.setDepartureTime(flightTicket.getDepartureTime());
        flightTicketDto.setDestinationCity(flightTicket.getDestinationCity());
        flightTicketDto.setOriginCity(flightTicket.getOriginCity());
        flightTicketDto.setPassengerName(flightTicket.getPassengerName());
        flightTicketDto.setPrice(flightTicket.getPrice());
        flightTicketDto.setHasLuggageStorage(flightTicket.isHasLuggageStorage());
        return flightTicketDto;
    }

    public FlightTicket mapToModel(FlightTicketDto flightTicketDto, FlightTicket flightTicket) {
        flightTicket.setArrivalTime(flightTicketDto.getArrivalTime());
        flightTicket.setArrivalDate(flightTicketDto.getArrivalDate());
        flightTicket.setDepartureDate(flightTicketDto.getDepartureDate());
        flightTicket.setDepartureTime(flightTicketDto.getDepartureTime());
        flightTicket.setDestinationCity(flightTicketDto.getDestinationCity());
        flightTicket.setOriginCity(flightTicketDto.getOriginCity());
        flightTicket.setPassengerName(flightTicketDto.getPassengerName());
        flightTicket.setPrice(flightTicketDto.getPrice());
        flightTicket.setHasLuggageStorage(flightTicketDto.isHasLuggageStorage());
        flightTicket.setItineraryId(UUID.randomUUID().toString());
        return flightTicket;
    }

    public ItineraryIdResponse mapToFlightId(String token) {
        return new ItineraryIdResponse(token);
    }

}
