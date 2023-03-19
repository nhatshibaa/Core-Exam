package org.example.service;

import org.example.entity.Product;
import org.example.util.FileHelper;

import java.util.ArrayList;
import java.util.Scanner;

public class ProductService {
    public static int id = 1;
    Scanner scanner = new Scanner(System.in);

    public void getAllProduct() {
        FileHelper.readFileTxt();
    }

    public void addProduct() {
        ArrayList<Product> productList = new ArrayList<>();
        Product product = new Product();
        product.setId(id++);
        System.out.println("Enter name product: ");
        product.setName(scanner.nextLine());
        System.out.println("Enter nsx product: ");
        product.setNsx(scanner.nextLine());
        System.out.println("Enter category product: ");
        product.setCategory(scanner.nextLine());
        System.out.println("Enter price product: ");
        product.setPrice(scanner.nextDouble());
        productList.add(product);
        FileHelper.writeRowFileTxt(productList);
    }

    public void updateProduct(){
        System.out.println("Enter id product: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Product product = FileHelper.findById(id);
        if (product == null) {
            System.out.println("Not found product");
        }else {
            System.out.println("Enter name product update: ");
            product.setName(scanner.nextLine());
            System.out.println("Enter nsx product update: ");
            product.setNsx(scanner.nextLine());
            System.out.println("Enter category product update: ");
            product.setCategory(scanner.nextLine());
            System.out.println("Enter price product update: ");
            product.setPrice(scanner.nextDouble());
            FileHelper.updateRowFileTxt(product, id);
        }
    }

    public void searchProduct() {
        System.out.println("Enter value to search: ");
        FileHelper.searchByValue(scanner.nextLine());
    }

    public void deleteProduct() {
        System.out.println("Enter id product: ");
        FileHelper.deleteRowFileTxt(scanner.nextInt());
    }

    public static void generateMenu() {
        ProductService productService = new ProductService();
        Scanner scanner = new Scanner(System.in);
        int choice;
        while (true) {
            System.out.println("---------------MENU---------------");
            System.out.println("1. Show all product");
            System.out.println("2. Add product");
            System.out.println("3. Update product");
            System.out.println("4. Search product");
            System.out.println("5. Delete product");
            System.out.println("0. Exit");
            System.out.println("----------------------------------");
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    productService.getAllProduct();
                    break;
                case 2:
                    productService.addProduct();
                    break;
                case 3:
                    productService.updateProduct();
                    break;
                case 4:
                    productService.searchProduct();
                    break;
                case 5:
                    productService.deleteProduct();
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("No choice!");
            }
        }
    }
}
