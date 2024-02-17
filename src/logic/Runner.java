package logic;

import java.time.LocalDate;
import java.time.LocalTime;

public class Runner {

    private int idRunner;

    private String nameRunner;

    private double height;

    private double width;

    private LocalDate birthday;

    private LocalTime totalTimeRace;

    public Runner(int idRunner, String nameRunner, double height, double width, LocalDate birthday, LocalTime totalTimeRace) {
        this.idRunner = idRunner;
        this.nameRunner = nameRunner;
        this.height = height;
        this.width = width;
        this.birthday =  birthday;
        this.totalTimeRace =  totalTimeRace;
    }

    public int getIdRunner() {
        return idRunner;
    }

    public void setIdRunner(int idRunner) {
        this.idRunner = idRunner;
    }

    public String getNameRunner() {
        return nameRunner;
    }

    public void setNameRunner(String nameRunner) {
        this.nameRunner = nameRunner;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public LocalTime getTotalTimeRace() {
        return totalTimeRace;
    }

    public void setTotalTimeRace(LocalTime totalTimeRace) {
        this.totalTimeRace = totalTimeRace;
    }
}
