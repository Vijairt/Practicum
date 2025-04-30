import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class PersonGenerator {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<String> people = new ArrayList<>();
        boolean done = false;

        System.out.println("Welcome to Person Data Entry");

        do {
            String id = SafeInput.getNonZeroLenString(in, "Enter ID");
            String firstName = SafeInput.getNonZeroLenString(in, "Enter First Name");
            String lastName = SafeInput.getNonZeroLenString(in, "Enter Last Name");
            String title = SafeInput.getNonZeroLenString(in, "Enter Title (e.g. Mr., Ms., Dr.)");
            int yearOfBirth = SafeInput.getRangedInt(in, "Enter Year of Birth", 1000, 9999);

            String record = String.format("%s, %s, %s, %s, %d", id, firstName, lastName, title, yearOfBirth);
            people.add(record);

            done = !SafeInput.getYNConfirm(in, "Do you want to enter another person?");
        } while (!done);

        // Ask for file name
        String fileName = SafeInput.getNonZeroLenString(in, "Enter the file name to save (e.g. PersonTestData.txt)");

        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            for (String person : people) {
                writer.println(person);
            }
            System.out.println("Data saved to " + fileName);
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }
}
