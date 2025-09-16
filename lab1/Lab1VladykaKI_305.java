import java.io.PrintWriter;
import java.util.Scanner;
import java.io.FileNotFoundException;

/**
 * The Lab1VladykaKI_305 class builds a figure in the form of an hourglass
 * using a character entered by the user and saves it to a file.
 *
 * Demonstrates keyboard input, figure generation, and file output.
 * 
 * @author Yura Vladyka
 * @version 1.0
 */
public class Lab1VladykaKI_305 {

    /**
     * The main method of the program.
     * Reads a number and a character from the user, builds a figure, and saves it to a file.
     *
     * @param args Command-line arguments (not used)
     */
    public static void main(String[] args) {

        System.out.print("Enter a number: ");
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        sc.nextLine(); // read the leftover newline

        System.out.print("Enter a character: ");
        String sym = sc.nextLine();
        
        // Check that only one character is entered
        if (sym.length() == 0 || sym.length() > 1) {
            System.out.println("Error: Invalid character");
            System.exit(1);
        }

        try {
            // Create a file for output
            PrintWriter fout = new PrintWriter("MyFile.txt");

            // Upper part of the figure
            for (int i = 0; i < (number + 1) / 2; i++) {
                for (int j = 0; j < i; j++) {
                    System.out.print(" ");
                    fout.print(" ");
                }
                for (int k = 0; k < number - (2 * i); k++) {
                    System.out.print(sym);
                    fout.print(sym);
                }
                System.out.println();
                fout.println();
            }

            // Lower part of the figure
            for (int i = (number - 1) / 2 - 1; i >= 0; i--) {
                for (int j = 0; j < i; j++) {
                    System.out.print(" ");
                    fout.print(" ");
                }
                for (int k = 0; k < number - (2 * i); k++) {
                    System.out.print(sym);
                    fout.print(sym);
                }
                System.out.println();
                fout.println();
            }

            fout.close();
            System.out.println("The result has been saved to a file");
        } catch (FileNotFoundException e) {
            System.out.println("Error: Failed to create the file");
        }

        sc.close();
    }
}
