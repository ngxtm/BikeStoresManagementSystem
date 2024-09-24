/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import Model.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Utils {

    public static int menu() {
        int result;
        String message = """
                         
                                ---------------------------------------------
                                1. Add Product.
                                2. Search product by product name.
                                3. Update product.
                                4. Delete product.
                                5. Save products to file.
                                6. Print list products from the file.
                                7. Print list file data (Product, Brand, Category).
                                Others - Quit.
                                ---------------------------------------------
                                Enter your choice: 
                                """;
        return result = Inputter.getInt(message);
    }

    public static void displayWithBox(ArrayList<Product> productList) {
        if (!productList.isEmpty()) {
            System.out.print("""
                           |------------------------------------------------------------------------------------------|
                           |  Product ID  |  Product Name  |  Brand ID  |  Category ID  |  Model Year  |  List Price  |
                           """);
            for (Product product : productList) {
                System.out.println(product);
            }
            System.out.println("""
                           |------------------------------------------------------------------------------------------|
                           """);
        } else {
            System.out.println("Have no any Product");
        }
    }

    public static void displayAllFileData() {
        BrandList brandList = new BrandList();
        ProductList productList = new ProductList();
        System.out.println("WELCOME TO MY BIKE STORES MANAGEMENT SYSTEM!");
        productList.displayAll();

        ArrayList<Brand> brandArray = new ArrayList<>(brandList.readFile());
        String brand_header = """
                              |---------------------------------------------|
                              |  Brand ID  |  Brand Name  |  Brand Country  |
                              """;
        String brand_footer = """
                              |---------------------------------------------|
                              """;
        System.out.println("|------------- Brand File's Data -------------|");
        System.out.print(brand_header);
        for (Brand brand : brandArray) {
            System.out.println(brand);
        }
        System.out.println(brand_footer);

        CategoryList categoryList = new CategoryList();
        ArrayList<Category> categoryArray = new ArrayList<>(categoryList.readFile());
        String category_header = """
                                 |---------------------------------|
                                 |  Category ID  |  Category Name  |
                                 """;
        String category_footer = """
                                 |---------------------------------|
                                 """;
        System.out.println("|----- Category File's Data ------|");
        System.out.print(category_header);
        for (Category category : categoryArray) {
            System.out.println(category);
        }
        System.out.println(category_footer);
    }

    public static String centerString(String s, int size) {
        if (s == null || size <= s.length()) {
            return s;
        }
        int padding = size - s.length();
        int padStart = padding / 2;
        int padEnd = padding - padStart;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < padStart; i++) {
            sb.append(" ");
        }
        sb.append(s);
        for (int i = 0; i < padEnd; i++) {
            sb.append(" ");
        }
        return sb.toString();
    }

    public static String centerInt(int value, int size) {
        return centerString(Integer.toString(value), size);
    }

    public static String centerDouble(double value, int size, int decimalPlaces) {
        String formatString = "%." + decimalPlaces + "f";
        String formattedValue = String.format(formatString, value);
        return centerString(formattedValue, size);
    }

    public static boolean confirmMessage() {
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Are you sure ? Enter Y/N (Yes/No): ");
            String input = sc.nextLine().trim().toLowerCase();
            if (input.equals("y")) {
                return true;
            }
            if (input.equals("n")) {
                return false;
            }
            System.out.println("Error. Please enter Y or N: ");
        }
    }

    public static boolean ensureFileExists(String FILE_PATH, String errorMessage) {
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            try {
                System.out.println(errorMessage);
                file.createNewFile();
                return false;
            } catch (IOException e) {
                Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return true;
    }

    public static void goodBye() {
        String message = """
                         
                         
                                   ~Y55Y?^    @J.&@J#&J.  ^Y#J????J.     .??~    .?J^    !YPP5?^    :??     !J~        .75PP5!.      ~Y5Y!!:      .^7Y~:^.    ^77.    ^7~       
                                 7@@Y7@@Y7@@ .57!^:^:!?.  P@B?JJYY5:      7@@Y  :&@G  .~?#Y!7J#@B^  ?@@:    &@B       Y@#?!!Y&@Y  .7^!?~~:Y#J.  .75Y7~:^5BY.  J&&&~   G@B       
                                 !&B^.   :^.  !7^        .&@J ....         ^&@J.&@J   P&B.     5@#. Y@@:    #@B       B@B^.  .^:  G@G      JG7  YB!      5#P  ?&BG@J  G@B       
                                  ^7?JPY#J    @J.&@!?J!  .PPPPGGPGJ         .B&&&7    #&Y      ^&&~ J@@.    B@#       .JGB&&#B5^ .&&J      ^5J. JB~      :GG: Y&P Y&5 P@B       
                                         7@@  Y#J         YP~                .#&Y     5&#.     Y@&. 7@&:    B&G       ::.  .:?&&~ B@G      7PY  !G5      ?BG  5&P  ^GJ5#G       
                                 ^#&Y~::^Y#J  ^~^:@J.&@: .#&P7??JJY!         .#&J      Y&#J!!?B&B^  .B@#?!!5&B^       7BB?~^~YB5. .?5J~::^!J!.   7BP!^:!B#5.  5@G   :#@&G       
                                   7@@YY#:    @J.&@J#&J   @J.&@J#&J:          ~7:       .!Y55Y?^      ^?YYJ7^          .G@J!~^.     .:Y#J~:.      .^!?JJ7:    ^?~    .7?~                                 
                         """;
        System.out.println(message);
    }
}
