import javax.swing.JFileChooser;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PersonReader {
    public static void main(String[] args) {
        Scanner fileScanner;
        File selectedFile;
        JFileChooser chooser = new JFileChooser();

        System.out.println("Please choose a file...");

        // Show dialog to choose file
        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            selectedFile = chooser.getSelectedFile();

            try {
                fileScanner = new Scanner(selectedFile);

                // Print header
                System.out.printf("%-10s %-15s %-15s %-10s %-5s%n", "ID#", "First Name", "Last Name", "Title", "YOB");
                System.out.println("==============================================================");

                // Read and display each line
                while (fileScanner.hasNextLine()) {
                    String line = fileScanner.nextLine();
                    String[] parts = line.split(",\\s*"); // split on comma + optional space

                    if (parts.length == 5) {
                        String id = parts[0];
                        String firstName = parts[1];
                        String lastName = parts[2];
                        String title = parts[3];
                        String yob = parts[4];

                        System.out.printf("%-10s %-15s %-15s %-10s %-5s%n", id, firstName, lastName, title, yob);
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

