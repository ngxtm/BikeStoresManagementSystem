/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import DataAccessObject.CategoryDAO;
import Utils.*;

import java.util.ArrayList;
import java.io.*;
import java.util.HashMap;

/**
 *
 * @author ADMIN
 */
public class CategoryList extends HashMap<String, Category> implements CategoryDAO {

    private static final String FILE_PATH = "src/DataFile/01_Category.txt";

    public CategoryList() {
        loadCategoryFromFile();
    }

    @Override
    public ArrayList<Category> readFile() {
        ArrayList<Category> categoryList = new ArrayList<>();
        if (!Utils.ensureFileExists(FILE_PATH, "The brand file is not available. The system will create a new ones!")) {
            File file = new File(FILE_PATH);
            while (true) {
                if (isFileEmpty(file)) {
                    addCategoryToFile(new Category(Inputter.getString("Enter Category ID: "), Inputter.getString("Enter Category Name: ")));
                    System.out.println("Do you want to continue to add brand: ");
                    if (!Utils.confirmMessage()) {
                        break;
                    }
                }
            }
            categoryList = new ArrayList<>(this.values());
            loadCategoryFromFile();
            writeFile(categoryList);
            return categoryList;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String id = parts[0];
                    String name = parts[1];
                    categoryList.add(new Category(id, name));
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the category file: " + e.getMessage());
        }
        return categoryList;
    }

    private void loadCategoryFromFile() {
        ArrayList<Category> categoryList = readFile();
        for (Category category : categoryList) {
            this.put(category.getCategoryId(), category);
        }
    }

    @Override
    public void writeFile(ArrayList<Category> categoryList) {
        Utils.ensureFileExists(FILE_PATH, "The category file is not available. The system will create a new ones!");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Category category : categoryList) {
                writer.write(category.getCategoryId() + ", " + category.getCategoryName());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("An error occurred while writing the category file: " + e.getMessage());
        }
    }

    @Override
    public void addCategoryToFile(Category category) {
        ArrayList<Category> categoryList = readFile();
        categoryList.add(category);
        this.put(category.getCategoryId(), category);
    }

    @Override
    public boolean checkExists(String categoryIdCheck) {
        return this.containsKey(categoryIdCheck);
    }

    private boolean isFileEmpty(File file) {
        return file.length() == 0;
    }
}
