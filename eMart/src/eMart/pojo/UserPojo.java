/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eMart.pojo;


public class UserPojo {
   private String userId;
   private String usertype;
   private String password;
   private String userName;
   private String empId;

    public String getUserId() {
        return userId;
    }

    public String getUsertype() {
        return usertype;
    }

    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmpId() {
        return empId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }
     
}
