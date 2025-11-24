package ki305.vladyka.lab6;

/**
 * Клас {@code Book} представляє книгу з назвою та кількістю сторінок.
 * <p>
 * Реалізує інтерфейс {@link Comparable}, щоб можна було порівнювати книги
 * за кількістю сторінок.
 * </p>
 * 
 * @author Vladyka
 * @version 1.0
 */
public class Book implements Comparable<Book> {
    /** Назва книги */
    private String title;
    /** Кількість сторінок */
    private int pages;

    /**
     * Конструктор для створення книги з назвою та кількістю сторінок.
     * 
     * @param title назва книги
     * @param pages кількість сторінок
     */
    public Book(String title, int pages) {
        this.title = title;
        this.pages = pages;
    }

    /**
     * Повертає назву книги.
     * 
     * @return назва книги
     */
    public String getTitle() {
        return title;
    }

    /**
     * Повертає кількість сторінок книги.
     * 
     * @return кількість сторінок
     */
    public int getPages() {
        return pages;
    }

    /**
     * Порівнює дві книги за кількістю сторінок.
     * 
     * @param other інша книга для порівняння
     * @return додатне число, якщо поточна книга більша; від’ємне — якщо менша; 0 — якщо однакові
     */
    public int compareTo(Book other) {
        return this.pages - other.pages;
    }

    /**
     * Повертає рядкове представлення книги.
     * 
     * @return рядок формату "Book: назва, X pages"
     */
    public String toString() {
        return "Book: " + title + ", " + pages + " pages";
    }
}
