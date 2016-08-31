/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mohit.program.dao;

import java.util.List;
import com.mohit.program.entity.Course;
import java.sql.SQLException;

/**
 *
 * @author Mohit
 */
public interface CourseDao {

    int insert(Course co) throws SQLException, ClassNotFoundException;

    List<Course> getAll(boolean isAvailable) throws SQLException, ClassNotFoundException;

    Course getById(int id) throws SQLException, ClassNotFoundException;

}
