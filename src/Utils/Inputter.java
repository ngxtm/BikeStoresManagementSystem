/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import Model.*;
import java.io.IOException;
import java.util.Scanner;
import java.time.ZonedDateTime;

/**
 *
 * @author ADMIN
 */
public class Inputter {

    public static int getInt(String message) {
        int num;
        while (true) {
            try {
                System.out.print(message);
                Scanner sc = new Scanner(System.in);
                num = Integer.parseInt(sc.nextLine());
                return num;
            } catch (NumberFormatException e) {
                System.out.println("Error. Please enter number!");
            }
        }
    }

    public static double getDouble(String message) {
        double num;
        while (true) {
            try {
                System.out.print(message);
                Scanner sc = new Scanner(System.in);
                num = Double.parseDouble(sc.nextLine());
                return num;
            } catch (NumberFormatException e) {
                System.out.println("Error. Please enter number!");
            }
        }
    }

    public static String getString(String message) {
        String result;
        while (true) {
            System.out.print(message);
            Scanner sc = new Scanner(System.in);
            String tmp = sc.nextLine().trim();
//            if (!tmp.isEmpty()) {
//                result = tmp;
//                return result;
//            } else {
//                System.out.println("Error. Input cannot be empty!");
//            }
            return result = tmp;
        }
    }

    public static String getId(String message) {
        String input = null;
        while (true) {
            System.out.print(message);
            Scanner sc = new Scanner(System.in);
            input = sc.nextLine();
            if (input.isEmpty()) {
                System.out.println("Error. Input cannot be empty!");
                continue;
            }
            ProductList productList = new ProductList();
            if (productList.checkExists(input)) {
                System.out.println("Error. The product id just entered is duplicated!");
                continue;
            }
            return input;
        }
    }

    public static String getBrandId(String message) {
        String result;
        BrandList brandList = new BrandList();
        while (true) {
            System.out.print(message);
            Scanner sc = new Scanner(System.in);
            result = sc.nextLine();
            if (!brandList.checkExists(result)) {
                System.out.println("Error. You must enter a valid brand id!");
            } else {
                return result;
            }
        }
    }

    public static String getCategoryId(String message) {
        String result;
        CategoryList categoryList = new CategoryList();
        while (true) {
            System.out.print(message);
            Scanner sc = new Scanner(System.in);
            result = sc.nextLine();
            if (!categoryList.checkExists(result)) {
                System.out.println("Error. You must enter a valid category id!");
            } else {
                return result;
            }
        }
    }

    public static int getYear(String message) {
        int currentYear = ZonedDateTime.now().getYear();
        while (true) {
            try {
                System.out.print(message);
                Scanner sc = new Scanner(System.in);
                int inputYear = Integer.parseInt(sc.nextLine());
                if (inputYear < 0) {
                    System.out.println("Error: Year cannot be negative!");
                } else if (inputYear > currentYear) {
                    System.out.println("Error: The input year cannot be earlier than the current year!");
                } else {
                    return inputYear;
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid number!");
                return -1;
            }
        }
    }

    public static double getListPrice(String message) {
        double num;
        while (true) {
            try {
                System.out.print(message);
                Scanner sc = new Scanner(System.in);
                num = Double.parseDouble(sc.nextLine());
                if (num < 0) {
                    System.out.println("Error. Product List Price cannot be a negative number!");
                } else {
                    return num;
                }
            } catch (NumberFormatException e) {
                System.out.println("Error. Please enter number!");
                return -1;
            }
        }
    }
}
