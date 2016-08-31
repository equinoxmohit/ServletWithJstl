/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mohit.program.dao.impl;

import com.mohit.program.connection.DbConnection;
import com.mohit.program.dao.EnquiryDao;
import com.mohit.program.entity.Course;
import com.mohit.program.entity.Enquiry;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mohit
 */
public class EnquiryDaoImpl implements EnquiryDao {

    private DbConnection conn = new DbConnection();
    private List<Enquiry> enquiryList = new ArrayList<>();

    @Override
    public int insert(Enquiry en) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO tbl_enquiries(first_name,last_name,contact_number,email_address,course_id)" + "VALUES(?,?,?,?,?)";
        conn.open();
        PreparedStatement stmnt = conn.initStatement(sql);
        stmnt.setString(1, en.getFirstName());
        stmnt.setString(2, en.getLastName());
        stmnt.setString(3, en.getContactNumber());
        stmnt.setString(4, en.getEmail());
        stmnt.setInt(5, en.getCourse().getId());
        int result = conn.executeUpdate();
        conn.close();
        return result;
    }

    @Override
    public List<Enquiry> getAll() throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM tbl_enquiries";
        conn.open();
        PreparedStatement stmnt = conn.initStatement(sql);
        ResultSet rs = conn.executeQuery();
        while (rs.next()) {
            Enquiry e = new Enquiry();
            e.setId(rs.getInt("enquiry_id"));
            e.setFirstName(rs.getString("first_name"));
            e.setLastName(rs.getString("last_name"));
            e.setContactNumber(rs.getString("contact_number"));
            e.setEmail(rs.getString("email_address"));
            e.setCourse(new Course("first_name"));
            enquiryList.add(e);
        }
        conn.close();
        return enquiryList;
    }

}
