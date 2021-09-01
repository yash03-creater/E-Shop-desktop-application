/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eMart.dao;

import eMartD.DbUtil.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class RemoveReceptionistDao {
   public static ArrayList<String>getUserId() throws SQLException, ClassNotFoundException
   {
    ArrayList<String> ar=new ArrayList<>();  
      Connection conn=MyConnection.getConnection();
       Statement st=conn.createStatement();
    ResultSet rs=   st.executeQuery("select *from users where usertype='Receptionist'");
    while(rs.next())
    {
    ar.add(rs.getString(1));
    }
        return ar;
   }
   public static boolean remove(String id) throws SQLException, ClassNotFoundException
   {
    Connection conn=MyConnection.getConnection();
    PreparedStatement ps=conn.prepareStatement("delete from users where userid=?");
    ps.setString(1, id);
    return ps.executeUpdate()==1;
   }
}
