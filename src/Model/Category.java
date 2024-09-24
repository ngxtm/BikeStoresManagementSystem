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
public class Category {
    private String categoryId;
    private String categoryName;
    
    public Category() {
        
    }

    public Category(String categoryId, String categoryName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
    
    @Override
    public String toString() {
        return String.format("|%-15s|%-17s|", Utils.centerString(getCategoryId(), 15), Utils.centerString(getCategoryName(), 17));
    }
}
