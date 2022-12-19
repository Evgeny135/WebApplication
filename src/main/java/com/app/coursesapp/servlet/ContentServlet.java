package com.app.coursesapp.servlet;

import com.app.coursesapp.dto.FlightDto;
import com.app.coursesapp.service.FlightService;
import com.app.coursesapp.util.JspHelper;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/content")
public class ContentServlet extends HttpServlet {

    private final FlightService flightService = FlightService.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<FlightDto> flightDtos = flightService.findAll();
        request.setAttribute("flights",flightDtos);
        request.getSession().setAttribute("flightsMap",flightDtos.stream()
                .collect(Collectors.toMap(FlightDto::getId, FlightDto::getDescription)));


        request.getRequestDispatcher(JspHelper.getPath("content")).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
