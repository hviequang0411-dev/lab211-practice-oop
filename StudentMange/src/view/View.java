package view;

import controller.StudentController;
import validate.Validation;

import java.util.Scanner;

public class View {
    public  Scanner scanner = new Scanner(System.in);
    public  Validation validation = new Validation();
    public StudentController controller = new StudentController();
    public void showMainMenu() {
        controller.displayAll(controller.initData());
        while (true) {
            System.out.println("\nWELCOME TO STUDENT MANAGEMENT");
            System.out.println("1. Create");
            System.out.println("2. Find and Sort");
            System.out.println("3. Update/Delete");
            System.out.println("4. Report");
            System.out.println("5. Exit");
            int opts =  validation.inputInt("Please choose 1 to Create, 2 to Find and Sort, "
                    + "3 to Update/Delete, 4 to Report and 5 to Exit: ", 1, 5);

            switch (opts){
                case 1: controller.createStudents();
                break;
                case 2:controller.findAndSort();
                break;
                case 3:controller.updateOrDelete();
                break;
                case 4:controller.getReport();
                break;
                case 5: System.exit(0);
            }
        }
    }

}
