package view;

import controller.CandidateManagement;
import validate.Validation;

import java.util.Scanner;

public class Menu {
    public static Scanner sc = new Scanner(System.in);
    private static final CandidateManagement candidateManagement= new CandidateManagement();;
    public static String[] menu ={
              "1.Experience\n" +
              "2.Fresher\n" +
              "3.Internship\n" +
              "4.Searching\n" +
              "5.Exit",
    };
    public static void displayMenu() {
        System.out.println("CANDIDATE MANAGEMENT SYSTEM");
        candidateManagement.displayAll(candidateManagement.intiCandidateList());
        for (int i = 0; i < menu.length; i++) {
            System.out.println(menu[i]);
        }
        System.out.println(" (Please choose 1 to Create Experience Candidate, 2 to Create Fresher Candidate, 3 to Internship Candidate, 4 to Searching and 5 to Exit program).");
        while (true){
        int choice = Validation.getInt("Enter urs chioce",1,5);

        switch (choice) {
            case 1: candidateManagement.createExpirience();
            break;
            case 2: candidateManagement.createFresher();
            break;
            case 3: candidateManagement.createIntership();
            break;
            case 4:candidateManagement.search();
            break;
            case 5 : System.exit(0);

        }
        }

    }
}
