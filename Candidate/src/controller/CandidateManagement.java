package controller;

import model.Candidate;
import model.Experience;
import model.Fresher;
import model.Internship;
import validate.Validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class CandidateManagement {
    private  final List<Candidate> candidateList= new ArrayList<>();

    public List<Candidate> intiCandidateList() {
        candidateList.add(new Experience("cd01", "Quang", "Hoang", 2002, "HN", "0345025946", "quangxamluz@gmail.com", 0,4,"java"));
        candidateList.add(new Fresher("cd02", "Quang", "Hoang", 2002, "HN", "0345025946", "quangxamuz@gmail.com",1,"2026","Good","FPT"));
        candidateList.add(new Internship("cd03", "Quang", "Hoang", 2002, "HN", "0345025946", "quangxamlz@gmail.com",2,"se",2,"FPT"));
        return candidateList;
    }

    public boolean isDuplicate(String id) {
        for(Candidate c: candidateList) {
            if(c.getCandidateId().equalsIgnoreCase(id)){
                return true;
            }
        }
        return false;
    }

    public void createExpirience(){
        System.out.println("Create expirience");
        String id;
        while(true){
            id = Validation.getString("Enter ID");
            if(!isDuplicate(id)){
                break;
            }
            System.out.println("Duplicate ID pleas try again");
         }

        String firtName =  Validation.getString(
                        "Enter first name: ");

        String lastName =
                Validation.getString(
                        "Enter last name: ");

        int birthYear =
                Validation.getBirthDate();

        String address =
                Validation.getString(
                        "Enter address: ");

        String phone =
                Validation.getPhone();

        String email =
                Validation.getEmail();

        int expInYear =
                Validation.getInt(
                        "Enter experience year: ",
                        0,
                        100
                );

        String proSkill =
                Validation.getString(
                        "Enter professional skill: ");

       candidateList.add(
               new Experience(
                       id,
                       firtName,
                       lastName,
                       birthYear,
                       address,
                       phone,
                       email,
                       0,
                       expInYear,
                       proSkill

               ));
       System.out.println("Experience created");

       boolean choice = Validation.getYesNo();
       if(!choice){
           return;
       }
        displayAll(candidateList);

}
    public void createFresher(){
           System.out.println("Create fresher");
           String id;
           while(true){
               id= Validation.getString("Enter ID");
               if(!isDuplicate(id)){
                   break;
               }
               System.out.println("Duplicate ID pleas try again");
           }
        String firstName =
                Validation.getString(
                        "Enter first name: ");

        String lastName =
                Validation.getString(
                        "Enter last name: ");

        int birthYear =
                Validation.getBirthDate();

        String address =
                Validation.getString(
                        "Enter address: ");

        String phone =
                Validation.getPhone();

        String email =
                Validation.getEmail();

        String graduationDate =
                Validation.getString(
                        "Enter graduation date: ");

        String graduationRank =
                Validation.getRank();

        String education =
                Validation.getString(
                        "Enter university: ");

        candidateList.add(
                new Fresher(
                        id,
                        firstName,
                        lastName,
                        birthYear,
                        address,
                        phone,
                        email,
                        1,
                        graduationDate,
                        graduationRank,
                        education
                )
        );
        System.out.println("Fresher created");
        boolean choice = Validation.getYesNo();
        if(!choice){
            return;
        }
        displayAll(candidateList);
    }
    public void createIntership(){
                System.out.println("\n===== CREATE INTERNSHIP =====");
        String id;
            while (true) {

                id = Validation.getString(
                        "Enter id: ");

                if (!isDuplicate(id)) {
                    break;
                }

                System.out.println(
                        "ID already exists!");
            }
            String firstName =
                    Validation.getString(
                            "Enter first name: ");

            String lastName =
                    Validation.getString(
                            "Enter last name: ");

            int birthYear =
                    Validation.getBirthDate();

            String address =
                    Validation.getString(
                            "Enter address: ");

            String phone =
                    Validation.getPhone();

            String email =
                    Validation.getEmail();

            String majors =
                    Validation.getString(
                            "Enter majors: ");

            int semester =
                    Validation.getInt(
                            "Enter semester: ",
                            1,
                            9
                    );

            String universityName =
                    Validation.getString(
                            "Enter university: ");

            candidateList.add(
                    new Internship(
                            id,
                            firstName,
                            lastName,
                            birthYear,
                            address,
                            phone,
                            email,
                            2,
                            majors,
                            semester,
                            universityName
                    )
            );

            System.out.println(
                    "Add internship candidate successfully!");

            boolean choice = Validation.getYesNo();
            if(!choice){
                return;
            }
        displayAll(candidateList);
    }
    public void displayCandidateList(){
           System.out.println("===========EXPERIENCE CANDIDATE============");
           for(Candidate c: candidateList){
               if(c instanceof Experience){
                   System.out.println(c.getFullName());
               }
           }
           System.out.println("==========FRESHER CANDIDATE==============");
           for(Candidate c: candidateList){
               if(c instanceof Fresher){
                   System.out.println(c.getFullName());
               }
           }
           System.out.println("===========INTERN CANDIDATE==============");
           for(Candidate c: candidateList){
               if(c instanceof Internship){
                   System.out.println(c.getFullName());
               }
           }
    }
    public void search(){
        displayCandidateList();
        String name = Validation.getString("Enter name: ");
        int type = Validation.getInt("Input Type of candidate:",0,2);
        List<Candidate> foundCandidates = new ArrayList<>();
        for( Candidate c: candidateList) {
            boolean matchName = c.getFullName().toLowerCase().contains(name.toLowerCase());
            boolean matchType = c.getCandidateType() == type;

            if (matchName && matchType) {
                foundCandidates.add(c);
            }
        }
        if(foundCandidates.isEmpty()){
            System.out.println("Candidate not found");
            return;
        }
        System.out.println("Candidate found");
        displayAll(foundCandidates);
    }
    public void displayAll(List list){
          for(Object o: list){
              System.out.println(o);
          }
    }
}
