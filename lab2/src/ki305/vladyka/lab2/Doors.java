package ki305.vladyka.lab2;

/**
 * Клас Doors представляє двері автомобіля.
 */
class Doors {
    private boolean areOpen;

    private Doors() {}

    static Doors of() {
        return new Doors();
    }

    void open() { areOpen = true; }
    void close() { areOpen = false; }
    boolean areOpen() { return areOpen; }
}
