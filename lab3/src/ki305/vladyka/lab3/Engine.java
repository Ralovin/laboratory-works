package ki305.vladyka.lab3;

/**
 * Клас Engine описує двигун автомобіля —
 * його потужність та стан (працює / вимкнений).
 */
class Engine {
    private boolean isRunning;
    private int horsepower;

    /**
     * Конструктор за замовчуванням (100 к.с., двигун вимкнений).
     */
    public Engine() {              
        this.horsepower = 100;
        this.isRunning = false;
    }

    /**
     * Конструктор з вказаною потужністю.
     * @param horsepower Потужність двигуна (к.с.)
     */
    public Engine(int horsepower) { 
        this.horsepower = horsepower;
        this.isRunning = false;
    }

    /** Запускає двигун. */
    void start() { isRunning = true; }

    /** Зупиняє двигун. */
    void stop() { isRunning = false; }

    /** @return true, якщо двигун працює */
    boolean isRunning() { return isRunning; }

    /** @return потужність двигуна (к.с.) */
    int getHorsepower() { return horsepower; }
}
