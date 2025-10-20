package ki305.vladyka.lab3;

/**
 * Клас Doors описує двері автомобіля —
 * їх кількість та стан (відкриті / закриті).
 */
class Doors {
    private boolean areOpen;
    private int count;

    /**
     * Конструктор за замовчуванням (2 двері, зачинені).
     */
    public Doors() {          
        this.count = 2;
        this.areOpen = false;
    }

    /**
     * Конструктор із заданою кількістю дверей.
     * @param count Кількість дверей
     */
    public Doors(int count) { 
        this.count = count;
        this.areOpen = false;
    }

    /** Відкриває двері. */
    void open() { areOpen = true; }

    /** Зачиняє двері. */
    void close() { areOpen = false; }

    /** @return true, якщо двері відкриті */
    boolean areOpen() { return areOpen; }

    /** @return кількість дверей */
    int getCount() { return count; }
}
