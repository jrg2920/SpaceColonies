/**
 * 
 */
package spacecolonies;

/**
 * @author jhanavi ghadia
 * @version 2019.11.10
 *          test class for skills
 */
public class SkillsTest extends student.TestCase {
    private Skills skill;
    private Skills skill1;
    private Skills skill2;
    private Skills skill4;


    /**
     * set up method for the test class
     */
    public void setUp() {
        skill = new Skills(2, 3, 4);
        skill1 = new Skills(1, 2, 3);
        skill2 = new Skills(3, 4, 5);
        skill4 = new Skills(3, 4, 5);
    }


    /**
     * test method for a class
     */
    public void testGetAgriculture() {
        assertEquals(2, skill.getAgriculture());
    }


    /**
     * test method for a class
     */
    public void testGetMedicine() {
        assertEquals(3, skill.getMedicine());
    }


    /**
     * test method for a class
     */
    public void testGetTechnology() {
        assertEquals(4, skill.getTechnology());
    }


    /**
     * test method for a class
     */
    public void testIsBelow() {
        assertTrue(skill1.isBelow(skill));
        assertFalse(skill2.isBelow(skill));
        assertTrue(skill2.isBelow(skill4));
        Skills skilla = new Skills(2, 3, 3);
        assertTrue(skilla.isBelow(skill));
        Skills skillb = new Skills(2, 2, 4);
        assertFalse(skill.isBelow(skillb));
        Skills skillc = new Skills(1, 3, 4);
        assertFalse(skill.isBelow(skillc));
        Skills skilld = new Skills(2, 4, 5);
        assertTrue(skill.isBelow(skilld));
        Skills skille = new Skills(1, 3, 5);
        assertFalse(skill.isBelow(skille));
        Skills skillf = new Skills(1, 3, 4);
        assertFalse(skill.isBelow(skillf));

    }


    /**
     * test method for a class
     */
    public void testToString() {
        assertEquals("A:1 M:2 T:3", skill1.toString());
    }


    /**
     * test method for a class
     */
    public void testEquals() {
        String e = null;
        String a = "x";
        assertFalse(skill.equals(skill1));
        assertTrue(skill2.equals(skill4));
        assertTrue(skill1.equals(skill1));
        assertFalse(skill1.equals(e));
        assertFalse(skill1.equals(a));
        skill4 = new Skills(4, 4, 5);
        assertFalse(skill2.equals(skill4));
        Skills skilla = new Skills(2, 3, 3);
        assertFalse(skilla.equals(skill));
        Skills skillb = new Skills(2, 2, 4);
        assertFalse(skill.equals(skillb));
        Skills skillc = new Skills(1, 3, 4);
        assertFalse(skill.equals(skillc));
        Skills skilld = new Skills(2, 4, 5);
        assertFalse(skill.equals(skilld));
        Skills skille = new Skills(1, 3, 5);
        assertFalse(skill.equals(skille));
        Skills skillf = new Skills(1, 3, 4);
        assertFalse(skill.equals(skillf));
    }

}
