/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DataAccessObject;

import Model.Category;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public interface CategoryDAO {
    public ArrayList<Category> readFile();
    public void writeFile(ArrayList<Category> categoryList);
    public void addCategoryToFile(Category brand);
    public boolean checkExists(String categoryIdCheck);
}
