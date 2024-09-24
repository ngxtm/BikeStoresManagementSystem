/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DataAccessObject;

import Model.Product;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public interface ProductDAO {
    public Product create();
    public boolean update(String productIdCheck);
    public boolean delete(String productIdCheck);
    public void showSearchList(String searchString);
    public ArrayList<Product> readFile();
    public void writeFile();
    public boolean checkExists(String productIdCheck);
    public void displayAll();
}
