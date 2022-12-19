package com.app.coursesapp.servlet;

import com.app.coursesapp.dto.UserDto;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/sessions")
public class SessionServlet extends HttpServlet {
    private static final String USER = "user";
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        UserDto user = (UserDto) session.getAttribute(USER);

        if (user==null){
            user = UserDto.builder()
                    .id(25L)
                    .mail("е@example.ru")
                    .build();
        System.out.println(user.toString());

        }


    }


}
