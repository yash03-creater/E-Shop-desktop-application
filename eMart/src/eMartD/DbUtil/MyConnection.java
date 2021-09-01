/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eMartD.DbUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {
   
   public static Connection conn=null;
   
 public static Connection getConnection()throws SQLException, ClassNotFoundException
 {
      Class.forName("oracle.jdbc.OracleDriver");
          System.out.println("class loaded successhfully");
          conn= DriverManager.getConnection("jdbc:oracle:thin:@DESKTOP-URKDROE:1521/xe","backend1","jatsaab10");
          System.out.println("connection opened!");
   return conn;  
 }
 public static void close() throws SQLException
 {
    conn.close();
 }
}

