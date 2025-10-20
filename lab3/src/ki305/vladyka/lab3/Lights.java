package ki305.vladyka.lab3;

/**
 * Клас Lights описує систему освітлення автомобіля —
 * тип фар і стан (увімкнено / вимкнено).
 */
class Lights {
    private boolean areOn;
    private String type;

    /**
     * Конструктор за замовчуванням (тип: "Галогенні").
     */
    public Lights() {              
        this.type = "Галогеннi";
        this.areOn = false;
    }

    /**
     * Конструктор із заданим типом фар.
     * @param type Тип фар (наприклад, LED, Xenon)
     */
    public Lights(String type) {   
        this.type = type;
        this.areOn = false;
    }

    /** Вмикає фари. */
    void turnOn() { areOn = true; }

    /** Вимикає фари. */
    void turnOff() { areOn = false; }

    /** @return true, якщо фари увімкнені */
    boolean areOn() { return areOn; }

    /** @return тип фар */
    String getType() { return type; }
}
