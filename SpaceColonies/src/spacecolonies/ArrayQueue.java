/**
 * 
 */
package spacecolonies;

import java.util.Arrays;
import queue.EmptyQueueException;
import queue.QueueInterface;

/**
 * ArrayQueue class with all the implemented methods
 * 
 * @author jhanavi ghadia
 * @version 2019.11.09
 * @param <T>
 *            A generic data type
 */
public class ArrayQueue<T> implements QueueInterface<T> {
    private T[] queue;
    private final static int DEFAULT_CAPACITY = 10;
    private final static int MAX_CAPACITY = 100;
    private int enqueIndex;
    private int dequeueIndex;
    private int size;


    /**
     * default constructor for ArrayQueue
     */
    public ArrayQueue() {
        @SuppressWarnings("unchecked")
        T[] myQueue = (T[])new Object[DEFAULT_CAPACITY + 1];
        queue = myQueue;
        enqueIndex = 0;
        dequeueIndex = 0;
        size = 0;
    }


    /**
     * checks if the array is full
     * 
     * @return true if the array ueue is full
     */
    private boolean isFull() {
        return size == MAX_CAPACITY;
    }


    /**
     * increases the index of an array queue
     * 
     * @param index
     *            for the queue
     * @return index which is incremented
     */
    private int incrementIndex(int index) {
        return ((index + 1) % queue.length);
    }


    /**
     * getter for the length of the array
     * 
     * @return the length of the array
     */
    public int getLength() {
        return queue.length;
    }


    /**
     * checks the capacity of an array
     */
    @SuppressWarnings("unchecked")
    private void ensureCapacity() {
        if (isFull()) {
            throw new IllegalStateException("size is equal to MAX_CAPACITY");
        }
        if (this.size == this.getLength() - 1) {
            int a = 0;
            T[] newQueue = (T[])new Object[this.size * 2 + 1];
            for (int x = dequeueIndex; x != enqueIndex; x = incrementIndex(x)) {
                newQueue[a] = queue[x];
                a++;
            }
            dequeueIndex = 0;
            enqueIndex = this.size;
            queue = newQueue;
        }
    }


    /**
     * a getter for the size of an array
     * 
     * @return size of the array
     */
    public int getSize() {
        return size;
    }


    /**
     * clears the array queue
     */
    @Override
    public void clear() {
        @SuppressWarnings("unchecked")
        T[] myQueue = (T[])new Object[DEFAULT_CAPACITY + 1];
        queue = myQueue;
        enqueIndex = 0;
        dequeueIndex = 0;
        size = 0;
    }


    /**
     * removes an entry from the back
     * 
     * @return the removed element
     */
    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }
        else {
            T front = queue[dequeueIndex];
            queue[dequeueIndex] = null;
            dequeueIndex = incrementIndex(dequeueIndex);
            size--;
            return front;
        }
    }


    /**
     * add an element in an array queue
     * 
     * @param anEntry
     *            which is added in the queue
     */
    @Override
    public void enqueue(T anEntry) {
        ensureCapacity();
        queue[enqueIndex] = anEntry;
        enqueIndex = incrementIndex(enqueIndex);
        size++;

    }


    /**
     * gives the first element of an array
     * 
     * @return an element of type T
     */
    @Override
    public T getFront() {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }
        return queue[dequeueIndex];
    }


    /**
     * checks if the array queue is empty
     * 
     * @return true if the queue is empty
     */
    @Override
    public boolean isEmpty() {
        return size == 0;

    }


    /**
     * gives an array format of the queue
     * 
     * @return the Object of type array
     */
    public Object[] toArray() {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }

        int i = 0;
        int index = dequeueIndex;
        @SuppressWarnings("unchecked")
        T[] anArray = (T[])new Object[getSize()];

        while (index != enqueIndex) {
            anArray[i] = queue[index];
            i++;
            index = incrementIndex(index);

        }
        return anArray;
    }


    /**
     * to_string method that creates a string version of an array
     * 
     * @return String format of an array
     */
    @Override
    public String toString() {

        if (isEmpty()) {
            return "[]";
        }
        return Arrays.toString(toArray());

    }


    /**
     * equals method for the arrayQueue
     * 
     * @return boolean if the arrays are equal
     * @param obj
     *            an Object
     */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }

        if (this.getClass() == obj.getClass()) {
            @SuppressWarnings("unchecked")
            ArrayQueue<T> newQueue = (ArrayQueue<T>)obj;
            if (this.getSize() == newQueue.getSize()) {
                for (int i = 0; i < getSize(); i++) {
                    T element1 = queue[(dequeueIndex + i) % queue.length];
                    T element2 = newQueue.queue[(newQueue.dequeueIndex + i)
                        % newQueue.queue.length];
                    if (!element1.equals(element2)) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }
}
