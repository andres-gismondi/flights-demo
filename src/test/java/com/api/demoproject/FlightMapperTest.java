package com.api.demoproject;

import com.api.demoproject.flights.dto.FlightTicketDto;
import com.api.demoproject.flights.mapper.FlightTicketMapper;
import com.api.demoproject.flights.model.FlightTicket;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@SpringBootTest
public class FlightMapperTest {

    private FlightTicketMapper flightTicketMapper;

    @BeforeEach
    public void setUp() {
        this.flightTicketMapper = new FlightTicketMapper();
    }

    @Test
    public void testMapToDto() {
        FlightTicket flightTicket = this.buildFlightTicket();
        FlightTicketDto flightTicketDto = this.flightTicketMapper.mapToDto(flightTicket);

        Assertions.assertEquals(flightTicket.isHasLuggageStorage(), flightTicketDto.isHasLuggageStorage());
        Assertions.assertEquals(flightTicket.getPrice(), flightTicketDto.getPrice());
        Assertions.assertEquals(flightTicket.getPassengerName(), flightTicketDto.getPassengerName());
        Assertions.assertEquals(flightTicket.getDestinationCity(), flightTicketDto.getDestinationCity());
        Assertions.assertEquals(flightTicket.getOriginCity(), flightTicketDto.getOriginCity());
        Assertions.assertEquals(flightTicket.getArrivalDate(), flightTicketDto.getArrivalDate());
        Assertions.assertEquals(flightTicket.getDepartureDate(), flightTicketDto.getDepartureDate());
        Assertions.assertEquals(flightTicket.getArrivalTime(), flightTicketDto.getArrivalTime());
        Assertions.assertEquals(flightTicket.getDepartureTime(), flightTicketDto.getDepartureTime());
    }

    @Test
    public void testMapToModel() {
        FlightTicketDto flightTicketDto = this.buildFlightTicketDto();
        FlightTicket flightTicket = new FlightTicket();
        flightTicket.setId(1L);
        flightTicket = this.flightTicketMapper.mapToModel(flightTicketDto, flightTicket);

        Assertions.assertFalse(flightTicket.getItineraryId().isEmpty());
        Assertions.assertNotNull(flightTicket.getId());
        Assertions.assertEquals(flightTicketDto.isHasLuggageStorage(), flightTicket.isHasLuggageStorage());
        Assertions.assertEquals(flightTicketDto.getPrice(), flightTicket.getPrice());
        Assertions.assertEquals(flightTicketDto.getPassengerName(), flightTicket.getPassengerName());
        Assertions.assertEquals(flightTicketDto.getDestinationCity(), flightTicket.getDestinationCity());
        Assertions.assertEquals(flightTicketDto.getOriginCity(), flightTicket.getOriginCity());
        Assertions.assertEquals(flightTicketDto.getArrivalDate(), flightTicket.getArrivalDate());
        Assertions.assertEquals(flightTicketDto.getDepartureDate(), flightTicket.getDepartureDate());
        Assertions.assertEquals(flightTicketDto.getArrivalTime(), flightTicket.getArrivalTime());
        Assertions.assertEquals(flightTicketDto.getDepartureTime(), flightTicket.getDepartureTime());
    }

    private FlightTicket buildFlightTicket() {
        FlightTicket flightTicket = new FlightTicket();
        flightTicket.setId(1L);
        flightTicket.setItineraryId("40f012de-3257-491d-9abd-1feb87f3404f");
        flightTicket.setHasLuggageStorage(Boolean.TRUE);
        flightTicket.setPrice(new BigDecimal("1000.00"));
        flightTicket.setPassengerName("Michael");
        flightTicket.setDestinationCity("London");
        flightTicket.setOriginCity("Montevideo");
        flightTicket.setArrivalDate(LocalDate.of(2020,6,20));
        flightTicket.setDepartureDate(LocalDate.of(2020,6,19));
        flightTicket.setDepartureTime(LocalTime.of(6,15,00));
        flightTicket.setArrivalTime(LocalTime.of(9,0,0));
        return flightTicket;
    }

    private FlightTicketDto buildFlightTicketDto() {
        FlightTicketDto flightTicketDto = new FlightTicketDto();
        flightTicketDto.setHasLuggageStorage(Boolean.TRUE);
        flightTicketDto.setPrice(new BigDecimal("1000.00"));
        flightTicketDto.setPassengerName("Michael");
        flightTicketDto.setDestinationCity("London");
        flightTicketDto.setOriginCity("Montevideo");
        flightTicketDto.setArrivalDate(LocalDate.of(2020,6,20));
        flightTicketDto.setDepartureDate(LocalDate.of(2020,6,19));
        flightTicketDto.setDepartureTime(LocalTime.of(6,15,00));
        flightTicketDto.setArrivalTime(LocalTime.of(9,0,0));
        return flightTicketDto;
    }

}
