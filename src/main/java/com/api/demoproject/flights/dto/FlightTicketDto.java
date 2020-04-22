package com.api.demoproject.flights.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public class FlightTicketDto {
    @JsonProperty("departure_date")
    @NotNull(message = "departure_date may not be null")
    private LocalDate departureDate;
    @JsonProperty("arrival_date")
    @NotNull(message = "arrival_date may not be null")
    private LocalDate arrivalDate;
    @JsonProperty("origin_city")
    @NotBlank(message = "origin_city may not be null")
    private String originCity;
    @JsonProperty("destination_city")
    @NotBlank(message = "destination_city may not be null")
    private String destinationCity;
    @JsonProperty("passenger_name")
    @NotBlank(message = "passenger_name may not be null")
    private String passengerName;
    @JsonProperty("has_luggage_storage")
    @NotNull(message = "has_luggage_storage may not be null")
    private boolean hasLuggageStorage;
    @NotNull(message = "Price may not be null")
    private BigDecimal price;
    @JsonProperty("departure_time")
    @NotNull(message = "departure_time may not be null")
    private LocalTime departureTime;
    @JsonProperty("arrival_time")
    @NotNull(message = "arrival_time may not be null")
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
