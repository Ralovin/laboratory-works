package ki305.vladyka.lab6;

/**
 * Клас {@code DoublyLinkedList} реалізує двозв’язний список елементів,
 * які можна порівнювати між собою.
 * 
 * <p>Підтримує додавання елементів, виведення списку,
 * пошук максимального елемента та видалення останнього.</p>
 *
 * @param <T> тип даних, що реалізує {@link Comparable}
 * 
 * @author Vladyka
 * @version 1.0
 */
public class DoublyLinkedList<T extends Comparable<T>> {
    /** Початок списку */
    private Node<T> head;
    /** Кінець списку */
    private Node<T> tail;

    /**
     * Додає елемент у кінець списку.
     * 
     * @param data дані для додавання
     */
    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    /**
     * Виводить усі елементи списку від початку до кінця.
     */
    public void printForward() {
        Node<T> current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    /**
     * Повертає максимальний елемент списку (згідно з методом {@code compareTo}).
     * 
     * @return максимальний елемент або {@code null}, якщо список порожній
     */
    public T findMax() {
        if (head == null) return null;

        T max = head.data;
        Node<T> current = head.next;

        while (current != null) {
            if (current.data.compareTo(max) > 0) {
                max = current.data;
            }
            current = current.next;
        }

        return max;
    }

    /**
     * Видаляє останній елемент зі списку.
     * 
     * @return видалений елемент або {@code null}, якщо список порожній
     */
    public T removeLast() {
        if (tail == null) return null;

        T data = tail.data;
        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }

        return data;
    }
}
