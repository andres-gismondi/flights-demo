package com.api.demoproject.flights.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public class FlightTicketDto {
    @JsonProperty("departure_date")
    private LocalDate departureDate;
    @JsonProperty("arrival_date")
    private LocalDate arrivalDate;
    @JsonProperty("origin_city")
    private String originCity;
    @JsonProperty("destination_city")
    private String destinationCity;
    @JsonProperty("passenger_name")
    private String passengerName;
    @JsonProperty("has_luggage_storage")
    private boolean hasLuggageStorage;
    private BigDecimal price;
    @JsonProperty("departure_time")
    private LocalTime departureTime;
    @JsonProperty("arrival_time")
    private LocalTime arrivalTime;

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public LocalDate getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(LocalDate arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public String getOriginCity() {
        return originCity;
    }

    public void setOriginCity(String originCity) {
        this.originCity = originCity;
    }

    public String getDestinationCity() {
        return destinationCity;
    }

    public void setDestinationCity(String destinationCity) {
        this.destinationCity = destinationCity;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public boolean isHasLuggageStorage() {
        return hasLuggageStorage;
    }

    public void setHasLuggageStorage(boolean hasLuggageStorage) {
        this.hasLuggageStorage = hasLuggageStorage;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
    }

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

}
