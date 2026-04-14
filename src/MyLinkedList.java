import java.util.Iterator;

public class MyLinkedList<T> implements MyList<T> {
    private class MyNode {
        T data;
        MyNode next;
        MyNode prev;

        MyNode(T data) {
            this.data = data;
        }
    }

    private MyNode head;
    private MyNode tail;
    private int size;

    @Override
    public void add(T item) {
        addLast(item);
    }

    @Override
    public void addLast(T item) {
        MyNode newNode = new MyNode(item);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    @Override
    public void addFirst(T item) {
        MyNode newNode = new MyNode(item);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    @Override
    public void add(int index, T item) {
        if (index < 0 || index > size) return;
        if (index == 0) {
            addFirst(item);
            return;
        }
        if (index == size) {
            addLast(item);
            return;
        }
        MyNode current = getNode(index);
        MyNode newNode = new MyNode(item);
        newNode.prev = current.prev;
        newNode.next = current;
        current.prev.next = newNode;
        current.prev = newNode;
        size++;
    }

    private MyNode getNode(int index) {
        MyNode current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) return null;
        return getNode(index).data;
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index >= size) return;
        if (index == 0) {
            removeFirst();
            return;
        }
        if (index == size - 1) {
            removeLast();
            return;
        }
        MyNode nodeToRemove = getNode(index);
        nodeToRemove.prev.next = nodeToRemove.next;
        nodeToRemove.next.prev = nodeToRemove.prev;
        size--;
    }

    @Override
    public void removeFirst() {
        if (head == null) return;
        head = head.next;
        if (head != null) head.prev = null;
        else tail = null;
        size--;
    }

    @Override
    public void removeLast() {
        if (tail == null) return;
        tail = tail.prev;
        if (tail != null) tail.next = null;
        else head = null;
        size--;
    }

    @Override
    public int size() {
        return size;
    }

    // Additional methods (set, sort, indexOf, clear, etc.) are implemented 
    // following the same logic as MyArrayList using node traversal.

    @Override
    public void set(int index, T item) {
        if (index < 0 || index >= size) return;
        getNode(index).data = item;
    }

    @Override
    public T getFirst() {
        return (head != null) ? head.data : null;
    }

    @Override
    public T getLast() {
        return (tail != null) ? tail.data : null;
    }

    @Override
    public int indexOf(Object object) {
        MyNode current = head;
        for (int i = 0; i < size; i++) {
            if (current.data.equals(object)) return i;
            current = current.next;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        MyNode current = tail;
        for (int i = size - 1; i >= 0; i--) {
            if (current.data.equals(object)) return i;
            current = current.prev;
        }
        return -1;
    }

    @Override
    public boolean exists(Object object) {
        return indexOf(object) != -1;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        MyNode current = head;
        for (int i = 0; i < size; i++) {
            array[i] = current.data;
            current = current.next;
        }
        return array;
    }

    @Override
    public void clear() {
        head = tail = null;
        size = 0;
    }

    @Override
    public void sort() {
        // Implementation of bubble sort for linked list
        if (size < 2) return;
        boolean swapped;
        do {
            swapped = false;
            MyNode current = head;
            while (current.next != null) {
                if (((Comparable<T>) current.data).compareTo(current.next.data) > 0) {
                    T temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private MyNode current = head;
            @Override
            public boolean hasNext() {
                return current != null;
            }
            @Override
            public T next() {
                T data = current.data;
                current = current.next;
                return data;
            }
        };
    }
}