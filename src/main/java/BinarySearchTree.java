/**
 * 
 * @author Owen Anderson
 * Student number: 300011168
 * Course: ITI 1121-C
 * Assignment: 4
 *
 */

import java.util.NoSuchElementException;

public class BinarySearchTree<E extends Comparable<E>> {

    private static class Node<T> {
        private T value;
        private Node<T> left;
        private Node<T> right;
        private Node(T value) {
            this.value = value;
            left = null;
            right = null;
        }
    }

    private Node<E> root = null;

    /**
     * Counts the number of values between two values in a binary search tree
     * (inclusive on both sides)
     * 
     * @param low - The low element
     * @param high - The high element
     */
    public int count(E low, E high){
        // Do the -1 beucase my algo counts the 
        return countRecurse(low, high, root, root);
    }

    /**
     * Does the heavy lifting for the count function using the magic of recursion
     * 
     * @param low - The lower element that we are looking for
     * @param high - The higher element that we are looking for
     * @param lowNode - The current position of the search for low
     * @param highNode - The current position of the search for high
     */
    private int countRecurse(E low, E high, Node<E> lowNode, Node<E> highNode){
        Node<E> newLowNode = null, newHighNode = null;
        int count = 0;

        // Adjust the low side and count nodes on the way down
        if(lowNode != null){
            int lowComp = low.compareTo(lowNode.value);
            if(lowComp < 0){
                newLowNode = lowNode.left;
                count += countNodes(lowNode.right) + 1;
            }else if(lowComp > 0){
                newLowNode = lowNode.right;
            }else{
                count += countNodes(lowNode.right) + 1;
            }
        }

        // Adjust the high side and count nodes on the way down
        if(highNode != null){
            int highComp = high.compareTo(highNode.value);
            if(highComp < 0){
                newHighNode = highNode.left;
            }else if(highComp > 0){
                newHighNode = highNode.right;
                count += countNodes(highNode.left) + 1;
            }else{
                count += countNodes(highNode.left) + 1;
            }
        }

        // If they haven't split up yet dont start counting
        if(lowNode == highNode){
            count = 0;

            // Unless they just split
            if(newHighNode != newLowNode){
                if(newHighNode != highNode || newLowNode != lowNode){
                    count += 1;
                }
            }
        }


        if(newHighNode == null && newLowNode == null){
            return count;
        }
        return countRecurse(low, high, newLowNode, newHighNode) + count;
    }

    private int countNodes(Node<E> node){

        if(node == null){
            return 0;
        }

        int left = 0, right = 0;
        if(node.left != null){
            left = countNodes(node.left);
        }
        if(node.right != null){
            right = countNodes(node.right);
        }

        return left + right + 1;
    }

    /**
    * Inserts an object into this BinarySearchTree.
    *
    * @param elem item to be added
    * @return true if the object has been added and false otherwise
    */

    public boolean add(E elem) {

        // pre-condtion:

        if (elem == null) {
            throw new NullPointerException();
        }

        // special case:

        if (root == null) {
            root = new Node<E>(elem);
            return true;
        }

        // general case:

        return add(elem, root);
    }

    // Helper method

    private boolean add(E elem, Node<E> current) {

        boolean result;
        int test = elem.compareTo(current.value);

        if (test == 0) {
            result = false; // already exists, not added
        } else if (test < 0) {
            if (current.left == null) {
                current.left = new Node<E>(elem);
                result = true;
            } else {
                result = add(elem, current.left);
            }
        } else {
            if (current.right == null) {
                current.right = new Node<E>(elem);
                result = true;
            } else {
                result = add(elem, current.right);
            }
        }
        return result;
    }

    public String toString() {
        return toString(root);
    }

    private String toString(Node<E> current) {

        if (current == null) {
            return "()";
        }

        return "(" + toString(current.left) + current.value + toString(current.right) + ")";
    }

}
