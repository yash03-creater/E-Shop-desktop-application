/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eMart.dao;

import eMart.pojo.AddReceptionistPojo;
import eMart.pojo.UserPojo;
import eMartD.DbUtil.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class AddReceptionistDao {
     public static Map<String ,String> getAllid() throws SQLException, ClassNotFoundException
    {  
          
      Connection conn=MyConnection.getConnection();
       Statement st=conn.createStatement();
    ResultSet rs=   st.executeQuery("select empid,empname from employees where job='Receptionist' and empid not in (select empid from  users where usertype='Receptionist')");
    HashMap<String,String> hp=new HashMap<>();
    while(rs.next())
    {
     
    hp.put(rs.getString(1), rs.getString(2));
    }
        return hp;
}
     public static boolean addEmployee(UserPojo up) throws SQLException, ClassNotFoundException
     {  
          Connection conn=MyConnection.getConnection();
          PreparedStatement ps=conn.prepareStatement("insert into users values(?,?,?,?,?)");
          ps.setString(1, up.getUserId());
             ps.setString(2, up.getEmpId());
              ps.setString(3, up.getPassword());
                   ps.setString(4, "Receptionist");
                      ps.setString(5, up.getUserName());
                         return ps.executeUpdate()==1;
}
}
