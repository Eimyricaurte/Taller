package logic;

import view.Run;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

/**
 *
 */
public class HandlingRunner {

    private ArrayList<Runner> runners;

    /**
     *
     */
    public HandlingRunner() {
        this.runners = new ArrayList<>();
    }

    /**
     *
     * @param idRunner
     * @return
     */
    public Runner findRunner(int idRunner){
        for (Runner runner : runners){
            if (idRunner == runner.getIdRunner()){
                return runner;
            }
        }
        return null;
    }

    /**
     *
     * @param runner
     * @return
     */
    public boolean addRunner(Runner runner){
        if( findRunner(runner.getIdRunner()) == null ){
            runners.add( runner );
            return true;
        }
        return false;
    }

    /**
     * Retorna la instancia del corredor ganador de la carrera, el que ha invertido el menor tiempo en
     * terminar la carrera
     * @return
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
     * Retorna el promedio de tiempo de carrera de los corredores
     * @return
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
     * Retorna el corredor más lento de la carrera, el de mayor tiempo gastado
     * @return
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
     * Retorna un String con la clasificación de corredores del primero al último, la salida debe ser
     * formateada para visualizar los datos en forma tabuladas
     * @return
     */
    public String showClasification(){
        ArrayList<Runner> runner = getRunners();

        runner.sort(Comparator.comparing(Runner::getTotalTimeRace));

        String result = String.format("%-7s %-19s %-11s %-11s %-19s %s ",
                "ID", "Name Runner", "Width", "Height", "Birthday", "Total Time Race");

        for (Runner runners : runner){
            result = String.format("%s \n%-4d \t%-18s \t%-10.1f \t%-10.2f\t%-15s \t%s ",
                    result,
                    runners.getIdRunner(),
                    runners.getNameRunner(),
                    runners.getWidth(),
                    runners.getHeight(),
                    runners.getBirthday().toString(),
                    runners.getTotalTimeRace().toString());
        }
        return result;
    }

    /**
     * Retorna el arreglo de los corredores
     * @return
     */
    public ArrayList<Runner> getRunners(){

        return new ArrayList<>(runners);
    }
}
