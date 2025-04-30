import javax.swing.JFileChooser;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ProductReader {
    public static void main(String[] args) {
        Scanner fileScanner;
        File selectedFile;
        JFileChooser chooser = new JFileChooser();

        System.out.println("Please choose a product data file...");

        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            selectedFile = chooser.getSelectedFile();

            try {
                fileScanner = new Scanner(selectedFile);

                // Print header
                System.out.printf("%-10s %-15s %-30s %-10s%n", "ID", "Name", "Description", "Cost");
                System.out.println("======================================================================");

                // Read and display each line
                while (fileScanner.hasNextLine()) {
                    String line = fileScanner.nextLine();
                    String[] parts = line.split(",\\s*");

                    if (parts.length == 4) {
                        String id = parts[0];
                        String name = parts[1];
                        String desc = parts[2];
                        String cost = parts[3];

                        System.out.printf("%-10s %-15s %-30s %-10s%n", id, name, desc, cost);
                    } else {
                        System.out.println("Invalid record: " + line);
                    }
                }

                fileScanner.close();
            } catch (FileNotFoundException e) {
                System.out.println("File not found: " + e.getMessage());
            }
        } else {
            System.out.println("No file selected. Exiting.");
        }
    }
}
