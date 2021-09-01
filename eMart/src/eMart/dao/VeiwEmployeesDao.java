/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eMart.dao;

import eMart.pojo.EmployPojo;
import eMartD.DbUtil.MyConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class VeiwEmployeesDao {
    public static ArrayList<EmployPojo> showEmploy() throws SQLException, ClassNotFoundException
    {
        ArrayList <EmployPojo>ar=new ArrayList<>();
    Connection conn=MyConnection.getConnection(); 
    Statement st=conn.createStatement();
    ResultSet rs=st.executeQuery("select *from employees order by EMPID ");
    while(rs.next())
    {
    EmployPojo ep=new EmployPojo();
    ep.setId(rs.getString(1));
    ep.setName(rs.getString(2));
    ep.setJob(rs.getString(3));
    ep.setSalary(rs.getInt(4));
    ar.add(ep);
    }
    return ar;
    }
}
