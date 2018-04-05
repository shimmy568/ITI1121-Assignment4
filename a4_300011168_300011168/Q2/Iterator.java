public interface Iterator<E> {
    E next();
    boolean hasNext();

    /**
     * Gets the index of the element that will be returned by next
     */
    int nextIndex();
}
