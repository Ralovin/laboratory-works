package ki305.vladyka.lab2;

/**
 * Клас зберігає додаткові функції авто.
 */

public class Features {
    private boolean hasGPS;
    private boolean hasHeatedSeats;
    private int numberOfSpeakers;

    /**
     * Конструктор з параметрами.
     * @param hasGPS Чи є GPS
     * @param hasHeatedSeats Чи є підігрів сидінь
     * @param numberOfSpeakers Кількість динаміків
     */

    public Features(boolean hasGPS, boolean hasHeatedSeats, int numberOfSpeakers) {
        this.hasGPS = hasGPS;
        this.hasHeatedSeats = hasHeatedSeats;
        this.numberOfSpeakers = numberOfSpeakers;
    }
    /** @return Чи є GPS */

    public boolean getHasGPS() {
        return hasGPS;
    }
    /** @param hasGPS Встановити GPS */

    public void setHasGPS(boolean hasGPS) {
        this.hasGPS = hasGPS;
    }
     /** @return Чи є підігрів сидінь */

    public boolean getHasHeatedSeats() {
        return hasHeatedSeats;
    }
    /** @param hasHeatedSeats Встановити підігрів сидінь */

    public void setHasHeatedSeats(boolean hasHeatedSeats) {
        this.hasHeatedSeats = hasHeatedSeats;
    }
     /** @return Кількість динаміків */

    public int getNumberOfSpeakers() {
        return numberOfSpeakers;
    }
    /** @param numberOfSpeakers Встановити кількість динаміків */

    public void setNumberOfSpeakers(int numberOfSpeakers) {
        this.numberOfSpeakers = numberOfSpeakers;
    }

    
    
}