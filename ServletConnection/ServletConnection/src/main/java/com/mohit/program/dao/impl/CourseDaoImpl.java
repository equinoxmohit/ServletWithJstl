/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mohit.program.dao.impl;

import com.mohit.program.connection.DbConnection;
import com.mohit.program.dao.CourseDao;
import com.mohit.program.entity.Course;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mohit
 */
public class CourseDaoImpl implements CourseDao {

    private DbConnection conn = new DbConnection();
    List<Course> courseList = new ArrayList<>();

    @Override
    public int insert(Course co) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO tbl_courses(course_name,fees,status)" + "VALUES(?,?,?)";
        conn.open();
        PreparedStatement stmnt = conn.initStatement(sql);
        stmnt.setString(1, co.getName());
        stmnt.setInt(2, co.getFees());
        stmnt.setBoolean(3, co.isStatus());
        int result = conn.executeUpdate();
        conn.close();
        return result;
    }

    @Override
    public List<Course> getAll(boolean isAvailable) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM tbl_courses WHERE 1=1";
        if (isAvailable) {
            sql += " AND status=1";
        }
        conn.open();
        PreparedStatement stmnt = conn.initStatement(sql);
        ResultSet rs = conn.executeQuery();
        while (rs.next()) {
            Course c = new Course();
            c.setId(rs.getInt("course_id"));
            c.setName(rs.getString("course_name"));
            c.setFees(rs.getInt("fees"));
            c.setAddedDate(rs.getDate("added_date"));
            c.setStatus(rs.getBoolean("status"));
            courseList.add(c);
        }
        conn.close();
        return courseList;
    }

    @Override
    public Course getById(int id) throws SQLException, ClassNotFoundException {
        Course c = null;
        String sql = "SELECT * FROM tbl_courses WHERE course_id=?";
        conn.open();
        PreparedStatement stmnt = conn.initStatement(sql);
        stmnt.setInt(1, id);
        ResultSet rs = conn.executeQuery();
        while (rs.next()) {
            c = new Course();
            c.setId(rs.getInt("course_id"));
            c.setName(rs.getString("course_name"));
            c.setFees(rs.getInt("fees"));
            c.setAddedDate(rs.getDate("added_date"));
            c.setStatus(rs.getBoolean("status"));
        }
        conn.close();
        return c;
    }
}
