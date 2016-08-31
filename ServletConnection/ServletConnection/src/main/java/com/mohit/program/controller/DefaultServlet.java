/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mohit.program.controller;

import com.mohit.program.dao.CourseDao;
import com.mohit.program.dao.impl.CourseDaoImpl;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mohit
 */
public class DefaultServlet extends HttpServlet{
    
    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
    {
        CourseDao courseDao=new CourseDaoImpl();
       
        String sql="hello word";
        try {
            request.setAttribute("hello", sql);
        
            request.setAttribute("courses", courseDao.getAll(true));
        } catch (SQLException|ClassNotFoundException ex) {
            System.out.println(ex.getLocalizedMessage());
        }
       request.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(request, response);
    }
    
}
