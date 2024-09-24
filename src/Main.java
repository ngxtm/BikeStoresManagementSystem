/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import Model.*;
import Utils.*;
/**
 *
 * @author ADMIN
 */
public class Main {
    public static void main(String[] args) {
        ProductList productList = new ProductList();
        int choice;
        Utils.displayAllFileData();
        
        do {
            choice = Utils.menu();
            switch (choice) {
                case 1:
                    productList.create();
                    break;
                case 2:
                    productList.showSearchList(Inputter.getString("Enter Product Name to search: "));
                    break;
                case 3:
                    productList.update(Inputter.getString("Enter Product ID to search: "));
                    break;
                case 4:
                    productList.delete(Inputter.getString("Enter Product ID to search: "));
                    break;
                case 5:
                    productList.writeFile();
                    break;
                case 6:
                    productList.displayAll();
                    break;
                case 7:
                    Utils.displayAllFileData();
                    break;
                default:
                    Utils.goodBye();
                    break;
            }
        } while (choice < 8 && choice > 0);
    }
}
