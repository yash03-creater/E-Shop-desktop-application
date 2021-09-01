/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eMart.dao;

import eMart.pojo.EmployPojo;
import eMartD.DbUtil.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Acer
 */
public class UpdateEmployeeDao {
    public static ArrayList<String> getAllid() throws SQLException, ClassNotFoundException
    {  
        ArrayList<String> ar=new ArrayList<>();  
      Connection conn=MyConnection.getConnection();
       Statement st=conn.createStatement();
    ResultSet rs=   st.executeQuery("select *from employees");
    while(rs.next())
    {
    ar.add(rs.getString(1));
    }
        return ar; 
}
    public static EmployPojo setData(String id) throws ClassNotFoundException, SQLException
    {
    EmployPojo ep=new EmployPojo();
      Connection conn=MyConnection.getConnection();
      PreparedStatement ps=conn.prepareStatement("select *from employees where EMPID=?");
    ps.setString(1, id);
      ResultSet rs=ps.executeQuery();
 rs.next();
      ep.setName(rs.getString(2));
      ep.setJob(rs.getString(3));
      ep.setSalary(rs.getInt(4));
      
      
      return ep;
    }
    public static boolean updateData(EmployPojo ep) throws SQLException, ClassNotFoundException
    {
         Connection conn=MyConnection.getConnection();
      PreparedStatement ps=conn.prepareStatement("update  employees set EMPNAME=?,JOB=?,SALARY=? where EMPID=?");
     ps.setString(1, ep.getName());
     ps.setString(2, ep.getJob());
     ps.setInt(3, ep.getSalary());
     ps.setString(4, ep.getId());
     int x=ps.executeUpdate();
     return x==1;  
    }
}
