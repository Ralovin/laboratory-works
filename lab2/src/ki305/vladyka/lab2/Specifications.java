package ki305.vladyka.lab2;

/**
 * Клас зберігає технічні характеристики авто.
 */

public class Specifications {
    private double engineSize;
    private int horsepower;
    private String transmissionType;

    /**
     * Конструктор з параметрами.
     * @param engineSize Розмір двигуна
     * @param horsepower Кінські сили
     * @param transmissionType Тип трансмісії
     */

    public Specifications(double engineSize, int horsepower, String transmissionType) {
        this.engineSize = engineSize;
        this.horsepower = horsepower;
        this.transmissionType = transmissionType;
    }

    /** @return Розмір двигуна */
    public double getEngineSize() {
        return engineSize;
    }
    /** @param engineSize Новий розмір двигуна */

    public void setEngineSize(double engineSize) {
        this.engineSize = engineSize;
    }
    /** @return Кінські сили */

    public int getHorsepower() {
        return horsepower;
    }
    /** @param horsepower Нове значення кінських сил */

    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }
    /** @return Тип трансмісії */

    public String getTransmissionType() {
        return transmissionType;
    }
    /** @param transmissionType Новий тип трансмісії */

    public void setTransmissionType(String transmissionType) {
        this.transmissionType = transmissionType;
    }
}