/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mohit.program.controller;

import com.mohit.program.dao.CourseDao;
import com.mohit.program.dao.impl.CourseDaoImpl;
import com.mohit.program.entity.Course;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mohit
 */
@WebServlet(name = "course", urlPatterns = {"/course/*"})
public class CourseServlet extends HttpServlet {

    private CourseDao cDao = new CourseDaoImpl();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        int id = Integer.parseInt(request.getParameter("id"));
        try {
            Course c = cDao.getById(id);
            if (c == null) {
                response.sendRedirect("/");
            }
            request.setAttribute("course", c);

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getLocalizedMessage());
        }
        request.getRequestDispatcher("/WEB-INF/views/course/description.jsp").forward(request, response);

    }

}
