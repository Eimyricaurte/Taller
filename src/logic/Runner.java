package logic;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Class that establishes the attributes of the runner
 */
public class Runner {

    private int idRunner;

    private String nameRunner;

    private double height;

    private double width;

    private LocalDate birthday;

    private LocalTime totalTimeRace;

    /**
     * Constructor that allows creating the instance of objects of this class
     * @param idRunner
     * @param nameRunner
     * @param height
     * @param width
     * @param birthday
     * @param totalTimeRace
     */
    public Runner(int idRunner, String nameRunner, double height, double width, LocalDate birthday, LocalTime totalTimeRace) {
        this.idRunner = idRunner;
        this.nameRunner = nameRunner;
        this.height = height;
        this.width = width;
        this.birthday =  birthday;
        this.totalTimeRace =  totalTimeRace;
    }

    /**
     * Shows the ID of the runner
     * @return the ID of the runner
     */
    public int getIdRunner() {
        return idRunner;
    }

    /**
     * Sets the ID of the runner
     * @param idRunner receives the runner's ID
     */
    public void setIdRunner(int idRunner) {
        this.idRunner = idRunner;
    }

    /**
     * Shows the name of the runner
     * @return the name of the runner
     */
    public String getNameRunner() {
        return nameRunner;
    }

    /**
     * Sets the name of the runner
     * @param nameRunner receives the runner's name
     */
    public void setNameRunner(String nameRunner) {
        this.nameRunner = nameRunner;
    }

    /**
     * Shows the height of the runner
     * @return the height of the runner
     */
    public double getHeight() {
        return height;
    }

    /**
     * Sets the height of the runner
     * @param height receives the runner's height
     */
    public void setHeight(double height) {
        this.height = height;
    }

    /**
     * Shows the width of the runner
     * @return the width of the runner
     */
    public double getWidth() {
        return width;
    }

    /**
     * Sets the width of the runner
     * @param width receives the runner's width
     */
    public void setWidth(double width) {
        this.width = width;
    }

    /**
     * Shows the birthday of the runner
     * @return the birthday of the runner
     */
    public LocalDate getBirthday() {
        return birthday;
    }

    /**
     * Sets the birthday of the runner
     * @param birthday receives the runner's birthday
     */
    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    /**
     * Shows the time of the race of the runner
     * @return the time of the race of the runner
     */
    public LocalTime getTotalTimeRace() {
        return totalTimeRace;
    }

    /**
     * Sets the time of the race of the runner
     * @param totalTimeRace receives the time of the race of the runner
     */
    public void setTotalTimeRace(LocalTime totalTimeRace) {
        this.totalTimeRace = totalTimeRace;
    }

    /**
     * Converts the object in a chain
     * @return the string representation of the runner
     */
    @Override
    public String toString() {
        return "Runner{" +
                "idRunner=" + idRunner +
                ", nameRunner='" + nameRunner + '\'' +
                ", height=" + height +
                ", width=" + width +
                ", birthday=" + birthday +
                ", totalTimeRace=" + totalTimeRace +
                '}';
    }
}
