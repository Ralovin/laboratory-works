package ki305.vladyka.lab2;

/**
 * Клас Car представляє автомобіль з двигуном, дверима та фарами.
 * Дозволяє керувати основними компонентами автомобіля.
 * Всі дії логуються у файл log.txt.
 */
public class Car {
    private final Engine engine;
    private final Doors doors;
    private final Lights lights;
    private boolean locked;

    public Car(Engine engine, Doors doors, Lights lights) {
        this.engine = (engine != null) ? engine : Engine.of();
        this.doors = (doors != null) ? doors : Doors.of();
        this.lights = (lights != null) ? lights : Lights.of();
    }

    private boolean denyIfLocked(String action) {
        if (locked) {
            String msg = " Неможливо " + action + " — машина замкнена.";
            System.out.println(msg);
            Logger.log(msg);
            return true;
        }
        return false;
    }

    /** Заводить двигун, якщо двері зачинені */
    public void startEngine() {
        if (doors.areOpen()) {
            String msg = " Неможливо завести — дверi вiдчиненi.";
            System.out.println(msg);
            Logger.log(msg);
            return;
        }
        if (engine.isRunning()) {
            String msg = " Двигун вже працює.";
            System.out.println(msg);
            Logger.log(msg);
        } else {
            engine.start();
            String msg = " Двигун заведено.";
            System.out.println(msg);
            Logger.log(msg);
        }
    }

    /** Зупиняє двигун */
    public void stopEngine() {
        if (!engine.isRunning()) {
            String msg = " Двигун вже вимкнений.";
            System.out.println(msg);
            Logger.log(msg);
        } else {
            engine.stop();
            String msg = " Двигун зупинено.";
            System.out.println(msg);
            Logger.log(msg);
        }
    }

    /** Відкриває двері, якщо машина не замкнена */
    public void openDoors() {
        if (denyIfLocked("вiдкрити дверi")) return;
        if (doors.areOpen()) {
            String msg = " Дверi вже вiдкритi.";
            System.out.println(msg);
            Logger.log(msg);
        } else {
            doors.open();
            String msg = " Дверi вiдкрито.";
            System.out.println(msg);
            Logger.log(msg);
        }
    }

    /** Закриває двері */
    public void closeDoors() {
        if (!doors.areOpen()) {
            String msg = " Дверi вже зачиненi.";
            System.out.println(msg);
            Logger.log(msg);
        } else {
            doors.close();
            String msg = " Дверi зачинено.";
            System.out.println(msg);
            Logger.log(msg);
        }
    }

    /** Увімкнення фар */
    public void turnOnLights() {
        if (lights.areOn()) {
            String msg = " Фари вже увiмкненi.";
            System.out.println(msg);
            Logger.log(msg);
        } else {
            lights.turnOn();
            String msg = " Фари увiмкнено.";
            System.out.println(msg);
            Logger.log(msg);
        }
    }

    /** Вимкнення фар */
    public void turnOffLights() {
        if (!lights.areOn()) {
            String msg = " Фари вже вимкненi.";
            System.out.println(msg);
            Logger.log(msg);
        } else {
            lights.turnOff();
            String msg = " Фари вимкнено.";
            System.out.println(msg);
            Logger.log(msg);
        }
    }

    /** Сигналить */
    public void honk() {
        String msg = " Бi-бiп!";
        System.out.println(msg);
        Logger.log("Сигнал: " + msg);
    }

    /** Замикання машини */
    public void lock() {
        if (engine.isRunning()) {
            String msg = " Неможливо замкнути — двигун працює.";
            System.out.println(msg);
            Logger.log(msg);
            return;
        }
        if (doors.areOpen()) {
            doors.close();
            System.out.println(" Дверi зачинено.");
            Logger.log(" Дверi автоматично зачинено перед замиканням.");
        }
        if (locked) {
            String msg = " Машина вже замкнена.";
            System.out.println(msg);
            Logger.log(msg);
        } else {
            locked = true;
            String msg = " Машину замкнено.";
            System.out.println(msg);
            Logger.log(msg);
        }
    }

    /** Відмикання машини */
    public void unlock() {
        if (!locked) {
            String msg = " Машина вже вiдкрита.";
            System.out.println(msg);
            Logger.log(msg);
        } else {
            locked = false;
            String msg = " Машину вiдiмкнено.";
            System.out.println(msg);
            Logger.log(msg);
        }
    }

    /** Виводить поточний стан авто */
    public void displayStatus() {
        String status = "\n=== Стан автомобiля ===\n" +
                " Двигун: " + (engine.isRunning() ? "Працює" : "Вимкнений") + "\n" +
                " Дверi: " + (doors.areOpen() ? "Вiдкритi" : "Закритi") + "\n" +
                " Фари: " + (lights.areOn() ? "Увiмкненi" : "Вимкненi") + "\n" +
                " Замок: " + (locked ? "Замкнено" : "Вiдкрито") + "\n" +
                "========================\n";
        System.out.println(status);
        Logger.log("Перевірка стану авто:\n" + status);
    }
}
