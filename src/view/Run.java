package view;

import logic.HandlingRunner;
import logic.Runner;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 */
public class Run {
    private static HandlingRunner handlingRunner;
    public static Run run = new Run();

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        run.menu();

    }
    Scanner sc = new Scanner(System.in);

    /**
     *
     */
    public void menu(){
        boolean state = true;
        try {
            while (state) {
                handlingRunner = new HandlingRunner();
                int option;
                    System.out.println("******************* MENU *******************\n" +
                            "1. Add Runner\n" +
                            "2. Find Runner\n" +
                            "3. Champion\n" +
                            "4. Average Times\n" +
                            "5. Slow Runner\n" +
                            "6. Show Classification\n" +
                            "7. Show Runners\n" +
                            "8. Exit");

                    option = sc.nextInt();
                    switch (option) {
                        case 1:
                            addRunner();
                            break;
                        case 2:
                            handlingRunner.getRunners();
                            findRunner();
                            break;
                        case 3:
                            handlingRunner.getChampion();
                            break;
                        case 4:
                            handlingRunner.getAverage();
                            break;
                        case 5:
                            handlingRunner.getRunnerSlow();
                            break;
                        case 6:
                            handlingRunner.showClasification();
                            break;
                        case 7:
                            handlingRunner.getRunners();
                        case 8:
                            state = false;
                            break;
                        default:
                            System.err.println("Invalid Option");
                    }
            }
        }catch (Exception e){
            System.err.println("Invalid option");
        }
    }

    /**
     *
     */
    public void addRunner(){
        boolean state = true;
        try {
            while (state) {
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

                getRunners();

                System.out.println("Do you want to add another runner: enter 1. No, or 2. Yes");
                int add = sc.nextInt();
                if (add == 1) {
                    state = false;
                    menu();
                }
            }
        }catch (Exception e){
            System.err.println("Invalid Option");
        }
    }

    /**
     *
     */
    public void findRunner() {
        boolean state = true;
        try {
            while (state) {
                System.out.println("Enter the ID of the candidate you want to find for: ");
                int id = sc.nextInt();
                getRunners();
                System.out.println(handlingRunner.findRunner(id));

                System.out.println("Do you want to find another runner? enter 1. No, or 2. Yes");
                int option = sc.nextInt();
                if (option == 1) {
                    state = false;
                }
            }
        }catch (Exception e){
            System.err.println("Invalid Option");
        }
    }

    /**
     *
     */
    public void getRunners(){
        handlingRunner.getRunners().stream().forEach(
                runner -> {
                    System.out.println(runner.toString());
                });
    }
}