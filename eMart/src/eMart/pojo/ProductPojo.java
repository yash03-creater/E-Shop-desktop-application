/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eMart.pojo;


public class ProductPojo {
    private String productId;
    private String productName;
    private String companyName;
    private double productPrice;
    private double ourPrice;
    private int tax;
public ProductPojo()
{
          
}
    public ProductPojo(String productId, String productName, String companyName, double productPrice, double ourPrice, int tax, int quantity) {
        this.productId = productId;
        this.productName = productName;
        this.companyName = companyName;
        this.productPrice = productPrice;
        this.ourPrice = ourPrice;
        this.tax = tax;
        this.quantity = quantity;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public void setOurPrice(double ourPrice) {
        this.ourPrice = ourPrice;
    }

    public void setTax(int tax) {
        this.tax = tax;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    private int quantity;

    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public double getOurPrice() {
        return ourPrice;
    }

    public int getTax() {
        return tax;
    }

    public int getQuantity() {
        return quantity;
    }
    
}
