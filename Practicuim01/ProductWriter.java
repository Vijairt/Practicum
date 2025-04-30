import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductWriter {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<String> products = new ArrayList<>();
        boolean done = false;

        System.out.println("Welcome to Product Data Entry");

        do {
            String id = SafeInput.getNonZeroLenString(in, "Enter Product ID");
            String name = SafeInput.getNonZeroLenString(in, "Enter Product Name");
            String desc = SafeInput.getNonZeroLenString(in, "Enter Product Description");
            double cost = SafeInput.getDouble(in, "Enter Product Cost");

            String record = String.format("%s, %s, %s, %.2f", id, name, desc, cost);
            products.add(record);

            done = !SafeInput.getYNConfirm(in, "Do you want to enter another product?");
        } while (!done);

        String fileName = SafeInput.getNonZeroLenString(in, "Enter the file name to save (e.g. ProductTestData.txt)");

        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            for (String product : products) {
                writer.println(product);
            }
            System.out.println("Data saved to " + fileName);
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }
}
