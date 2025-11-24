package ki305.vladyka.lab4;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Клас {@code Lab4} є програмою-драйвером для класу {@code Equations}.
 * Виконує зчитування вхідних даних, обробку виключень
 * і запис результату у файл.
 * 
 * @author Vladyka
 * @version 1.0
 */
public class Lab4 {
    /**
     * Точка входу в програму.
     * 
     * @param args аргументи командного рядка (не використовуються)
     */
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            System.out.print("Введи число (x в градусах): ");
            double x = in.nextDouble();

            Equations eq = new Equations(); 
            double result = eq.calculate(x); 

            System.out.printf("Результат: %.4f%n", result);

            try (FileWriter fw = new FileWriter("result.txt", true);
                 PrintWriter fout = new PrintWriter(fw)) {

                fout.printf("x = %.2f градусів%n", x);
                fout.printf("Результат y = %.4f%n", result);
                fout.println("Обчислення виконано успішно ");
                fout.println("-------------------------------------");
                System.out.println("Результат записано у файл result.txt");
            }


        catch (IOException e) {
            System.out.println("Помилка запису у файл: " + e.getMessage());
        }

        } catch (InputMismatchException e) {
            System.out.println("Помилка типу: потрібно вводити число!");
        } catch (ArithmeticException e) {
            System.out.println("Помилка обчислення: " + e.getMessage());
        }
    }
}
