/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eMart.dao;

import eMart.pojo.ProductPojo;
import eMart.pojo.UserPojo;
import eMartD.DbUtil.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class OrdersDao {
     public static String getOrderId() throws SQLException, ClassNotFoundException
   {
      
       Connection conn=MyConnection.getConnection();
       Statement st=conn.createStatement();
       ResultSet rs=st.executeQuery("select max(order_id) from orders");
       rs.next();
       String orderId=rs.getString(1);
        if(orderId==null)
           return "O-101";
        int id=Integer.parseInt((orderId.substring(2)));
      
       id=id+1;
       return "O-"+id;
   }
     public static boolean addOrder(ArrayList<ProductPojo>ar,String ordId) throws SQLException, ClassNotFoundException
     {
     int count=0;
     Connection conn=MyConnection.getConnection();
     PreparedStatement ps=conn.prepareStatement("Insert into orders values(?,?,?,?,?,?,?,?,?)");
     for(ProductPojo pp:ar)
     {
       ps.setString(1, ordId);
  ps.setString(2, pp.getProductId());
  ps.setString(3, pp.getProductName());
  ps.setString(4, pp.getCompanyName());
  ps.setDouble(5, pp.getProductPrice());
  ps.setDouble(6, pp.getOurPrice());
  ps.setInt(8,pp.getQuantity());
  ps.setInt(7, pp.getTax());
  ps.setString(9,UserPojo.getUserId());
  count=count+ps.executeUpdate();
     }
     return count==ar.size();
     }
      public static ArrayList<String> getAllid() throws SQLException, ClassNotFoundException
    {  
        String prev="a";
        ArrayList<String> ar=new ArrayList<>();  
      Connection conn=MyConnection.getConnection();
       Statement st=conn.createStatement();
    ResultSet rs=   st.executeQuery("select *from orders");
    while(rs.next())
    {
        if(!(prev.equalsIgnoreCase(rs.getString(1))))
    ar.add(rs.getString(1));
     prev=rs.getString(1);
    }
        return ar; 
}
      public static ArrayList<ProductPojo> getorderDetails(String ordId) throws SQLException, ClassNotFoundException
      {
          ArrayList <ProductPojo> ar=new ArrayList<>();
          
      Connection conn=MyConnection.getConnection();
      PreparedStatement st=conn.prepareStatement("select *from orders where ORDER_ID=?");
      st.setString(1, ordId);
      ResultSet rs=st.executeQuery();
      while (rs.next())
      {
      ProductPojo pp=new ProductPojo();
       pp.setProductId(rs.getString(2));
       pp.setProductName(rs.getString(3));
       pp.setCompanyName(rs.getString(4));
       pp.setProductPrice(rs.getDouble(5));
       pp.setOurPrice(rs.getDouble(6));
       pp.setTax(rs.getInt(7));
       pp.setQuantity(rs.getInt(8));
       ar.add(pp);
      }
      return ar;
      }
              
}
