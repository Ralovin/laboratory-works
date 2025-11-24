package ki305.vladyka.lab6;

/**
 * Клас {@code Movie} представляє фільм із назвою та тривалістю.
 * <p>
 * Реалізує інтерфейс {@link Comparable}, щоб можна було порівнювати фільми
 * за тривалістю.
 * </p>
 * 
 * @author Vladyka
 * @version 1.0
 */
public class Movie implements Comparable<Movie> {
    /** Назва фільму */
    private String title;
    /** Тривалість у хвилинах */
    private int duration;

    /**
     * Конструктор для створення фільму.
     * 
     * @param title    назва фільму
     * @param duration тривалість у хвилинах
     */
    public Movie(String title, int duration) {
        this.title = title;
        this.duration = duration;
    }

    /**
     * Повертає назву фільму.
     * 
     * @return назва фільму
     */
    public String getTitle() {
        return title;
    }

    /**
     * Повертає тривалість фільму.
     * 
     * @return тривалість у хвилинах
     */
    public int getDuration() {
        return duration;
    }

    /**
     * Порівнює два фільми за тривалістю.
     * 
     * @param other інший фільм для порівняння
     * @return додатне число, якщо поточний фільм довший; від’ємне — якщо коротший; 0 — якщо однакові
     */
    public int compareTo(Movie other) {
        return this.duration - other.duration;
    }

    /**
     * Повертає рядкове представлення фільму.
     * 
     * @return рядок формату "Movie: назва, X min"
     */
    public String toString() {
        return "Movie: " + title + ", " + duration + " min";
    }
}
