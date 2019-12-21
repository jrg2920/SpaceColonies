package spacecolonies;

import java.awt.Color;
import CS2114.Button;
import CS2114.CircleShape;
import CS2114.Shape;
import CS2114.SquareShape;
import CS2114.TextShape;
import CS2114.Window;
import CS2114.WindowSide;
import list.AList;

/**
 * A spaceWindow Class for GUI
 * 
 * @author Jhanavi Ghadia
 * @version 2019.11.11
 */
public class SpaceWindow {
    private Window window;
    private ColonyCalculator colonyCalculator;
    private Button accept;
    private Button reject;
    // A new textShape object
    private TextShape data = new TextShape(SpaceWindow.QUEUE_STARTX, 20, "");
    TextShape text1;
    TextShape text2;
    TextShape text3;
    private AList<CircleShape> personCircles;
    // a static final variable for x-coordinate
    public static final int QUEUE_STARTX = 50;
    // a static final variable for y-coordinate
    public static final int QUEUE_STARTY = 40;
    // a static final variable for circle size
    public static final int CIRCLE_SIZE = 20;
    // a static final variable for size
    public static final int SIZE = 110;
    // a new planet color
    public static final Color PLANET1 = new Color(100, 84, 62);
    // a new planet color
    public static final Color PLANET11 = new Color(34, 85, 141);
    // a new planet color
    public static final Color PLANET2 = new Color(150, 64, 199);
    // a new planet color
    public static final Color PLANET22 = new Color(54, 99, 27);
    // a new planet color
    public static final Color PLANET3 = new Color(100, 85, 222);
    // a new planet color
    public static final Color PLANET33 = new Color(251, 64, 147);
    // a new planet color
    public static final Color RANDOM = new Color(216, 41, 100);


    /**
     * A spaceWindow constructor
     * 
     * @param cw
     *            of type ColonyCalculator
     */
    public SpaceWindow(ColonyCalculator cw) {
        this.colonyCalculator = cw;
        this.window = new Window("Space Colony Placement");
        personCircles = new AList<CircleShape>();

        accept = new Button("Accept");
        reject = new Button("Reject");
        accept.onClick(this, "clickedAccept");
        reject.onClick(this, "clickedReject");

        window.addButton(accept, WindowSide.SOUTH);
        window.addButton(reject, WindowSide.SOUTH);

        Object[] colony = colonyCalculator.getQueue().toArray();
        Person[] colonyL = new Person[colony.length];
        for (int x = 0; x < colonyL.length; x++) {
            colonyL[x] = (Person)colony[x];
        }

        for (int x = 0; x < colonyL.length; x++) {
            CircleShape curr = new CircleShape(SpaceWindow.QUEUE_STARTX + (x
                * 25), SpaceWindow.QUEUE_STARTY, SpaceWindow.CIRCLE_SIZE,
                getPlanetColor(colonyL[x]));
            window.addShape(curr);
            personCircles.add(curr);
        }
        Planet first = ColonyCalculator.getPlanets()[1];
        Planet second = ColonyCalculator.getPlanets()[2];
        Planet third = ColonyCalculator.getPlanets()[3];

        SquareShape one = new SquareShape(QUEUE_STARTX + 30, 110, SIZE,
            PLANET11);
        text1 = new TextShape(QUEUE_STARTX + 30, 110 + SIZE, first.getName()
            + ", " + first.getPopulationSize() + "/" + first.getCapacity());
        TextShape text11 = new TextShape(QUEUE_STARTX + 40, 110 + SIZE + text1
            .getHeight(), first.getSkills().toString());

        SquareShape two = new SquareShape(QUEUE_STARTX + SIZE + 70, 110, SIZE,
            PLANET22);
        text2 = new TextShape(QUEUE_STARTX + SIZE + 70, 110 + SIZE, second
            .getName() + ", " + second.getPopulationSize() + "/" + second
                .getCapacity());
        TextShape text22 = new TextShape(QUEUE_STARTX + SIZE + 80, 110 + SIZE
            + text2.getHeight(), second.getSkills().toString());

        SquareShape three = new SquareShape(QUEUE_STARTX + (2 * SIZE) + 110,
            110, SIZE, PLANET33);
        text3 = new TextShape(QUEUE_STARTX + (2 * SIZE) + 110, 110 + SIZE, third
            .getName() + ", " + third.getPopulationSize() + "/" + third
                .getCapacity());
        TextShape text33 = new TextShape(QUEUE_STARTX + (2 * SIZE) + 120, 110
            + SIZE + text3.getHeight(), third.getSkills().toString());

        text1.setBackgroundColor(new Color(255, 225, 255));
        text2.setBackgroundColor(new Color(255, 255, 255));
        text3.setBackgroundColor(new Color(255, 255, 255));
        text11.setBackgroundColor(new Color(255, 255, 255));
        text22.setBackgroundColor(new Color(255, 255, 255));
        text33.setBackgroundColor(new Color(255, 255, 255));
        data.setBackgroundColor(new Color(255, 255, 255));

        data.setText(colonyCalculator.getQueue().getFront().toString());

        window.addShape(one);
        window.addShape(two);
        window.addShape(three);
        window.addShape(text1);
        window.addShape(text2);
        window.addShape(text3);
        window.addShape(text11);
        window.addShape(text22);
        window.addShape(text33);
        window.addShape(data);

        setAble();
        updateQueue();
    }


