package ki305.vladyka.lab3;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Клас Truck — конкретна реалізація автомобіля‑вантажівки.
 * Реалізує інтерфейс Cargo.
 * Усі дії логуються у файл Lab3_Log.txt.
 */
public class Truck extends Car implements Cargo {
    private int cargoWeight;
    private final int maxCapacity;

    // === ЛОГУВАННЯ ===
    private void logToFile(String message) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("Lab3_Log.txt", true))) {
            writer.println(message);
        } catch (IOException e) {
            System.err.println("Помилка запису в лог: " + e.getMessage());
        }
    }

    public Truck(Engine engine, Doors doors, Lights lights, int maxCapacity) {
        super(engine, doors, lights);
        this.maxCapacity = maxCapacity > 0 ? maxCapacity : 3000;
        this.cargoWeight = 0;
        logToFile("Створено Truck з вантажопiдйомнiстю " + this.maxCapacity + " кг.");
    }

    @Override
    public void loadCargo(int weight) {
        if (weight <= 0) {
            String msg = " Вага має бути > 0.";
            System.out.println(msg);
            logToFile(msg);
            return;
        }
        if (cargoWeight + weight <= maxCapacity) {
            cargoWeight += weight;
            String msg = " Завантажено " + weight + " кг. Загальна вага: " + cargoWeight + " кг.";
            System.out.println(msg);
            logToFile(msg);
        } else {
            String msg = " Неможливо завантажити: перевищення вантажопідйомності!";
            System.out.println(msg);
            logToFile(msg);
        }
    }

    @Override
    public void load(int weight) {
        logToFile("Викликано метод load(" + weight + ")");
        loadCargo(weight);
    }

    @Override
    public void unload(int weight) {
        if (weight <= 0) {
            String msg = " Вага має бути > 0.";
            System.out.println(msg);
            logToFile(msg);
            return;
        }
        if (weight <= cargoWeight) {
            cargoWeight -= weight;
            String msg = " Вивантажено " + weight + " кг. Залишок: " + cargoWeight + " кг.";
            System.out.println(msg);
            logToFile(msg);
        } else {
            String msg = " Неможливо вивантажити бiльше, нiж є у вантажiвцi!";
            System.out.println(msg);
            logToFile(msg);
        }
    }

    public void displayTruckStatus() {
        super.displayStatus();
        String msg = " Вантаж: " + cargoWeight + " кг (макс: " + maxCapacity + " кг).";
        System.out.println(msg);
        logToFile(msg);
    }
}
