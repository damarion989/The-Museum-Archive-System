public class ArrayCollection<T> implements CollectionInterface<T> {
    protected static final int DEFAULT_CAPACITY = 100;
    protected T[] elements;
    protected int numElements = 0;

    @SuppressWarnings("unchecked")
    public ArrayCollection() {
        elements = (T[]) new Object[DEFAULT_CAPACITY];
    }

    @SuppressWarnings("unchecked")
    public ArrayCollection(int capacity) {
        elements = (T[]) new Object[capacity];
    }

    private int find(T target) {
        for (int i = 0; i < numElements; i++) {
            if (elements[i].equals(target)) return i;
        }
        return -1;
    }

    @Override
    public boolean add(T element) {
        if (isFull()) return false;
        elements[numElements++] = element;
        return true;
    }

    @Override
    public T get(T target) {
        int location = find(target);
        return (location == -1) ? null : elements[location];
    }

    @Override
    public boolean contains(T target) {
        return find(target) != -1;
    }

    @Override
    public boolean remove(T target) {
        int location = find(target);
        if (location == -1) return false;
        elements[location] = elements[numElements - 1];  // swap with last
        elements[numElements - 1] = null;
        numElements--;
        return true;
    }

    @Override public boolean isFull()  { return numElements == elements.length; }
    @Override public boolean isEmpty() { return numElements == 0; }
    @Override public int size()        { return numElements; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numElements; i++) sb.append(elements[i]).append("\n");
        return sb.toString();
    }
}
