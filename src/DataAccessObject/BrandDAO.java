/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DataAccessObject;

import Model.Brand;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public interface BrandDAO {
    public ArrayList<Brand> readFile();
    public void writeFile(ArrayList<Brand> brandList);
    public void addBrandToFile(Brand brand);
    public boolean checkExists(String brandIdCheck);
}
