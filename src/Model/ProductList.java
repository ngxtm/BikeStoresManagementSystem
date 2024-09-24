/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import DataAccessObject.*;
import Utils.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 *
 * @author ADMIN
 */
public class ProductList extends HashMap<String, Product> implements ProductDAO {

    public static final String FILE_PATH = "src/DataFile/01_Product.txt";

    public ProductList() {
        loadProductsFromFile();
    }

    @Override
    public Product create() {
        Product product = new Product();

        product.setProductId(Inputter.getId("Enter Product ID: "));
        product.setProductName(Inputter.getString("Enter Product Name: "));
        product.setBrandId(Inputter.getBrandId("Enter Brand ID: "));
        product.setCategoryId(Inputter.getCategoryId("Enter Category ID: "));
        product.setProductModelYear(Inputter.getYear("Enter Product Model Year: "));
        product.setProductListPrice(Inputter.getListPrice("Enter Product List Price: "));

        this.put(product.getProductId(), product);
        return product;
    }

    private ArrayList<Product> searchProductByName(String searchString) {
        ArrayList<Product> productList = new ArrayList<>();
        for (Product product : this.values()) {
            if (product.getProductName().toLowerCase().contains(searchString.toLowerCase().trim())) {
                productList.add(product);
            }
        }
        return productList;
    }

//    private Product searchProductById(String searchId) {
//        Product resultProduct = null;
//        for (Product product : this.values()) {
//            if (product.getProductId().equals(searchId)) {
//                resultProduct = product;
//            }
//        }
//        return resultProduct;
//    }

    @Override
    public void showSearchList(String searchString) {
        ArrayList<Product> productList = searchProductByName(searchString);
        Utils.displayWithBox(productList);
    }

    @Override
    public boolean update(String productIdCheck) {
        Product product = this.get(productIdCheck);
        if (product == null) {
            System.out.println("Product does not exist!");
            return false;
        }
        
        String newProductName = Inputter.getString("Enter New Product Name (blank to skip): ");
        String newBrandId = Inputter.getString("Enter New Brand ID (blank to skip): ");
        String newCategoryId = Inputter.getString("Enter New Category ID (blank to skip): ");
        int newModelYear = Inputter.getYear("Enter New Product Model Year (blank to skip): ");
        double newListPrice = Inputter.getListPrice("Enter New Product List Price (blank to skip): ");

        if (!newProductName.trim().isEmpty()) {
            product.setProductName(newProductName);
        }
        if (!newBrandId.trim().isEmpty()) {
            product.setBrandId(newBrandId);
        }
        if (!newCategoryId.trim().isEmpty()) {
            product.setCategoryId(newCategoryId);
        }
        if (newModelYear >= 0) {
            product.setProductModelYear(newModelYear);
        }
        if (newListPrice >= 0) {
            product.setProductListPrice(newListPrice);
        }

        this.put(product.getProductId(), product);
        System.out.println("Product updated successfully!");
        return true;
    }

    @Override
    public boolean delete(String productIdCheck) {
        Product product = this.get(productIdCheck);
        if (product == null) {
            System.out.println("Product does not exist!");
            return false;
        }
        if (Utils.confirmMessage()) {
            this.remove(productIdCheck);
            System.out.println("Product remove successfully!");
            return true;
        }
            System.out.println("Product remove fail!");
            return true;
    }

    @Override
    public ArrayList<Product> readFile() {
        Utils.ensureFileExists(FILE_PATH, "The brand file is not available. The system will create a new ones!");
        ArrayList<Product> productList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 6) {
                    String id = parts[0].trim();
                    String name = parts[1].trim();
                    String brandId = parts[2].trim();
                    String categoryId = parts[3].trim();
                    int productModelYear = Integer.parseInt(parts[4].trim());
                    double productListPrice = Double.parseDouble(parts[5].trim());
                    productList.add(new Product(id, name, brandId, categoryId, productModelYear, productListPrice));
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the product file: " + e.getMessage());
        }
        return productList;
    }

    private void loadProductsFromFile() {
        ArrayList<Product> productList = readFile();
        for (Product product : productList) {
            this.put(product.getProductId(), product);
        }
    }

    @Override
    public void writeFile() {
        Utils.ensureFileExists(FILE_PATH, "The brand file is not available. The system will create a new ones!");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Product product : this.values()) {
                writer.write(product.getProductId() + ", " + product.getProductName() + ", " + product.getBrandId() + ", " + product.getCategoryId() + ", " + String.valueOf(product.getProductModelYear()) + ", " + String.valueOf(product.getProductListPrice()));
                writer.newLine();
            }
            System.out.println("Write to file successfully!");
        } catch (IOException e) {
            System.out.println("An error occurred while writing the product file: " + e.getMessage());
        }
    }

    @Override
    public boolean checkExists(String productIdCheck) {
        return this.containsKey(productIdCheck);
    }

    @Override
    public void displayAll() {
        loadProductsFromFile();
        Utils.ensureFileExists(FILE_PATH, "The product file is not available. The system will create a new ones!");
        ArrayList<Product> productList = new ArrayList<>(this.values());
        Collections.sort(productList, (Product p1, Product p2) -> {
            int priceCompare = Double.compare(p2.getProductListPrice(), p1.getProductListPrice());
            if (priceCompare != 0) {
                return priceCompare;
            } else {
                return p1.getProductName().compareTo(p2.getProductName());
            }
        });
        Utils.displayWithBox(productList);
    }
    
    
    
    
}
