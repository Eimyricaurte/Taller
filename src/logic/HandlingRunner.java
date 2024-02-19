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
        return null;
    }

    public LocalTime getAverage(){
        return null;
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
