package ki305.vladyka.lab6;

/**
 * Головний клас {@code Lab6} демонструє роботу двозв’язного списку
 * з об’єктами типів {@link Book} та {@link Movie}.
 * 
 * <p>Показує основні операції: додавання, виведення,
 * пошук максимального елемента.</p>
 * 
 * @author Vladyka
 * @version 1.0
 */
public class Lab6 {
    /**
     * Точка входу в програму.
     * 
     * @param args аргументи командного рядка (не використовуються)
     */
    public static void main(String[] args) {

        // --- Список книг ---
        DoublyLinkedList<Book> bookshelf = new DoublyLinkedList<>();
        bookshelf.add(new Book("Harry Potter", 500));
        bookshelf.add(new Book("Bible", 1000));
        bookshelf.add(new Book("War and Peace", 1225));

        System.out.println(" Книги у списку:");
        bookshelf.printForward();

        Book maxBook = bookshelf.findMax();
        System.out.println("\nНайтовстiша книга:");
        System.out.println(maxBook);

        // --- Список фільмів ---
        DoublyLinkedList<Movie> movieList = new DoublyLinkedList<>();
        movieList.add(new Movie("Inception", 148));
        movieList.add(new Movie("Interstellar", 169));
        movieList.add(new Movie("Avatar", 162));

        System.out.println("\n Фiльми у списку:");
        movieList.printForward();

        Movie maxMovie = movieList.findMax();
        System.out.println("\nНайдовший фiльм:");
        System.out.println(maxMovie);
    }
}
