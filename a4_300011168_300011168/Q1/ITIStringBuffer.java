import java.util.Iterator;

/**
 * 
 * @author Owen Anderson
 * Student number: 300011168
 * Course: ITI 1121-C
 * Assignment: 4
 *
 */

public class ITIStringBuffer {

    SinglyLinkedList<String> buffer;
    int length;

    /**
     * Creates a new empty string buffer
     */
    public ITIStringBuffer() {
        buffer = new SinglyLinkedList<>();
        length = 0;
    }

    /**
     * Creates a new string buffer with a starting string
     * 
     * @param firstString - The starting string to be added to the buffer
     */
    public ITIStringBuffer(String firstString){
        buffer = new SinglyLinkedList<>();
        append(firstString);
    }

    /**
     * Concats a new string in the buffer
     * 
     * @param nextString - The string to add to the buffer
     */
    public void append(String nextString){
        buffer.add(nextString);
        length += nextString.length();
    }

    /**
     * Creates the concated string that is stored in the buffer
     */
    public String toString(){
        char[] outp = new char[length];

        int cp = 0; // No that doesn't mean what urban dictonary says it does

        if(buffer.size() == 1){
            return buffer.get(0);
        }

        for(Iterator<String> a = buffer.iterator(); a.hasNext(); ){
            char[] data = a.next().toCharArray();
            buffer.removeFirst();
            for(int i = 0; i < data.length; i++){
                outp[cp] = data[i];
                cp++;
            }
        }

        buffer.add(new String(outp));
        return new String(outp);
    }

}
