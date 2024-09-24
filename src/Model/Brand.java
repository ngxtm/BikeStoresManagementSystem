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
public class Brand {
    private String brandId;
    private String brandName;
    private String brandCountry;
    
    public Brand() {
        
    }

    public Brand(String brandId, String brandName, String brandCountry) {
        this.brandId = brandId;
        this.brandName = brandName;
        this.brandCountry = brandCountry;
    }

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getBrandCountry() {
        return brandCountry;
    }

    public void setBrandCountry(String brandCountry) {
        this.brandCountry = brandCountry;
    }
    
    @Override
    public String toString() {
        return String.format("|%-12s|%-14s|%-17s|", Utils.centerString(getBrandId(), 12), Utils.centerString(getBrandName(), 14), Utils.centerString(getBrandCountry(), 17));
    }
}
