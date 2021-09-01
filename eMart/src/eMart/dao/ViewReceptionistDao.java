/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eMart.dao;

import eMart.pojo.EmployPojo;
import eMart.pojo.UserPojo;
import eMartD.DbUtil.MyConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ViewReceptionistDao {
   public static ArrayList<UserPojo> showEmploy() throws SQLException, ClassNotFoundException
    {
        ArrayList <UserPojo>ar=new ArrayList<>();
    Connection conn=MyConnection.getConnection(); 
    Statement st=conn.createStatement();
    ResultSet rs=st.executeQuery("select *from users order by EMPID ");
    while(rs.next())
    {
    UserPojo ep=new UserPojo();
   ep.setUserId(rs.getString(1));
    ep.setEmpId(rs.getString(2));
    ep.setUserName(rs.getString(5));
    ep.setPassword(rs.getString(3));
    ar.add(ep);
    }
    return ar;
    }  
}
