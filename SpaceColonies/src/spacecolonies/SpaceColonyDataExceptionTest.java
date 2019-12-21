/**
 * 
 */
package spacecolonies;

/**
 * @author jhanavi ghadia
 * @version 2019.11.10
 *          A test class for Spacecolonydata Exception
 */
public class SpaceColonyDataExceptionTest extends student.TestCase {
    /**
     * a set up method for test class
     */
    public void setUp() {
        // this method is left blank
    }


    /**
     * test method for a class
     */
    public void testException() {
        SpaceColonyDataException exception = new SpaceColonyDataException(
            "message");
        assertTrue(exception instanceof SpaceColonyDataException);
        assertEquals("message", exception.getMessage());

    }

}
