package com.app.coursesapp.dto;

import lombok.*;

import java.util.Objects;

@Value
@Builder
public class TicketDto {

    Long id;
    Long flightId;
    String seatNo;

}
