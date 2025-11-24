package ki305.vladyka.lab6;

/**
 * Клас {@code Node} описує вузол двозв’язного списку.
 * <p>
 * Містить посилання на попередній та наступний елементи, а також дані типу {@code T}.
 * </p>
 *
 * @param <T> тип даних, який зберігається у вузлі
 * 
 * @author Vladyka
 * @version 1.0
 */
public class Node<T> {
    /** Дані, які зберігає вузол */
    T data;
    /** Посилання на попередній вузол */
    Node<T> prev;
    /** Посилання на наступний вузол */
    Node<T> next;

    /**
     * Створює новий вузол із заданими даними.
     * 
     * @param data дані, які зберігаються у вузлі
     */
    public Node(T data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}
