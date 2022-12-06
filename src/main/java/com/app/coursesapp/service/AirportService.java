package com.app.coursesapp.service;

import com.app.coursesapp.dao.AirportDao;
import com.app.coursesapp.dto.AirportDto;

import java.util.List;
import java.util.stream.Collectors;

public class AirportService {
    private static final AirportService INSTANCE = new AirportService();

    private final AirportDao airportDao = AirportDao.getInstance();


    public List<AirportDto> findAll(String code){
        return airportDao.findAllByCode(code).stream().map(airport -> new AirportDto(
                airport.getCode(),
                "%s - %s".formatted(airport.getCountry(),airport.getCity())
        )).collect(Collectors.toList());
    }


    public static AirportService getInstance(){
        return INSTANCE;
    }

    private AirportService(){}
}
