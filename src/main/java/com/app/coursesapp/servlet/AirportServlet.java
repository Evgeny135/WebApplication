package com.app.coursesapp.servlet;

import com.app.coursesapp.service.AirportService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

@WebServlet("/airport")
public class AirportServlet extends HttpServlet {

    private  final AirportService airportService = AirportService.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String code = request.getParameter("code");
        response.setContentType("text/html");
        response.setCharacterEncoding(StandardCharsets.UTF_8.name());

        PrintWriter writer = response.getWriter();
        writer.println("<h1>Аэропорты:</h1>");
        writer.write("<ul>");
        airportService.findAll(code).forEach(airportDto -> writer.println(airportDto.getCode() + " " +airportDto.getDescription()));
        writer.write("</ul>");


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
