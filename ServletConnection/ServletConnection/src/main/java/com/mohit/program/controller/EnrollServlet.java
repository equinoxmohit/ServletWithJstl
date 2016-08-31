/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mohit.program.controller;

import com.mohit.program.dao.CourseDao;
import com.mohit.program.dao.EnquiryDao;
import com.mohit.program.dao.impl.CourseDaoImpl;
import com.mohit.program.dao.impl.EnquiryDaoImpl;
import com.mohit.program.entity.Course;
import com.mohit.program.entity.Enquiry;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mohit
 */

@WebServlet(name = "enroll",urlPatterns = {"/enroll/*"})
public class EnrollServlet extends HttpServlet {

    private CourseDao cDao = new CourseDaoImpl();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        Course c = new Course();
        if ((request.getParameter("id") != null) && (!request.getParameter("id").isEmpty())) {
            int id = Integer.parseInt(request.getParameter("id"));
            try {
                c = cDao.getById(id);
                if (c == null) {
                    c = new Course();
                }
                request.setAttribute("course", c);
                request.setAttribute("courses", cDao.getAll(false));
                
                
               
            } catch (SQLException | ClassNotFoundException ex) {
                System.out.println(ex.getLocalizedMessage());
            }
        }
        
        request.getRequestDispatcher("/WEB-INF/views/enroll/enroll.jsp").forward(request, response);

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
              Enquiry en=new Enquiry();
              en.setFirstName(request.getParameter("firstName"));
              en.setLastName(request.getParameter("lastName"));
              en.setContactNumber(request.getParameter("contactNumber"));
              en.setEmail(request.getParameter("emailAddress"));
              en.setCourse(new Course(request.getParameter("first_name")));
              EnquiryDao enq=new EnquiryDaoImpl();
        try {
            enq.insert(en);
            response.sendRedirect(request.getContextPath()+"/enroll?success");
        } catch (SQLException ex) {
            Logger.getLogger(EnrollServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EnrollServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
