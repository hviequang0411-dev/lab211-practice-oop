package validate;

import java.util.Scanner;

public class Validation {
    public  Scanner scanner = new Scanner(System.in);

    public String inputNonEmpty(String message) {
        while (true) {
            System.out.print(message);
            String value = scanner.nextLine().trim().replaceAll("\\s+"," ");
            if (!value.isEmpty()) {
                return value;
            }
            System.out.println("Input cannot be empty. Please try again.");
        }
    }
    public String inputName(String mess){
        while(true){
            System.out.print(mess);
            String name = inputNonEmpty(mess);
            if(name.matches("[A-Za-z ]{5,30}")){
                return formatString(name);
            }
            System.out.println("Name formant must be Nguyen Van a");
        }
    }
    public String formatString(String word){
         word = word.trim().toLowerCase();
         StringBuilder builder = new StringBuilder();
         for(String text : word.split(" ")){
             builder.append(Character.toUpperCase(text.charAt(0)));
             builder.append(text.substring(1));
             builder.append(" ");
         }
         return builder.toString().trim();
    }

    public int inputInt(String message, int min, int max) {
        while (true) {
            String value = inputNonEmpty(message);
            try {
                int number = Integer.parseInt(value);
                if (number >= min && number <= max) {
                    return number;
                }
            } catch (NumberFormatException ignored) {
                // The common error message below is sufficient for both cases.
            }
            System.out.printf("Please enter a number from %d to %d.%n", min, max);
        }
    }
    public String inputCourse(String message) {
        while (true) {
            String value = inputNonEmpty(message);
            if (value.equalsIgnoreCase("Java")) {
                return "Java";
            }
            if (value.equalsIgnoreCase(".Net") || value.equalsIgnoreCase("Net")) {
                return ".Net";
            }
            if (value.equalsIgnoreCase("C/C++") || value.equalsIgnoreCase("C++")) {
                return "C/C++";
            }
            System.out.println("Course must be Java, .Net, or C/C++.");
        }
    }


    public boolean getYesOrNo(String message) {
        while (true) {
            String value = inputNonEmpty(message);
            if (value.equalsIgnoreCase("Y")){
                return true;
            }
            else if (value.equalsIgnoreCase("N")){
                return false;
            }
            System.out.println("Please enter yes or no.");
        }
    }
}
