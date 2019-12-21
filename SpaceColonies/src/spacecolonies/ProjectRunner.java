/**
 * 
 */
package spacecolonies;

import java.io.FileNotFoundException;
import bsh.ParseException;

/**
 * @author jhanavi ghadia
 * @version 2019.11.10
 *          ProjectRunner class which runs the entire project
 */
public class ProjectRunner {
    /**
     * main method to run the entire software
     * 
     * @param args
     * @throws SpaceColonyDataException
     * @throws ParseException
     * @throws FileNotFoundException
     */
    @SuppressWarnings("unused")
    public static void main(String[] args)
        throws FileNotFoundException,
        ParseException,
        SpaceColonyDataException {
        ColonyReader colonyReader;
        if (args.length >= 2) {
            colonyReader = new ColonyReader(args[0], args[1]);
        }
        else {
            colonyReader = new ColonyReader("inputAllAccept.txt",
                "planets.txt");
        }
    }

}
