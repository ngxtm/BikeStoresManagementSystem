/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import DataAccessObject.BrandDAO;
import Utils.*;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class BrandList extends HashMap<String, Brand> implements BrandDAO {

    private static final String FILE_PATH = "src/DataFile/01_Brand.txt";

    public BrandList() {
        loadBrandFromFile();
    }

    @Override
    public ArrayList<Brand> readFile() {
        ArrayList<Brand> brandList = new ArrayList<>();
        if (!Utils.ensureFileExists(FILE_PATH, "The brand file is not available. The system will create a new ones!")) {
            File file = new File(FILE_PATH);
            while (true) {
                if (isFileEmpty(file)) {
                    addBrandToFile(new Brand(Inputter.getString("Enter Brand ID: "), Inputter.getString("Enter Brand Name: "), Inputter.getString("Enter Brand Country: ")));
                    System.out.println("Do you want to continue to add brand: ");
                    if (!Utils.confirmMessage()) {
                        break;
                    }
                }
            }
            brandList = new ArrayList<>(this.values());
            loadBrandFromFile();
            writeFile(brandList);
            return brandList;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String id = parts[0].trim();
                    String name = parts[1].trim();
                    String country = parts[2].trim();
                    brandList.add(new Brand(id, name, country));
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the brand file: " + e.getMessage());
        }
        return brandList;
    }

    private void loadBrandFromFile() {
        ArrayList<Brand> brandList = readFile();
        for (Brand brand : brandList) {
            this.put(brand.getBrandId(), brand);
        }
    }

    @Override
    public void addBrandToFile(Brand brand) {
        ArrayList<Brand> brandList = readFile();
        brandList.add(brand);
        this.put(brand.getBrandId(), brand);
    }

    @Override
    public void writeFile(ArrayList<Brand> brandList) {
        Utils.ensureFileExists(FILE_PATH, "The category file is not available. The system will create a new ones!");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Brand brand : brandList) {
                writer.write(brand.getBrandId() + ", " + brand.getBrandName() + ", " + brand.getBrandCountry());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("An error occurred while writing the brand file: " + e.getMessage());
        }
    }

    @Override
    public boolean checkExists(String brandIdCheck) {
        return this.containsKey(brandIdCheck);
    }

    private boolean isFileEmpty(File file) {
        return file.length() == 0;
    }
}