    /**
     * a method that is called when accept is clicked
     * 
     * @param button
     *            of type Button
     */
    public void clickedAccept(Button button) {
        window.removeShape(personCircles.remove(0));
        colonyCalculator.getPlanetForPerson(colonyCalculator.getQueue()
            .getFront()).addPerson(colonyCalculator.getQueue().dequeue());
        updateQueue();
        updatePlanets();
        setAble();
    }


    /**
     * a method that is called when reject is clicked
     * 
     * @param button
     *            of type Button
     */
    public void clickedReject(Button button) {
        window.removeShape(personCircles.remove(0));
        updateQueue();
        colonyCalculator.reject();
        setAble();
    }


    /**
     * Updates the queue
     */
    private void updateQueue() {
        for (int x = 0; x < personCircles.getLength(); x++) {
            personCircles.getEntry(x).setX(SpaceWindow.QUEUE_STARTX + (x * 25));
        }
        window.repaint();
    }


    /**
     * a method for enabling the buttons
     */
    private void setAble() {
        if (personCircles.isEmpty()) {
            data.setText("All applicants processed!");
            window.removeAllShapes();
            window.addShape(data);
            accept.disable();
            reject.disable();
        }
        else {
            Planet planet = colonyCalculator.getPlanetForPerson(colonyCalculator
                .getQueue().getFront());
            if (planet == null || planet.isFull()) {
                data.setText(colonyCalculator.getQueue().getFront().toString());
                accept.disable();
            }
            else {
                data.setText(colonyCalculator.getQueue().getFront().toString());
                accept.enable();
            }
        }
        window.repaint();
    }


    /**
     * Updates the planet names
     */
    private void updatePlanets() {
        Planet planet = ColonyCalculator.getPlanets()[1];
        Shape shape = new Shape(QUEUE_STARTX + 30, 110 + SIZE - ((SIZE * planet
            .getPopulationSize() + 1) / planet.getCapacity()), SIZE,
            ((int)SpaceWindow.SIZE * planet.getPopulationSize() / planet
                .getCapacity()), PLANET1);
        window.addShape(shape);
        window.moveToFront(shape);
        text1.setText(planet.getName() + ", " + planet.getPopulationSize() + "/"
            + planet.getCapacity());
        window.repaint();

        planet = ColonyCalculator.getPlanets()[2];
        shape = new Shape(QUEUE_STARTX + SIZE + 70, 110 + SIZE - ((SIZE * planet
            .getPopulationSize() + 1) / planet.getCapacity()), SIZE,
            ((int)SpaceWindow.SIZE * planet.getPopulationSize() / planet
                .getCapacity()), PLANET2);
        window.addShape(shape);
        window.moveToFront(shape);
        text2.setText(planet.getName() + ", " + planet.getPopulationSize() + "/"
            + planet.getCapacity());

        planet = ColonyCalculator.getPlanets()[3];
        shape = new Shape(QUEUE_STARTX + (2 * SIZE) + 110, 110 + SIZE
            - (((int)SIZE * planet.getPopulationSize() + 1) / planet
                .getCapacity()), SIZE, ((int)SpaceWindow.SIZE * planet
                    .getPopulationSize() / planet.getCapacity()), PLANET3);
        window.addShape(shape);
        text3.setText(planet.getName() + ", " + planet.getPopulationSize() + "/"
            + planet.getCapacity());
        window.moveToFront(shape);

        window.repaint();

    }


    /**
     * getter for the planet color
     * 
     * @param person
     *            of the type Person
     * @return color of type Color
     */
    private Color getPlanetColor(Person person) {
        if (person.getPlanetName().equals(ColonyCalculator.getPlanets()[1]
            .getName())) {
            return PLANET11;
        }
        if (person.getPlanetName().equals(ColonyCalculator.getPlanets()[2]
            .getName())) {
            return PLANET22;
        }
        if (person.getPlanetName().equals(ColonyCalculator.getPlanets()[3]
            .getName())) {
            return PLANET33;
        }
        return RANDOM;
    }

}
