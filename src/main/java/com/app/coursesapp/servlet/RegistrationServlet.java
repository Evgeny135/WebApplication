package com.app.coursesapp.servlet;

import com.app.coursesapp.dto.CreateUserDto;
import com.app.coursesapp.service.UserService;
import com.app.coursesapp.util.JspHelper;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;


@MultipartConfig(fileSizeThreshold = 1024*1024)
@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {

    private final UserService userService = UserService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("roles", List.of("USER","ADMIN"));
        req.setAttribute("genders",List.of("MALE","FEMALE"));

        req.getRequestDispatcher(JspHelper.getPath("registration"))
                .forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final String name = request.getParameter("name");

        CreateUserDto userDto = CreateUserDto.builder()
                .name(name)
                .birthday(request.getParameter("birthday"))
                .email(request.getParameter("email"))
                .password(request.getParameter("password"))
                .role(request.getParameter("role"))
                .gender(request.getParameter("gender"))
                .image(request.getPart("image"))
                .build();

        userService.create(userDto);
        response.sendRedirect("/login");

    }
}
