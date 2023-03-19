package org.example.util;

import org.example.entity.Product;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class FileHelperTest {

    @org.junit.jupiter.api.Test
    void writeRowFileTxt() {
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product(1, "Iphone 12", "Apple", "Mobile", 1000.0));
        products.add(new Product(2, "Iphone 13", "Apple", "MAC", 1000.0));
        products.add(new Product(3, "Iphone 14", "Apple", "Mobile", 1000.0));
        products.add(new Product(4, "Iphone 15", "Apple", "Mobile", 1000.0));
        products.add(new Product(5, "Iphone 17", "Apple", "MAC", 1000.0));
        FileHelper.writeRowFileTxt(products);
    }

    @Test
    void deleteRowFileTxt() {
        FileHelper.deleteRowFileTxt(1);
    }

    @Test
    void readFileTxt() {
        FileHelper.readFileTxt();
    }

    @Test
    void updateRowFileTxt() {

    }

    @Test
    void searchRowFileTxt() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter value field search: ");
        FileHelper.searchByValue(scanner.nextLine());
    }
}