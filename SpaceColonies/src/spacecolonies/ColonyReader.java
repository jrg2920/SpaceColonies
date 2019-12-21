/**
 * 
 */
package spacecolonies;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import bsh.ParseException;

/**
 * @author jhanv
 *
 */
public class ColonyReader {
    private Planet[] planets;
    private ArrayQueue<Person> queue;


    /**
     * 
     * @param applicantFileName
     * @param planetFileName
     * @throws SpaceColonyDataException
     * @throws ParseException
     * @throws FileNotFoundException
     */
    @SuppressWarnings("unused")
    public ColonyReader(String applicantFileName, String planetFileName)
        throws FileNotFoundException,
        ParseException,
        SpaceColonyDataException {
        this.queue = readQueueFile(applicantFileName);
        this.planets = readPlanetFile(planetFileName);
        SpaceWindow spaceWindow = new SpaceWindow(new ColonyCalculator(
            this.queue, this.planets));
    }


    /**
     * 
     * @param fileName
     * @return
     * @throws FileNotFoundException
     * @throws ParseException
     * @throws SpaceColonyDataException
     */
    private Planet[] readPlanetFile(String fileName)
        throws FileNotFoundException,
        ParseException,
        SpaceColonyDataException {
        Planet[] planet = new Planet[ColonyCalculator.NUM_PLANETS + 1];
        Scanner scnr = new Scanner(new File(fileName));
        int x = 1;
        while (scnr.hasNextLine() && x <= ColonyCalculator.NUM_PLANETS) {
            String nextLine = scnr.nextLine();
            String[] array = nextLine.split(", *");
            if (array.length != 5) {
                scnr.close();
                throw new ParseException("the file isn't in proper format");
            }
            int agri = Integer.parseInt(array[1]);
            int medi = Integer.parseInt(array[2]);
            int tech = Integer.parseInt(array[3]);
            if (!isInSkillRange(agri, medi, tech)) {
                scnr.close();
                throw new SpaceColonyDataException(
                    "the skills are not in range");
            }
            planet[x] = new Planet(array[0], agri, medi, tech, Integer.parseInt(
                array[4]));
            x++;
        }
        scnr.close();
        if (x != ColonyCalculator.NUM_PLANETS + 1) {
            throw new SpaceColonyDataException(
                "the number of planets isn't sufficient");
        }

        return planet;
    }


    /**
     * 
     * @param fileName
     * @return
     * @throws FileNotFoundException
     * @throws ParseException
     * @throws SpaceColonyDataException
     */
    private ArrayQueue<Person> readQueueFile(String fileName)
        throws FileNotFoundException,
        ParseException,
        SpaceColonyDataException {
        ArrayQueue<Person> arrayQueue = new ArrayQueue<Person>();
        Scanner scnr = new Scanner(new File(fileName));
        while (scnr.hasNextLine()) {
            String nextLine = scnr.nextLine();
            String[] array = nextLine.split(", *", -1);
            if (array.length != 5) {
                scnr.close();
                throw new ParseException("the file isn't in proper format");
            }
            int agri = Integer.parseInt(array[1]);
            int medi = Integer.parseInt(array[2]);
            int tech = Integer.parseInt(array[3]);
            if (!isInSkillRange(agri, medi, tech)) {
                scnr.close();
                throw new SpaceColonyDataException(
                    "the skills are not in range");
            }
            arrayQueue.enqueue(new Person(array[0], agri, medi, tech,
                array[4]));
        }
        scnr.close();
        return arrayQueue;
    }


    private boolean isInSkillRange(int num1, int num2, int num3) {
        return num1 >= ColonyCalculator.MIN_SKILL_LEVEL
            && num1 <= ColonyCalculator.MAX_SKILL_LEVEL
            && num2 >= ColonyCalculator.MIN_SKILL_LEVEL
            && num2 <= ColonyCalculator.MAX_SKILL_LEVEL
            && num3 >= ColonyCalculator.MIN_SKILL_LEVEL
            && num3 <= ColonyCalculator.MAX_SKILL_LEVEL;
    }

}
