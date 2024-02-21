package view;

import logic.HandlingRunner;
import logic.Runner;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 */
public class Run {
    private HandlingRunner handlingRunner;
    public static Run run;
    private Scanner sc;

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        run = new Run();
        run.sc = new Scanner(System.in);
        run.handlingRunner = new HandlingRunner();

        run.menu();
    }

    /**
     *
     */
    private void menu(){
        char option=' ';
            while (option!='8') {

                    System.out.println("******************* MENU *******************\n" +
                            "1. Add Runner\n" +
                            "2. Find Runner\n" +
                            "3. Champion\n" +
                            "4. Average Times\n" +
                            "5. Slow Runner\n" +
                            "6. Show Classification\n" +
                            "7. Show Runners\n" +
                            "8. Exit");

                    option = sc.next().charAt(0);
                    switch (option) {
                        case '1':
                            addRunner();
                            break;
                        case '2':
                            findRunner();
                            break;
                        case '3':
                            showChampion();
                            break;
                        case '4':
                            getAverage();
                            break;
                        case '5':
                            getRunnersSlow();
                            break;
                        case '6':
                            showClassification();
                            break;
                        case '7':
                            getRunners();
                        case '8':
                            System.out.println("Exit");
                            break;
                        default:
                            System.err.println("Invalid Option");
                    }
            }
    }

    /**
     *
     */
    private void addRunner(){
        char add = ' ';
        try {
            while (true) {
                System.out.println("Enter the runner ID: ");
                int id = sc.nextInt();
                sc.nextLine();

                System.out.println("Enter the name of the runner: ");
                String name = sc.next();
                sc.nextLine();

                System.out.println("Enter the Height of the runner, format -> 0,0: ");
                double height = sc.nextDouble();
                sc.nextLine();

                System.out.println("Enter the Width of the runner: ");
                double width = sc.nextDouble();
                sc.nextLine();

                System.out.println("Enter the Birthday of the runner, format -> yyyy-mm-dd,:  ");
                String birthday = sc.next();
                sc.nextLine();

                LocalDate localDate = LocalDate.parse(birthday);
                System.out.println("Enter the Total Time of the race, format -> hours:minutes (00:00), : ");
                String totalTimeRace = sc.next();
                sc.nextLine();

                LocalTime localTime = LocalTime.parse(totalTimeRace);

                handlingRunner.addRunner(new Runner(id, name, height, width, localDate, localTime));

                System.out.println("Do you want to add another runner: enter 1. No, or Other. Yes");
                add = sc.next().charAt(0);
                if (add == '1') {
                    break;
                }
            }
        }catch (Exception e){
            System.err.println("Invalid Option");
        }
    }

    /**
     *
     */
    private void findRunner() {
        int id = 0;
        char option = ' ';
        try {
            while (true) {
                System.out.println("Enter the ID of the candidate you want to find for: ");
                id = sc.nextInt();

                System.out.println(handlingRunner.findRunner(id));

                System.out.println("Do you want to find another runner? enter 1. No, or Other. Yes");
                option = sc.next().charAt(0);
                if (option == '1' ) {
                    break;
                }
            }
        }catch (Exception e){
            System.err.println("invalid data type");
        }
    }

    /**
     *
     */
    private void showChampion(){
        Runner champion = handlingRunner.getChampion();
        if (champion == null){
            System.out.println("There are no registered players \n");
        }else {
            System.out.printf("The champion is %d %s \n", champion.getIdRunner(), champion.getNameRunner());
        }
    }

    /**
     *
     */
    private void getAverage(){
        LocalTime average = handlingRunner.getAverage();
        if (average == null){
            System.out.println("There are no registered players \n");
        }else {
            System.out.println("The average is " + average);
        }
    }

    /**
     *
     */
    private void getRunnersSlow(){
        Runner slow = handlingRunner.getChampion();
        if (slow == null){
            System.out.println("There are no registered players \n");
        }else {
            System.out.printf("The runner slow is %d %s \n", slow.getIdRunner(), slow.getNameRunner());
        }
    }
    /**
     *
     */
    private void showClassification(){
        String result = String.format("%-7s %-19s %-11s %-11s %-19s %s ",
                "ID", "Name Runner",  "Height", "Width", "Birthday", "Total Time Race");

        for (Runner runners : handlingRunner.showClassification()){
            result = String.format("%s \n%-4d \t%-18s \t%-10.1f \t%-10.2f\t%-15s \t%s ",
                    result,
                    runners.getIdRunner(),
                    runners.getNameRunner(),
                    runners.getHeight(),
                    runners.getWidth(),
                    runners.getBirthday().toString(),
                    runners.getTotalTimeRace().toString());
        }
        System.out.println(result);
    }

    /**
     *
     */
    private void getRunners(){
        handlingRunner.getRunners().stream().forEach(
                runner -> {
                    System.out.println(runner.toString());
                });
    }
}