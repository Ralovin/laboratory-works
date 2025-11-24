package ki305.vladyka.lab5;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Клас {@code CalcWFio} забезпечує виконання обчислень,
 * збереження та зчитування результатів у текстовому та двійковому форматі.
 * 
 * <p>Використовується для демонстрації роботи з файлами у Java.
 * 
 * @author Vladyka
 * @version 1.0
 */
public class CalcWFio {
  /** Змінна для зберігання результату обчислення */
  private double result;

  /**
   * Виконує обчислення функції, використовуючи клас {@link Equations}.
   * 
   * @param x значення аргументу (у градусах)
   * @throws ArithmeticException якщо під час обчислення виникає ділення на нуль
   */
  public void calculate(double x) throws ArithmeticException {
    Equations eq = new Equations();
    result = eq.calculate(x);
  }

  /**
   * Повертає результат останнього обчислення.
   * 
   * @return результат обчислення
   */
  public double getResult() {
    return result;
  }

  /**
   * Записує результат у текстовий файл.
   * 
   * @param fileName назва файлу для запису
   */
  public void writeResTxt(String fileName) {
    try (PrintWriter f = new PrintWriter(fileName)) {
      f.printf("Результат: %.4f%n", result);
      System.out.println("Результат записано у файл " + fileName);
    } catch (IOException e) {
      System.out.println("Помилка запису у файл: " + e.getMessage());
    }
  }

  /**
   * Зчитує результат із текстового файлу.
   * 
   * @param fileName назва файлу для зчитування
   */
  public void readResTxt(String fileName) {
    try {
      File f = new File(fileName);
      if (f.exists()) {
        try (Scanner s = new Scanner(f)) {
          while (s.hasNext()) {
            if (s.hasNextDouble()) {
              result = s.nextDouble();
              System.out.println("Зчитано з файлу: " + result);
              break;
            } else {
              s.next();
            }
          }
          if (result == 0) {
            System.out.println("Попередження: у файлі не знайдено жодного числа!");
          }
        }
      } else {
        throw new FileNotFoundException("Файл " + fileName + " не знайдено");
      }
    } catch (FileNotFoundException e) {
      System.out.println("Помилка: " + e.getMessage());
    } catch (InputMismatchException e) {
      System.out.println("Помилка: у файлі немає числа типу double!");
    }
  }

  /**
   * Записує результат у двійковий файл.
   * 
   * @param fileName назва файлу для запису
   */
  public void writeResBin(String fileName) {
    try (DataOutputStream f = new DataOutputStream(new FileOutputStream(fileName))) {
      f.writeDouble(result);
      System.out.println("Результат записано у двiйковий файл " + fileName);
    } catch (IOException e) {
      System.out.println("Помилка запису у двiйковий файл: " + e.getMessage());
    }
  }

  /**
   * Зчитує результат із двійкового файлу.
   * 
   * @param fileName назва файлу для зчитування
   */
  public void readResBin(String fileName) {
    try (DataInputStream f = new DataInputStream(new FileInputStream(fileName))) {
      result = f.readDouble();
      System.out.println("Зчитано з двiйкового файлу: " + result);
    } catch (FileNotFoundException e) {
      System.out.println("Файл не знайдено: " + e.getMessage());
    } catch (IOException e) {
      System.out.println("Помилка зчитування двійкових даних: " + e.getMessage());
    }
  }
}