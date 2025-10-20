package ki305.vladyka.lab2;

import java.util.Scanner;

public class Lab2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("========== СТВОРЕННЯ АВТО ==========");
        System.out.println("1. Повнiстю дефолтне авто");
        System.out.println("2. Авто з кастомним двигуном");
        System.out.println("3. Авто з кастомними дверима");
        System.out.println("4. Авто з кастомними фарами");
        System.out.println("5. Авто з усiма своїми характеристиками");
        System.out.print(" Оберiть варiант: ");

        int type = scanner.nextInt();
        Car car;

        switch (type) {
            case 1 -> car = new Car(null, null, null);
            case 2 -> car = new Car(Engine.of(), null, null);
            case 3 -> car = new Car(null, Doors.of(), null);
            case 4 -> car = new Car(null, null, Lights.of());
            case 5 -> car = new Car(Engine.of(), Doors.of(), Lights.of());
            default -> {
                System.out.println(" Невiрний вибiр. Створено дефолтне авто.");
                car = new Car(null, null, null);
            }
        }

        int choice;
        System.out.println("\n========== МЕНЮ КЕРУВАННЯ АВТО ==========");
        System.out.println("1. Завести двигун");
        System.out.println("2. Зупинити двигун");
        System.out.println("3. Вiдкрити дверi");
        System.out.println("4. Закрити дверi");
        System.out.println("5. Увiмкнути фари");
        System.out.println("6. Вимкнути фари");
        System.out.println("7. Заблокувати машину");
        System.out.println("8. Розблокувати машину");
        System.out.println("9. Посигналити");
        System.out.println("10. Показати стан автомобiля");
        System.out.println("0. Вийти з програми");

        do {
            System.out.print("\n Введiть номер дiї (або 0 для виходу): ");
            while (!scanner.hasNextInt()) {
                System.out.print(" Введіть число: ");
                scanner.next();
            }

            choice = scanner.nextInt();
            System.out.println();

            switch (choice) {
                case 1 -> car.startEngine();
                case 2 -> car.stopEngine();
                case 3 -> car.openDoors();
                case 4 -> car.closeDoors();
                case 5 -> car.turnOnLights();
                case 6 -> car.turnOffLights();
                case 7 -> car.lock();
                case 8 -> car.unlock();
                case 9 -> car.honk();
                case 10 -> car.displayStatus();
                case 0 -> System.out.println(" Вихiд з програми.");
                default -> System.out.println("Невiрний вибiр. Спробуйте ще раз.");
            }
        } while (choice != 0);

        scanner.close();
    }
}
