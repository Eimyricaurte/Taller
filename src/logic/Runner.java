package logic;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 */
public class Runner {

    private int idRunner;

    private String nameRunner;

    private double height;

    private double width;

    private LocalDate birthday;

    private LocalTime totalTimeRace;

    /**
     *
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
     *
     * @return
     */
    public int getIdRunner() {
        return idRunner;
    }

    /**
     *
     * @param idRunner
     */
    public void setIdRunner(int idRunner) {
        this.idRunner = idRunner;
    }

    /**
     *
     * @return
     */
    public String getNameRunner() {
        return nameRunner;
    }

    /**
     *
     * @param nameRunner
     */
    public void setNameRunner(String nameRunner) {
        this.nameRunner = nameRunner;
    }

    /**
     *
     * @return
     */
    public double getHeight() {
        return height;
    }

    /**
     *
     * @param height
     */
    public void setHeight(double height) {
        this.height = height;
    }

    /**
     *
     * @return
     */
    public double getWidth() {
        return width;
    }

    /**
     *
     * @param width
     */
    public void setWidth(double width) {
        this.width = width;
    }

    /**
     *
     * @return
     */
    public LocalDate getBirthday() {
        return birthday;
    }

    /**
     *
     * @param birthday
     */
    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    /**
     *
     * @return
     */
    public LocalTime getTotalTimeRace() {
        return totalTimeRace;
    }

    /**
     *
     * @param totalTimeRace
     */
    public void setTotalTimeRace(LocalTime totalTimeRace) {
        this.totalTimeRace = totalTimeRace;
    }

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
