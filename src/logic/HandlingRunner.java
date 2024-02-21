package logic;

import view.Run;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

/**
 * Class that Manages Race Behavior
 */
public class HandlingRunner {

    private ArrayList<Runner> runners;

    /**
     * Constructor that allows creating the instance of objects of this class
     */
    public HandlingRunner() {
        this.runners = new ArrayList<>();
    }

    /**
     * Method that allows you to find for a broker by his id
     * @param idRunner receives the runner's id
     * @return returns the object if it exists, if not, returns null
     */
    public Runner findRunner(int idRunner) {
        for (Runner runner : runners) {
            if (idRunner == runner.getIdRunner()) {
                return runner;
            }
        }
        return null;
    }

    /**
     * Method that allows adding a runner
     * @param runner receives information of the runner (object)
     * @return If the runner ID already exists it returns false, otherwise it returns true.
     */
    public boolean addRunner(Runner runner){
        if( findRunner(runner.getIdRunner()) == null ){
            runners.add( runner );
            return true;
        }
        return false;
    }

    /**
     * Method that returns the instance of the winning runner of the race, the one who has invested the least time in
     * finish the race
     *
     * @return The instance of the winning runner
     */
    public Runner getChampion(){

        Runner champion = runners.get(0);
        for (int i = 1; i < runners.size(); i++){
            if (runners.get(i).getTotalTimeRace().isBefore(champion.getTotalTimeRace())) {
                champion = runners.get(i);
            }
        }
        return champion;
    }

    /**
     * Method that calculates the average running time of runners
     * @return the average running time of the runners
     */
    public LocalTime getAverage(){
        int seconds = 0;

        for (Runner runner : runners) {
            seconds += runner.getTotalTimeRace().toSecondOfDay();
        }

        int averageSeconds = seconds / runners.size();
        LocalTime average = LocalTime.ofSecondOfDay(averageSeconds);

        return average;
    }

    /**
     * Method that shows the slowest runner in the race, the one with the most time spent
     * @return the slowest runner in the race returns
     */
    public Runner getRunnerSlow(){

        Runner slow = runners.get(0);
        for (int i = 1; i < runners.size(); i++){
            if (runners.get(i).getTotalTimeRace().isAfter(slow.getTotalTimeRace())) {
                slow = runners.get(i);
            }
        }
        return slow;
    }

    /**
     * Method that shows the classification of runners from first to last
     * @return returns the runners' data in tabular form
     */
    public String showClasification(){
        ArrayList<Runner> runner = getRunners();

        runner.sort(Comparator.comparing(Runner::getTotalTimeRace));

        String result = String.format("%-7s %-19s %-11s %-11s %-19s %s ",
                "ID", "Name Runner",  "Height", "Width", "Birthday", "Total Time Race");

        for (Runner runners : runner){
            result = String.format("%s \n%-4d \t%-18s \t%-10.1f \t%-10.2f\t%-15s \t%s ",
                    result,
                    runners.getIdRunner(),
                    runners.getNameRunner(),
                    runners.getHeight(),
                    runners.getWidth(),
                    runners.getBirthday().toString(),
                    runners.getTotalTimeRace().toString());
        }
        return result;
    }

    /**
     * Shows the arrangement of the corridors
     * @return the array
     */
    public ArrayList<Runner> getRunners(){

        return new ArrayList<>(runners);
    }
}
