/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eMart.pojo;

/**
 *
 * @author Acer
 */
public class AddReceptionistPojo {
    private String userId;
    private int passward;
    private int rePassword;
    private int userName;
    private int empId; 
    public String getUserId() {
        return userId;
    }

    public int getPassward() {
        return passward;
    }

    public int getRePassword() {
        return rePassword;
    }

    public int getUserName() {
        return userName;
    }

    public int getEmpId() {
        return empId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setPassward(int passward) {
        this.passward = passward;
    }

    public void setRePassword(int rePassword) {
        this.rePassword = rePassword;
    }

    public void setUserName(int userName) {
        this.userName = userName;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }
   
}
