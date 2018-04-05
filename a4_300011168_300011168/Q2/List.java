public interface List<E> {
    void addFirst(E elem);
    int size();
    E get(int index);
    Iterator<E> iterator();

    /**
     * Gets an iterator but that will have next resolve to an element
     * with the index of nexIndex
     * 
     * @param - The index of the element to be returned by next first
     */
    Iterator<E> iterator(int nexIndex);
    Iterator<E> iterator(Iterator<E> other);
}
