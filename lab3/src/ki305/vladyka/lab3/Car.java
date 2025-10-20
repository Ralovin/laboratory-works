package ki305.vladyka.lab3;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Абстрактний клас Car — базовий для будь‑яких авто.
 * Містить двигун, двері, фари та функції керування.
 * Всі дії логуються у файл Lab3_Log.txt.
 */
public abstract class Car {
    private final Engine engine;
    private final Doors doors;
    private final Lights lights;
    private boolean locked;

    // === ЛОГУВАННЯ ===
    private void logToFile(String message) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("Lab3_Log.txt", true))) {
            writer.println(message);
        } catch (IOException e) {
            System.err.println("Помилка запису в лог: " + e.getMessage());
        }
    }

    public Car(Engine engine, Doors doors, Lights lights) {
        this.engine = engine;
        this.doors = doors;
        this.lights = lights;
        logToFile("Створено об'єкт Car iз параметрами.");
    }

    public abstract void loadCargo(int weight);

    private boolean denyIfLocked(String action) {
        if (locked) {
            String msg = " Неможливо " + action + " — машина замкнена.";
            System.out.println(msg);
            logToFile(msg);
            return true;
        }
        return false;
    }

    // ==== ENGINE ====
    public void startEngine() {
        if (doors.areOpen()) {
            String msg = " Неможливо завести — дверi вiдчиненi.";
            System.out.println(msg);
            logToFile(msg);
            return;
        }
        if (engine.isRunning()) {
            String msg = " Двигун вже працює.";
            System.out.println(msg);
            logToFile(msg);
        } else {
            engine.start();
            String msg = " Двигун заведено (" + engine.getHorsepower() + " к.с.).";
            System.out.println(msg);
            logToFile(msg);
        }
    }

    public void stopEngine() {
        if (!engine.isRunning()) {
            String msg = " Двигун вже вимкнений.";
            System.out.println(msg);
            logToFile(msg);
        } else {
            engine.stop();
            String msg = " Двигун зупинено.";
            System.out.println(msg);
            logToFile(msg);
        }
    }

    // ==== DOORS ====
    public void openDoors() {
        if (denyIfLocked("вiдкрити дверi")) return;
        if (doors.areOpen()) {
            String msg = " Дверi вже вiдкритi.";
            System.out.println(msg);
            logToFile(msg);
        } else {
            doors.open();
            String msg = " Дверi вiдкрито (" + doors.getCount() + ").";
            System.out.println(msg);
            logToFile(msg);
        }
    }

    public void closeDoors() {
        if (!doors.areOpen()) {
            String msg = " Дверi вже зачиненi.";
            System.out.println(msg);
            logToFile(msg);
        } else {
            doors.close();
            String msg = " Дверi зачинено.";
            System.out.println(msg);
            logToFile(msg);
        }
    }

    // ==== LIGHTS ====
    public void turnOnLights() {
        if (lights.areOn()) {
            String msg = " Фари вже увiмкненi.";
            System.out.println(msg);
            logToFile(msg);
        } else {
            lights.turnOn();
            String msg = " Фари увiмкнено (" + lights.getType() + ").";
            System.out.println(msg);
            logToFile(msg);
        }
    }

    public void turnOffLights() {
        if (!lights.areOn()) {
            String msg = " Фари вже вимкненi.";
            System.out.println(msg);
            logToFile(msg);
        } else {
            lights.turnOff();
            String msg = " Фари вимкнено.";
            System.out.println(msg);
            logToFile(msg);
        }
    }

    // ==== OTHER ====
    public void honk() {
        String msg = " Бi-бiп!";
        System.out.println(msg);
        logToFile("Посигналено: " + msg);
    }

    public void lock() {
        if (engine.isRunning()) {
            String msg = " Неможливо замкнути — двигун працює.";
            System.out.println(msg);
            logToFile(msg);
            return;
        }
        if (doors.areOpen()) {
            doors.close();
            String msg = " Дверi зачинено перед замиканням.";
            System.out.println(msg);
            logToFile(msg);
        }
        if (locked) {
            String msg = " Машина вже замкнена.";
            System.out.println(msg);
            logToFile(msg);
        } else {
            locked = true;
            String msg = " Машину замкнено.";
            System.out.println(msg);
            logToFile(msg);
        }
    }

    public void unlock() {
        if (!locked) {
            String msg = " Машина вже вiдкрита.";
            System.out.println(msg);
            logToFile(msg);
        } else {
            locked = false;
            String msg = " Машину вiдiмкнено.";
            System.out.println(msg);
            logToFile(msg);
        }
    }

    // ==== STATUS ====
    public void displayStatus() {
        String status = "\n=== Стан автомобiля ===\n" +
                " Двигун: " + engine.getHorsepower() + " к.с., " + (engine.isRunning() ? "Працює" : "Вимкнений") + "\n" +
                " Дверi: " + doors.getCount() + " (" + (doors.areOpen() ? "Відкритi" : "Закритi") + ")\n" +
                " Фари: " + lights.getType() + " (" + (lights.areOn() ? "Увiмкненi" : "Вимкненi") + ")\n" +
                " Замок: " + (locked ? "Замкнено" : "Вiдкрито") + "\n" +
                "========================\n";
        System.out.println(status);
        logToFile(status);
    }
}
