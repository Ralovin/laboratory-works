package ki305.vladyka.lab2;

/**
 * Клас Lights представляє фари автомобіля.
 */
class Lights {
    private boolean areOn;

    private Lights() {}

    static Lights of() {
        return new Lights();
    }

    void turnOn() { areOn = true; }
    void turnOff() { areOn = false; }
    boolean areOn() { return areOn; }
}
