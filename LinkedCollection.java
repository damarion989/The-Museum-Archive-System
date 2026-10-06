public class LinkedCollection<T> implements CollectionInterface<T> {
    private LLNode<T> head = null;
    private int numElements = 0;

    // find sets these two fields as a side effect (as in the book)
    private LLNode<T> location;
    private LLNode<T> previous;
    private boolean found;

    private void find(T target) {
        location = head;
        previous = null;
        found = false;
        while (location != null) {
            if (location.getInfo().equals(target)) {
                found = true;
                return;
            }
            previous = location;
            location = location.getLink();
        }
    }

    @Override
    public boolean add(T element) {
        LLNode<T> newNode = new LLNode<>(element);
        newNode.setLink(head);
        head = newNode;
        numElements++;
        return true;
    }

    @Override
    public T get(T target) {
        find(target);
        return found ? location.getInfo() : null;
    }

    @Override
    public boolean contains(T target) {
        find(target);
        return found;
    }

    @Override
    public boolean remove(T target) {
        find(target);
        if (found) {
            if (location == head) head = head.getLink();
            else previous.setLink(location.getLink());
            numElements--;
        }
        return found;
    }

    @Override public boolean isFull()  { return false; }
    @Override public boolean isEmpty() { return numElements == 0; }
    @Override public int size()        { return numElements; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (LLNode<T> n = head; n != null; n = n.getLink())
            sb.append(n.getInfo()).append("\n");
        return sb.toString();
    }
}
