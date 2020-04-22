package com.api.demoproject.fligths;

import com.api.demoproject.application.exceptions.DataAccessException;
import com.api.demoproject.application.exceptions.EntityNotFoundException;
import com.api.demoproject.flights.dto.FlightTicketDto;
import com.api.demoproject.flights.dto.ItineraryIdResponse;
import com.api.demoproject.flights.model.FlightTicket;
import com.api.demoproject.flights.repository.IFlightTicketRepository;
import com.api.demoproject.flights.service.FlightTicketService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@SpringBootTest
@ActiveProfiles("test")
public class FlightTicketIntegrationTest {

    @Autowired
    private FlightTicketService flightTicketService;
    @Autowired
    private IFlightTicketRepository flightTicketRepository;

    @Test
    public void testFLightWithUnexistenceItineraryId() {
        String itineraryTestId = "aaaa";
        Exception exception = Assertions.assertThrows(EntityNotFoundException.class,
                () -> {
            this.flightTicketService.getFlight(itineraryTestId);
        });

        Assertions.assertTrue(exception.getMessage().contains("Itinerary id ["+ itineraryTestId +"] not found"));
    }

    @Test
    public void testGetFlightWithItineraryId() throws EntityNotFoundException {
        FlightTicket flightTicket = this.flightTicketRepository.findByItineraryId("frgt-345t-o9i8-frg56");

        String itineraryTestId = "frgt-345t-o9i8-frg56";
        FlightTicketDto flightTicketDto = this.flightTicketService.getFlight(itineraryTestId);

        Assertions.assertEquals(flightTicket.getItineraryId(), itineraryTestId);
        Assertions.assertEquals(flightTicket.getDepartureTime(), flightTicketDto.getDepartureTime());

    }

    @Test
    public void testCreateFlightTicket() throws DataAccessException {
        FlightTicketDto flightTicketDto = this.buildFlightTicketDto();
        ItineraryIdResponse response = this.flightTicketService.createFlightTicket(flightTicketDto);

        Assertions.assertFalse(response.getItineraryId().isEmpty());
    }

    private FlightTicketDto buildFlightTicketDto() {
        FlightTicketDto flightTicketDto = new FlightTicketDto();
        flightTicketDto.setHasLuggageStorage(Boolean.FALSE);
        flightTicketDto.setPrice(new BigDecimal("3500.00"));
        flightTicketDto.setPassengerName("Eric");
        flightTicketDto.setOriginCity("Cordoba");
        flightTicketDto.setDestinationCity("Sao Paulo");
        flightTicketDto.setArrivalDate(LocalDate.of(2020,5,20));
        flightTicketDto.setDepartureDate(LocalDate.of(2020,5,21));
        flightTicketDto.setDepartureTime(LocalTime.of(5,0,0));
        flightTicketDto.setArrivalTime(LocalTime.of(9,0,0));
        return flightTicketDto;
    }

}
