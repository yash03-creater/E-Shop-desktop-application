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

/*for confirming login detail*/
public class UserDao {
   public static boolean userConfig(UserPojo up) throws SQLException, ClassNotFoundException 
   {
       Connection conn=MyConnection.getConnection();
       PreparedStatement ps=conn.prepareStatement("Select *from users where USERID=? and PASSWARD=? and USERTYPE=?");
       ps.setString(1, up.getUserId());
         ps.setString(2, up.getPassword());
             ps.setString(3, up.getUsertype());
            
       ResultSet rs=ps.executeQuery();
       if(!rs.next())
           return false;
       up.setUserName(rs.getString(5));
       return true;
   }
}
