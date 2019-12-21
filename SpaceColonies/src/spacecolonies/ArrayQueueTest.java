/**
 * 
 */
package spacecolonies;

import queue.EmptyQueueException;

/**
 * @author jhanavi ghadia
 * @version 2019.11.10
 *          A test class for ArrayQueue
 */
public class ArrayQueueTest extends student.TestCase {
    private ArrayQueue<String> queue1;
    private ArrayQueue<String> queue2;
    private ArrayQueue<String> queue3;
    private ArrayQueue<String> queue4;


    /**
     * sets up the queues
     */
    public void setUp() {
        queue1 = new ArrayQueue<String>();
        queue2 = new ArrayQueue<String>();
        queue3 = new ArrayQueue<String>();
        queue4 = new ArrayQueue<String>();

        queue1.enqueue("a");
        queue1.enqueue("b");
        queue2.enqueue("x");
    }


    /**
     * test method for a class
     */
    public void testGetSize() {
        assertEquals(2, queue1.getSize());
        assertEquals(1, queue2.getSize());
    }


    /**
     * test method for a class
     */
    public void testGetLength() {
        assertEquals(11, queue1.getLength());
        for (int i = 0; i < 10; i++) {
            queue1.enqueue("x");
        }
        assertEquals(21, queue1.getLength());
    }


    /**
     * test method for a class
     */
    public void testClear() {
        queue1.clear();
        assertEquals(0, queue1.getSize());
    }


    /**
     * test method for a class
     */
    public void testDeque() {
        Exception exception = null;
        try {
            queue3.dequeue();
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof EmptyQueueException);

        assertEquals("x", queue2.dequeue());
        assertEquals(0, queue2.getSize());
        assertEquals("a", queue1.dequeue());
        assertEquals(1, queue1.getSize());
        assertEquals("b", queue1.dequeue());
    }


    /**
     * test method for a class
     */
    public void testEnqueIndex() {
        assertEquals(2, queue1.getSize());
        queue1.enqueue("c");
        assertEquals(3, queue1.getSize());
        ArrayQueue<String> queue = new ArrayQueue<String>();
        for (int i = 0; i < 100; i++) {
            queue.enqueue("x");
        }
        Exception exception = null;
        try {
            queue.enqueue("x");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof IllegalStateException);
    }


    /**
     * test method for a class
     */
    public void testGetFront() {
        assertEquals("a", queue1.getFront());
        assertEquals("x", queue2.getFront());
        queue1.dequeue();
        queue1.dequeue();
        Exception exception = null;
        try {
            queue1.getFront();
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof EmptyQueueException);

    }


    /**
     * test method for a class
     */
    public void testIsEmpty() {
        assertTrue(queue3.isEmpty());
        queue2.dequeue();
        assertTrue(queue2.isEmpty());
        assertFalse(queue1.isEmpty());
    }


    /**
     * test method for a class
     */
    public void testToArray() {
        String[] array = new String[] { "a" };
        assertEquals(array[0], queue1.toArray()[0]);
        assertEquals(2, queue1.toArray().length);
        Exception exception = null;
        try {
            queue1.clear();
            queue1.toArray();
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof EmptyQueueException);
    }


    /**
     * test method for a class
     */
    public void testToString() {
        assertEquals("[a, b]", queue1.toString());
        queue1.dequeue();
        assertEquals("[b]", queue1.toString());
        assertEquals("[]", queue3.toString());
        for (int i = 0; i < 12; i++) {
            queue4.enqueue("" + i);
        }
        assertEquals("[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11]", queue4
            .toString());

        
    }


    /**
     * test method for a class
     */
    public void testEquals() {
        String x = null;
        String a = "b";
        assertTrue(queue1.equals(queue1));
        assertFalse(queue1.equals(queue2));
        assertFalse(queue1.equals(x));
        queue2.enqueue("y");
        assertFalse(queue1.equals(queue2));
        queue2.clear();
        queue2.enqueue("a");
        queue2.enqueue("b");
        assertTrue(queue1.equals(queue2));
        assertFalse(queue1.equals(a));

    }

}
