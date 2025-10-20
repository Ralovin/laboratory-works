package ki305.vladyka.lab3;

/**
 * Інтерфейс Cargo визначає базові методи
 * для завантаження та вивантаження вантажу.
 */
public interface Cargo {

    /**
     * Завантажує вантаж певної ваги.
     * @param weight Вага вантажу (кг)
     */
    void load(int weight);

    /**
     * Вивантажує частину вантажу.
     * @param weight Вага, яку потрібно вивантажити (кг)
     */
    void unload(int weight);
}
