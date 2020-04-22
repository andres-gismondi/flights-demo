package com.api.demoproject.fligths;

import com.api.demoproject.application.exceptions.EntityNotFoundException;
import com.api.demoproject.flights.dto.FlightTicketDto;
import com.api.demoproject.flights.model.FlightTicket;
import com.api.demoproject.flights.repository.IFlightTicketRepository;
import com.api.demoproject.flights.service.FlightTicketService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
public class FlightTicketIntegrationTest {

    @Autowired
    private FlightTicketService flightTicketService;
    @Autowired
    private IFlightTicketRepository flightTicketRepository;

    @Test
    public void testFLightWithUnexistenceItineraryId() throws EntityNotFoundException {
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

}
