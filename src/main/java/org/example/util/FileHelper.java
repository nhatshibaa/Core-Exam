package org.example.util;

import org.example.entity.Product;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FileHelper {
    public static final String PATH = "src\\main\\product.txt";

    public static File checkFile() {
        File file = new File(PATH);
        if (!file.exists()) {
            throw new RuntimeException("File not found");
        }else {
            return file;
        }
    }

    public static void readFileTxt() {
        try {
            File file = new File(PATH);
            if (!file.exists()) {
                throw new RuntimeException("File not found");
            }
            FileReader fileReader = new FileReader(PATH);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String result = null;
            while ((result = bufferedReader.readLine()) != null) {
                System.out.println(result);
            }
            bufferedReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void writeRowFileTxt(ArrayList<Product> products) {
        try {
            File file = checkFile();
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream));
            for (Product product : products) {
                bufferedWriter.write(product.toString() + System.lineSeparator());
            }
            bufferedWriter.close();
            System.out.println("Add product success");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void deleteRowFileTxt(Integer id) {
        try {
            File file = checkFile();
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String result = null;
            while ((result = bufferedReader.readLine()) != null) {
                if (result.contains(id.toString())) {
                    result = result.replace(result, "");
                    System.out.println("Delete success");
                } else {
                    System.out.println("Delete fail");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void updateRowFileTxt(Product product, Integer id) {
        try {
            File file = checkFile();
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String result = null;
            while ((result = bufferedReader.readLine()) != null) {
                String[] data = result.split("-");
                if (data[0].trim().equals(id.toString())) {
                    data[1] = product.getName();
                    data[2] = product.getNsx();
                    data[3] = product.getCategory();
                    data[4] = product.getPrice().toString();
                    result = result.replace(result, Arrays.toString(data));

                    System.out.println("Update Success");
                } else {
                    System.out.println("không trùng: ");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void searchByValue(String value) {
        try {
            File file = checkFile();
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String result = null;
            while ((result = bufferedReader.readLine()) != null) {
                if (result.contains(value)) {
                    System.out.println(result);
                } else {
                    System.out.println("Not found");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Product findById(Integer id) {
        try {
            File file = checkFile();
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String result = null;
            while ((result = bufferedReader.readLine()) != null) {
                String[] data = result.split("-");
                if (data[0].trim().equals(id.toString())) {
                    return new Product(Integer.parseInt(data[0].trim()), data[1].trim(), data[2].trim(), data[3].trim(), Double.parseDouble(data[4].trim()));
                } else {
                    System.out.println("Not found");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}