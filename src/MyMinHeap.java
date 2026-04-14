public class MyMinHeap<T extends Comparable<T>> {
    private MyArrayList<T> list = new MyArrayList<>();

    public void insert(T item) {
        list.add(item);
        traverseUp(list.size() - 1);
    }

    public T extractMin() {
        if (list.size() == 0) return null;
        T min = list.getFirst();
        list.set(0, list.getLast());
        list.removeLast();
        traverseDown(0);
        return min;
    }

    private void traverseUp(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;
            if (list.get(index).compareTo(list.get(parent)) >= 0) break;
            swap(index, parent);
            index = parent;
        }
    }

    private void traverseDown(int index) {
        while (2 * index + 1 < list.size()) {
            int left = 2 * index + 1;
            int right = 2 * index + 2;
            int smallest = left;
            if (right < list.size() && list.get(right).compareTo(list.get(left)) < 0) {
                smallest = right;
            }
            if (list.get(index).compareTo(list.get(smallest)) <= 0) break;
            swap(index, smallest);
            index = smallest;
        }
    }

    private void swap(int i, int j) {
        T temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    public int size() {
        return list.size();
    }
}
