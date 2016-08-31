/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mohit.program.dao;

import com.mohit.program.entity.Enquiry;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Mohit
 */
public interface EnquiryDao {

    int insert(Enquiry en) throws SQLException, ClassNotFoundException;

    List<Enquiry> getAll() throws SQLException, ClassNotFoundException;

}
