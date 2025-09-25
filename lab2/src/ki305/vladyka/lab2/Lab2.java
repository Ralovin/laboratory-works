package ki305.vladyka.lab2;

/**
 * Головний клас для запуску програми.
 * @author Yura Vladyka
 * @version 1.0
 */

public class Lab2 {
    /**
     * Головний метод, який створює та змінює об'єкт Car.
     * @param args Аргументи командного рядка
     */
    public static void main(String[] args) {
        
        Appearance myCarAppearance = new Appearance("Blue", "Sedan", true);
        Specifications myCarSpecifications = new Specifications(2.5, 180, "Automatic");
        Features myCarFeatures = new Features(true, false, 6);

        
        Car myCar = new Car(myCarAppearance, myCarSpecifications, myCarFeatures);
        
        
        myCar.displayCarInfo();

        System.out.println("\n--- Performing actions ---\n");
        
        myCar.changeColor("Red");
        myCar.changeTransmissionType("Manual");
        
        System.out.println();
        myCar.displayCarInfo();
        
        
    }
}