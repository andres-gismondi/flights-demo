package com.api.demoproject.flights.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ItineraryIdResponse {

    @JsonProperty("itinerary_id")
    private String itineraryId;

    public ItineraryIdResponse(String itineraryId) {
        this.itineraryId = itineraryId;
    }

    public String getItineraryId() {
        return itineraryId;
    }

    public void setItineraryId(String itineraryId) {
        this.itineraryId = itineraryId;
    }
}
