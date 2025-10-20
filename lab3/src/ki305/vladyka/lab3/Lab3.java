package ki305.vladyka.lab3;

import java.util.Scanner;

/**
 * Головний клас програми Lab3.
 * Демонструє створення вантажівки за допомогою Builder
 * та керування її компонентами через консольне меню.
 */
public class Lab3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TruckBuilder builder = new TruckBuilder();

        // === ВИБІР КОМПОНЕНТІВ ===
        System.out.println("Оберiть двигун:");
        System.out.println("1. Дефолтний (100 к.с.)");
        System.out.println("2. Кастомний");
        int choice = readInt(sc, "Ваш вибiр: ");
        if (choice == 1) builder.withDefaultEngine();
        else {
            int hp = readInt(sc, "Введiть потужнiсть двигуна: ");
            builder.withCustomEngine(hp);
        }

        System.out.println("\nОберiть дверi:");
        System.out.println("1. Дефолтнi (2 дверi)");
        System.out.println("2. Кастомнi");
        choice = readInt(sc, "Ваш вибiр: ");
        if (choice == 1) builder.withDefaultDoors();
        else {
            int d = readInt(sc, "Введiть кiлькiсть дверей: ");
            builder.withCustomDoors(d);
        }

        System.out.println("\nОберiть фари:");
        System.out.println("1. Дефолтнi (Галогеннi)");
        System.out.println("2. Кастомнi");
        choice = readInt(sc, "Ваш вибiр: ");
        if (choice == 1) builder.withDefaultLights();
        else {
            System.out.print("Введiть тип фар (LED/Xenon/...): ");
            String type = sc.next();
            builder.withCustomLights(type);
        }

        int capacity = readInt(sc, "\nВкажiть вантажопiдйомнiсть (0 = дефолт 3000 кг): ");
        if (capacity > 0) builder.withCapacity(capacity);

        // === СТВОРЕННЯ ВАНТАЖІВКИ ===
        Truck truck = builder.build();

        // === МЕНЮ ===
        System.out.println("\n========== МЕНЮ КЕРУВАННЯ ВАНТАЖIВКОЮ ==========");
        System.out.println("1. Завести двигун");
        System.out.println("2. Зупинити двигун");
        System.out.println("3. Вiдкрити дверi");
        System.out.println("4. Закрити дверi");
        System.out.println("5. Увiмкнути фари");
        System.out.println("6. Вимкнути фари");
        System.out.println("7. Завантажити вантаж");
        System.out.println("8. Вивантажити вантаж");
        System.out.println("9. Посигналити");
        System.out.println("10. Замкнути авто");
        System.out.println("11. Вiдiмкнути авто");
        System.out.println("12. Показати стан вантажiвки");
        System.out.println("0. Вийти з програми");

        int action;
        do {
            action = readInt(sc, "\n Введiть номер дiї: ");
            switch (action) {
                case 1 -> truck.startEngine();
                case 2 -> truck.stopEngine();
                case 3 -> truck.openDoors();
                case 4 -> truck.closeDoors();
                case 5 -> truck.turnOnLights();
                case 6 -> truck.turnOffLights();
                case 7 -> {
                    int w = readInt(sc, " Введiть вагу для завантаження: ");
                    truck.load(w);
                }
                case 8 -> {
                    int w = readInt(sc, " Введiть вагу для вивантаження: ");
                    truck.unload(w);
                }
                case 9 -> truck.honk();
                case 10 -> truck.lock();
                case 11 -> truck.unlock();
                case 12 -> truck.displayTruckStatus();
                case 0 -> System.out.println(" Вихiд з програми.");
                default -> System.out.println(" Невiрний вибiр. Спробуйте ще раз.");
            }
        } while (action != 0);

        sc.close();
    }

    /**
     * Зчитує ціле число з консолі з перевіркою коректності.
     * @param sc Сканер введення
     * @param prompt Текст запиту
     * @return Введене число
     */
    private static int readInt(Scanner sc, String prompt) {
        System.out.print(prompt);
        while (!sc.hasNextInt()) {
            System.out.print(" Введiть число: ");
            sc.next();
        }
        return sc.nextInt();
    }
}
