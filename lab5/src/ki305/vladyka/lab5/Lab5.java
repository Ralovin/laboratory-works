package ki305.vladyka.lab5;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Головний клас {@code Lab5}, який демонструє використання {@link CalcWFio}
 * для обчислень і роботи з файлами.
 * 
 * <p>Реалізує консольний інтерфейс користувача для введення даних,
 * обчислення результату та запису/зчитування у файли.
 * 
 * @author Vladyka
 * @version 1.0
 */
public class Lab5 {
  /**
   * Точка входу в програму. Організовує введення даних користувачем,
   * обчислення результатів, запис і зчитування даних із файлів.
   * 
   * @param args аргументи командного рядка (не використовуються)
   */
  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      System.out.print("Введи число (x в градусах): ");
      double x = in.nextDouble();

      CalcWFio obj = new CalcWFio();
      obj.calculate(x);

      System.out.printf("Результат: %.4f%n", obj.getResult());

      obj.writeResTxt("textRes.txt");
      obj.writeResBin("binRes.bin");

      obj.readResTxt("textRes.txt");
      obj.readResBin("binRes.bin");

    } catch (InputMismatchException e) {
      System.out.println("Помилка типу: потрібно вводити число!");
    } catch (ArithmeticException e) {
      System.out.println("Помилка обчислення: " + e.getMessage());
    }
  }
}
