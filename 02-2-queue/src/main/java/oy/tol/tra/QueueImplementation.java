package oy.tol.tra;

public class QueueImplementation<E> implements QueueInterface<E> {
    private Object[] itemArray;
    private int size;
    private int capacity;
    private static final int DEFAULT_CAPACITY = 10;

    public QueueImplementation(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be positive");
        }
        this.capacity = capacity;
        this.itemArray = new Object[capacity];
        this.size = 0;
    }

    public QueueImplementation() {
        this(DEFAULT_CAPACITY);
    }

    @Override
    public int capacity() {
        return capacity;
    }

    @Override
    public void enqueue(E element) throws QueueAllocationException, NullPointerException {
        if (element == null) {
            throw new NullPointerException("Element cannot be null");
        }
        if (size == capacity) {
            reallocate();
        }
        itemArray[(size++) % capacity] = element;
    }

    private void reallocate() {
        int newCapacity = capacity * 2;
        Object[] newElements = new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newElements[i] = itemArray[i];
        }
        itemArray = newElements;
        capacity = newCapacity;
    }

    @Override
    public E dequeue() throws QueueIsEmptyException {
        if (isEmpty()) {
            throw new QueueIsEmptyException("Queue is empty");
        }
        E removedElement = (E) itemArray[0];
        for (int i = 0; i < size - 1; i++) {
            itemArray[i] = itemArray[i + 1];
        }
        itemArray[size - 1] = null;
        size--;
        return removedElement;
    }

    @Override
    public E element() throws QueueIsEmptyException {
        if (isEmpty()) {
            throw new QueueIsEmptyException("Queue is empty");
        }
        return (E) itemArray[0];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            itemArray[i] = null;
        }
        size = 0;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size - 1; i++) {
            sb.append(itemArray[i]).append(", ");
        }
        sb.append(itemArray[size - 1]).append("]");
        return sb.toString();
    }
}
