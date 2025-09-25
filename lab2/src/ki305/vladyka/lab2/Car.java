package ki305.vladyka.lab2;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Клас представляє автомобіль з зовнішнім виглядом, характеристиками та функціями.
 */

public class Car {
    private Appearance carAppearance;
    private Specifications carSpecifications;
    private Features carFeatures;

    private void logToFile(String message) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("Laba2.txt", true))) {
            writer.println(message);
        } catch (IOException e) {
            System.err.println("Помилка запису в файл протоколу: " + e.getMessage());
        }
    }

    /**
     * Конструктор без параметрів.
     */

    public Car() {
        carAppearance = new Appearance("Unspecified", "Unspecified", false);
        carSpecifications = new Specifications(0.0, 0, "Unspecified");
        carFeatures = new Features(false, false, 0);
        logToFile("Об'єкт Car створено з використанням конструктора за замовчуванням.");
    }

    /**
     * Конструктор з параметрами.
     * @param carAppearance Зовнішній вигляд
     * @param carSpecifications Характеристики
     * @param carFeatures Функції
     */

    public Car(Appearance carAppearance, Specifications carSpecifications, Features carFeatures) {
        this.carAppearance = carAppearance;
        this.carSpecifications = carSpecifications;
        this.carFeatures = carFeatures;
        logToFile("Об'єкт Car створено з використанням користувацького конструктора.");
    }

    /**
     * Повертає зовнішній вигляд.
     * @return Об'єкт Appearance
     */

    public Appearance getCarAppearance() {
        logToFile("Викликано метод getCarAppearance.");
        return carAppearance;
    }

    /**
     * Повертає характеристики.
     * @return Об'єкт Specifications
     */

    public Specifications getCarSpecifications() {
        logToFile("Викликано метод getCarSpecifications.");
        return carSpecifications;
    }

     /**
     * Повертає функції.
     * @return Об'єкт Features
     */
    public Features getCarFeatures() {
        logToFile("Викликано метод getCarFeatures.");
        return carFeatures;
    }
    /**
     * Встановлює новий зовнішній вигляд.
     * @param carAppearance Новий зовнішній вигляд
     */

    public void setCarAppearance(Appearance carAppearance) {
        logToFile("Викликано метод setCarAppearance. Встановлено новий зовнiшнiй вигляд.");
        this.carAppearance = carAppearance;
    }
    /**
     * Встановлює нові характеристики.
     * @param carSpecifications Нові характеристики
     */

    public void setCarSpecifications(Specifications carSpecifications) {
        logToFile("Викликано метод setCarSpecifications. Встановлено новi характеристики.");
        this.carSpecifications = carSpecifications;
    }
    /**
     * Встановлює нові функції.
     * @param carFeatures Нові функції
     */

    public void setCarFeatures(Features carFeatures) {
        logToFile("Викликано метод setCarFeatures. Встановлено новi функцiї.");
        this.carFeatures = carFeatures;
    }
    /**
     * Змінює колір авто.
     * @param newColor Новий колір
     */

    public void changeColor(String newColor) {
        logToFile("Змiна кольору автомобiля з '" + carAppearance.getColor() + "' на '" + newColor + "'.");
        carAppearance.setColor(newColor);
    }
    /**
     * Змінює тип трансмісії.
     * @param newTransmission Новий тип
     */

    public void changeTransmissionType(String newTransmission) {
        logToFile("Змiна типу трансмiсiї з '" + carSpecifications.getTransmissionType() + "' на '" + newTransmission + "'.");
        carSpecifications.setTransmissionType(newTransmission);
    }
    /**
     * Виводить інформацію про авто.
     */

    public void displayCarInfo() {
        logToFile("Викликано метод displayCarInfo. Виведення iнформацiї про автомобiль.");
        System.out.println("--- Вiдображення iнформацiї про автомобiль ---");
        System.out.println("Колiр: " + carAppearance.getColor());
        System.out.println("Тип кузова: " + carAppearance.getBodyType());
        System.out.println("Люк: " + (carAppearance.getHasSunroof() ? "Так" : "Ні"));
        System.out.println("Об'єм двигуна: " + carSpecifications.getEngineSize() + "л");
        System.out.println("Кiнськi сили: " + carSpecifications.getHorsepower() + " к.с.");
        System.out.println("Трансмiсiя: " + carSpecifications.getTransmissionType());
        System.out.println("GPS: " + (carFeatures.getHasGPS() ? "Так" : "Ні"));
        System.out.println("Пiдiгрiв сидiнь: " + (carFeatures.getHasHeatedSeats() ? "Так" : "Нi"));
        System.out.println("Кiлькiсть динамiкiв: " + carFeatures.getNumberOfSpeakers());
        System.out.println("--------------------------------");
    }
    /**
     * Виводить інформацію про наявність GPS.
     */
    public void hasGPS() {
        logToFile("Викликано метод hasGPS. Результат: " + carFeatures.getHasGPS());
    }
}