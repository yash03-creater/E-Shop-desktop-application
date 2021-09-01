/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eMart.dao;

import eMart.pojo.UserPojo;
import eMartD.DbUtil.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static java.util.Collections.list;
import java.util.HashMap;

public class UpdateReceptionistDao {
   public static HashMap<String,String>getAllId() throws SQLException, ClassNotFoundException
   {
   Connection conn=MyConnection.getConnection();
    Statement st=conn.createStatement();
    ResultSet rs=   st.executeQuery("select userid,username from users where usertype='Receptionist'");
    HashMap<String,String> hp=new HashMap<>();
    while(rs.next())
    {
     
    hp.put(rs.getString(1), rs.getString(2));
    }
        return hp;
   }
   public static boolean update(UserPojo up) throws SQLException, ClassNotFoundException
   {
        Connection conn=MyConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("update  users set passward=? where userid=?");
        ps.setString(1, up.getPassword());
        ps.setString(2, up.getUserId());
       return ps.executeUpdate()==1;
   }
}
