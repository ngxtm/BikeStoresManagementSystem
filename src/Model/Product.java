/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Utils.Utils;
/**
 *
 * @author ADMIN
 */
public class Product {
    private String productId;
    private String productName;
    private String brandId;
    private String categoryId;
    private int productModelYear;
    private double productListPrice;
    
    public Product() {
        
    }

    public Product(String productId, String productName, String brandId, String categoryId, int productModelYear, double productListPrice) {
        this.productId = productId;
        this.productName = productName;
        this.brandId = brandId;
        this.categoryId = categoryId;
        this.productModelYear = productModelYear;
        this.productListPrice = productListPrice;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public int getProductModelYear() {
        return productModelYear;
    }

    public void setProductModelYear(int productModelYear) {
        this.productModelYear = productModelYear;
    }

    public double getProductListPrice() {
        return productListPrice;
    }

    public void setProductListPrice(double productListPrice) {
        this.productListPrice = productListPrice;
    }
    
    @Override
    public String toString() {
        return String.format("|%-14s|%-16s|%-12s|%-15s|%-14s|%-14s|", Utils.centerString(getProductId(), 14), Utils.centerString(getProductName(), 16), Utils.centerString(getBrandId(), 12), Utils.centerString(getCategoryId(), 15), Utils.centerInt(getProductModelYear(), 14), Utils.centerDouble(getProductListPrice(), 14, 2));
    }
}
