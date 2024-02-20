package logic;

import java.time.LocalTime;
import java.util.ArrayList;

public class HandlingRunner {

    private ArrayList<Runner> runners;

    public HandlingRunner() {
        this.runners = new ArrayList<>();
    }

    public Runner findRunner(int idRunner){
        for (Runner runner : runners){
            if (idRunner == runner.getIdRunner()){
                return runner;
            }
        }
        return null;
    }

    public boolean addRunner(Runner runner){
        if( findRunner(runner.getIdRunner()) == null ){
            runners.add( runner );
            return true;
        }
        return false;
    }

    public Runner getChampion(){

        Runner champion = runners.get(0);
        for (int i = 1; i < runners.size(); i++){
            if (runners.get(i).getTotalTimeRace().isBefore(champion.getTotalTimeRace())) {
                champion = runners.get(i);
            }
        }
        return champion;
    }

    public LocalTime getAverage(){
        int seconds = 0;

        for (Runner runner : runners) {
            seconds += runner.getTotalTimeRace().toSecondOfDay();
        }

        int averageSeconds = seconds / runners.size();
        LocalTime average = LocalTime.ofSecondOfDay(averageSeconds);

        return average;
    }

    public Runner getRunnerSlow(){
        return null;
    }

    public ArrayList<Runner> showClasification(){
        return null;
    }

    public ArrayList<Runner> getRunners(){
        return null;
    }
}
