/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eMart.dao;

import eMart.pojo.ProductPojo;
import eMartD.DbUtil.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class ProductDao {
   public static String getProductId() throws SQLException, ClassNotFoundException
   {
       Connection conn=MyConnection.getConnection();
       Statement st=conn.createStatement();
       ResultSet rs=st.executeQuery("select max(p_id) from products");
       rs.next();
       String productId=rs.getString(1);
       
        int id=Integer.parseInt((productId.substring(1)));
       if(productId==null)
           return "P"+101;
       id=id+1;
       return "P"+id;
   }
   public static boolean addProduct(ProductPojo pp) throws SQLException, ClassNotFoundException
   {
   Connection conn=MyConnection.getConnection();
   PreparedStatement ps=conn.prepareStatement("insert into products values(?,?,?,?,?,?,?,'y')");
  ps.setString(1, pp.getProductId());
  ps.setString(2, pp.getProductName());
  ps.setString(3, pp.getCompanyName());
  ps.setDouble(4, pp.getProductPrice());
  ps.setDouble(5, pp.getOurPrice());
  ps.setInt(7,pp.getQuantity());
  ps.setInt(6, pp.getTax());
   return ps.executeUpdate()==1;
   }

public static ArrayList<ProductPojo> showEmploy() throws SQLException, ClassNotFoundException
{
ArrayList <ProductPojo>ar=new ArrayList<>();

Connection conn=MyConnection.getConnection();
Statement st=conn.createStatement();
ResultSet rs=st.executeQuery("select *from products where AVAILABLE='y' order by P_ID"); 
while(rs.next())
{
    ProductPojo pp=new ProductPojo(); 
pp.setProductId(rs.getString(1));
pp.setProductName(rs.getString(2));
pp.setCompanyName(rs.getString(3));
pp.setProductPrice(rs.getInt(4));
pp.setOurPrice(rs.getInt(5));
pp.setTax(rs.getInt(6));
pp.setQuantity(rs.getInt(7));
ar.add(pp);
}
       return ar;
}
public static boolean deleteProduct(String id) throws SQLException, ClassNotFoundException
{
Connection conn=MyConnection.getConnection();
PreparedStatement ps=conn.prepareStatement("update products set available='n' where P_ID=?");
ps.setString(1, id);
return ps.executeUpdate()==1;
}
public static boolean updateProduct(ProductPojo pp) throws SQLException, ClassNotFoundException
{
    Connection conn=MyConnection.getConnection();
     PreparedStatement ps=conn.prepareStatement("update  products set P_NAME=?,P_COMPANYNAME=?,P_PRICE=?, OUR_PRICE=?,TAX =?,QUANTITY=? where P_ID=?");
   ps.setString(1, pp.getProductName());
     ps.setString(2, pp.getCompanyName());
     ps.setDouble(3, pp.getProductPrice());
     ps.setDouble(4, pp.getOurPrice());
     ps.setInt(5, pp.getTax());
     ps.setInt(6, pp.getQuantity());
     ps.setString(7, pp.getProductId());
     return ps.executeUpdate()==1;
}
public static ProductPojo itemDetail(String id) throws SQLException, ClassNotFoundException
{
    ProductPojo pp=new ProductPojo();
Connection conn=MyConnection.getConnection();
PreparedStatement ps=conn.prepareStatement("select *from products where AVAILABLE='y' and P_ID=?");
ps.setString(1, id.trim());
ResultSet rs=ps.executeQuery();
if(rs.next()==false) {
    return null;
       } 
pp.setProductId(rs.getString(1));
pp.setProductName(rs.getString(2));
pp.setCompanyName(rs.getString(3));
pp.setProductPrice(rs.getInt(4));
pp.setOurPrice(rs.getInt(5));
pp.setTax(rs.getInt(6));
pp.setQuantity(rs.getInt(7));
return pp;
}
public static boolean updateQuantity(ArrayList<ProductPojo>ar) throws SQLException, ClassNotFoundException
{
Connection conn=MyConnection.getConnection();
     PreparedStatement ps=conn.prepareStatement("update  products set QUANTITY=? where P_ID=?");
     int count=0;
     for(ProductPojo pp:ar)
     {
     ps.setInt(1, pp.getQuantity());
     ps.setString(2, pp.getProductId());
     count=count+ps.executeUpdate();
     }
     return count==ar.size();
}
}
