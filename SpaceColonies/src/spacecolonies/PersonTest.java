/**
 * 
 */
package spacecolonies;

/**
 * @author jhanavi ghadia
 * @version 2019.11.10
 *  A test class for person
 */
public class PersonTest extends student.TestCase {
    private Person person1;
    private Person person2;
    private Person person3;
    private Skills skill;


    /**
     * a set up method for the test class
     */
    public void setUp() {
        person1 = new Person("John", 2, 3, 4, "mars");
        person2 = new Person("Frieda", 2, 3, 4, "");
        skill = new Skills(3, 4, 5);
    }


    /**
     * test method for a class
     */
    public void testGetName() {
        assertEquals("John", person1.getName());
    }


    /**
     * test method for a class
     */
    public void testGetSkills() {
        assertEquals(3, skill.getAgriculture());
        assertEquals(4, skill.getMedicine());
        assertEquals(5, skill.getTechnology());
    }


    /**
     * test method for a class
     */
    public void testGetPlanetName() {
        assertEquals("mars", person1.getPlanetName());
    }


    /**
     * test method for a class
     */
    public void testToString() {
        assertEquals("John A:2 M:3 T:4 Wants: mars", person1.toString());
        assertEquals("No-Planet Frieda A:2 M:3 T:4", person2.toString());
    }
    
    /**
     * test method for a class
     */
    public void testEquals() {
        String x = "a";
        assertTrue(person1.equals(person1));
        assertFalse(person1.equals(person3));
        assertFalse(person1.equals(person2));
        assertFalse(person1.equals(x));
        Person person4 = new Person("John", 1, 2, 3, "");
        Person person5 = new Person("John", 1, 2, 3, "");
        assertFalse(person1.equals(person4));
        assertTrue(person4.equals(person5));
        Person person6 = new Person("John", 2, 2, 3, "");
        assertFalse(person4.equals(person6));

        

        
        
    }
}
