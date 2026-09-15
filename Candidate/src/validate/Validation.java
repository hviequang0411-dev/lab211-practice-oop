package validate;

import java.time.LocalDate;
import java.util.Scanner;

//
//import java.time.Year;
//import java.util.Scanner;
//
//public class Validation {
//    public static final Scanner sc =new Scanner(System.in);
//    public static int getInt(String mgs,int min , int max){
//        while(true){
//            System.out.println(mgs);
//            int input = Integer.parseInt(sc.nextLine());
//            try {
//                if(input >= min && input <= max){
//                    return input;
//                }
//                System.out.println("Number must be between " + min + " and " + max);
//            }
//            catch(NumberFormatException ex){
//                System.out.println("Invalid input" );
//            }
//        }
//    }
//    public static String getString(String mgs){
//        while(true){
//            System.out.println(mgs);
//            String input = sc.nextLine().trim();
//            if(!input.isEmpty()){
//               return input;
//            }
//            System.out.println("Input cannot be empty!");
//        }
//    }
//    public static int getBithYear(){
//        int currentYear = Year.now().getValue();
//        return getInt("Enter Birth Year",1900,currentYear);
//    }

//    public static String getEmail() {
//        while (true) {
//             String email = getString("Enter Email");
//             if(email.matches(
//                     "^[A-Za-z0-9+_.-]+@(.+)$"
//             )){
//                 return email;
//             }
//             System.out.println("Invalid email");
//        }
//    }
//    public static String getRank(){
//        while (true) {
//            String rank = getString("Enter Rank");
//            if (rank.equalsIgnoreCase("Excellent")
//                    || rank.equalsIgnoreCase("Good")
//                    || rank.equalsIgnoreCase("Fair")
//                    || rank.equalsIgnoreCase("Poor")) {
//
//                return rank;
//            }
//            System.out.println("Rank must be one of 'Excellent', 'Good', 'Fair', 'Poor'");
//        }
//    }
//
//}
public class Validation {
    private static Scanner sc = new Scanner(System.in);
    public static int getInt(String mgs,int min , int max){
        while(true){
            System.out.println(mgs);
            int input = Integer.parseInt(sc.nextLine());
            try {
                if(input >= min && input <= max){
                    return input;
                }
                System.out.println("Number must be between " + min + " and " + max);
            }
            catch(NumberFormatException ex){
                System.out.println("Invalid input" );
            }
        }
    }
    public static String getString(String mgs){
        while(true){
            System.out.println(mgs);
            String input = sc.nextLine().trim();
            if(!input.isEmpty()){
               return input;
            }
            System.out.println("Input cannot be empty!");
        }
    }
    /*
    Phone: is number with minimum 10 characters
     oBirth Date : is number with length is 4 character (1900..Current Year)


Email: with format <account name>@<domain>. (eg: annguyen@fpt.edu.vn)
Year of Experience : is number from 0 to 100

oRank of Graduation: with one of 4 values (Excellence, Good, Fair, Poor)*/
    public static int getBirthDate(){
        int currentYear = LocalDate.now().getYear();
        int birthDate = getInt("Enter Birth Date",1900,currentYear);
        return birthDate;
    }
    public static String getPhone() {
        while (true) {
            String phone = getString("Enter Phone Number");
            if (phone.matches("\\d{10,}")) {
                return phone;
            }
            System.out.println("phone must have at least 10 digits");
        }
    }
    public static String getEmail(){
        while(true){
            String email = getString("Enter Email");
            if(email.matches("[A-Za-z0-9+_.]+@(.+)")){
                return email;
            }
            System.out.println("Invalid email!");
        }
    }
    public static String  getRank(){
        while(true){
            String rank = getString("Enter Rank");
            if(rank.equalsIgnoreCase("Excellence")||rank.equalsIgnoreCase("Good")||rank.equalsIgnoreCase("Fair")||rank.equalsIgnoreCase("Poor")){
                return rank;
            }
            System.out.println("Invalid rank!\n");
            System.out.println("Rank Must be \n: Excellence, Good, Fair, Poor");
        }
    }
    public static boolean getYesNo(){
        String yesNo = getString("Enter Yes/No+\n [Y/N]: y to continue n to stop");
        if(yesNo.equalsIgnoreCase("Yes")){
            return true;
        }
        return false;
    }

}