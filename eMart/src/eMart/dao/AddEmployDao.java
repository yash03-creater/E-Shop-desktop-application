
package eMart.dao;

import eMart.pojo.EmployPojo;
import eMart.pojo.UserPojo;
import eMartD.DbUtil.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class AddEmployDao {
    public static boolean addEmploy(EmployPojo up) throws SQLException, ClassNotFoundException
    {
       Connection conn=MyConnection.getConnection();
       PreparedStatement ps=conn.prepareStatement("Insert into employees values(?,?,?,?)");
       ps.setString(1, up.getId());
         ps.setString(2, up.getName());
             ps.setString(3, up.getJob());
            ps.setInt(4, up.getSalary());
       ResultSet rs=ps.executeQuery();
       if(!rs.next())
           return false;
       return true;
   }
    public static String showId() throws SQLException, ClassNotFoundException
    {
      Connection conn=MyConnection.getConnection();
       Statement ps=conn.createStatement();
   ResultSet rs=ps.executeQuery("select  max(empid) from employees");
   rs.next();
   int id=Integer.parseInt(rs.getString(1).substring(1));
   return "E"+(id+1);
    }
    }

