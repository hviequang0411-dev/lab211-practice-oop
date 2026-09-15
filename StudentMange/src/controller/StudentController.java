package controller;

import model.Student;
import validate.Validation;
import view.View;

import java.util.*;

public class StudentController {
    public List<Student> studentList = new ArrayList<>();
    public Validation validation = new Validation();
    public List<Student> initData() {
        studentList.add(new Student("st01","quang","FALL26","Java"));
        studentList.add(new Student("st02","quang1","FALL26","Java"));
        studentList.add(new Student("st03","quang2","FALL26","Java"));
        studentList.add(new Student("st04","quang3","FALL26","Java"));
        studentList.add(new Student("st05","quang4","FALL26","Java"));
        studentList.add(new Student("st06","quang5","FALL26","Java"));
        studentList.add(new Student("st07","quang6","FALL26","Java"));
        studentList.add(new Student("st08","quang7","FALL26","Java"));
        studentList.add(new Student("st09","quang8","FALL26","Java"));
        return studentList;
    }
    public void createStudents() {
        while (true) {
            String id = validation.inputNonEmpty("Enter student ID: ").toUpperCase();
            String studentName = validation.inputName("Enter student name: ");
            boolean checkID=true;
            for (Student student : studentList) {
                if (student.getId().equals(id) && !student.getStudentName().equals(studentName)) {
                    checkID = false;
                    break;
                }
                }
            if(!checkID) {
                System.out.println("Student id already exists student:");
                continue;
            }
                String semester = validation.inputNonEmpty("Enter semester: ").toUpperCase();
                String course = validation.inputCourse("Enter course: ");
                boolean checkDuplicate=true;
                for (Student student : studentList) {
                    if (student.getStudentName().equals(studentName) && student.getSemester().equals(semester) && student.getCourseName().equals(course)) {
                        checkDuplicate = false;
                        break;
                    }
                }
                if(!checkDuplicate) {
                    System.out.println("Duplicate student try again");
                    continue;
                }
                studentList.add(new Student(id, studentName, semester, course));
                System.out.println("Student information created successfully.");
                if(studentList.size() >= 10) {
                    boolean opts = validation.getYesOrNo("Do you want to continue?[Y/N]" + ":" + "Y to continue" + " N to exit");
                    if (!opts) {
                        System.out.println("Exiting program.");
                        return;
                    }
                }
            }
    }
    public void findAndSort() {
        if(studentList.isEmpty()) {
            System.out.println("There is no student to search");
            createStudents();
        }
        List<Student> searchList = new ArrayList<>();
        String inputName = validation.inputNonEmpty("Enter student name: ").trim().toLowerCase();
        for(Student student : studentList) {
             if(student.getStudentName().trim().toLowerCase().contains(inputName)) {
                 searchList.add(student);
             }
        }
        if(searchList.isEmpty()) {
            System.out.println("There is no student to search");
            return;
        }
        //sort by name
        searchList.sort(Comparator.comparing(Student::getStudentName,String.CASE_INSENSITIVE_ORDER));
        displayAll(searchList);
    }

    public void updateOrDelete() {
        if(studentList.isEmpty()) {
            System.out.println("There are no students please add");
            createStudents();
        }
        //find by id
        List<Student> resultList = new ArrayList<>();
        while(resultList.isEmpty()) {
            String id = validation.inputNonEmpty("Enter student ID: ").trim().toLowerCase();
            for(Student student : studentList) {
                if(student.getId().equals(id)) {
                    resultList.add(student);
                }
            }
            if(resultList.isEmpty()) {
                System.out.println("ID not found try again");
            }
        }
        //display student with constrain
        displayAll(resultList);

        //get index
        int index = validation.inputInt("Chose student",1,resultList.size());
        Student student = resultList.get(index-1);
        System.out.println("Your chose Student ID: " + student.getId());
        String opts = validation.inputNonEmpty("U/D"+"U: update"+"D: delete");
        //Update
        if(opts.equalsIgnoreCase("u")) {
            System.out.println("Enter update information");
            String name = validation.inputNonEmpty("Enter student name: ");
            String semester = validation.inputNonEmpty("Enter semester:");
            String course = validation.inputCourse("Enter course:");
            student.setStudentName(name);
            student.setSemester(semester);
            student.setCourseName(course);
            System.out.println("Student information updated successfully.");
        }
        //Delete
        if(opts.equalsIgnoreCase("d")) {
            boolean chose = validation.getYesOrNo("Do you want to delete[Y/N]");
            if(chose) {
                studentList.remove(student);
            }
        }

    }
    public void getReport(){
        //initalize reportMap
        Map<String,Integer> reportMap = new HashMap<>();
        //set key,value cho hashmap
        for(Student student : studentList) {
           String key = student.getId()+"|"+ student.getStudentName()+"|"+student.getCourseName();
           reportMap.put(key, reportMap.getOrDefault(key, 0) + 1);
        }
        //display
        System.out.printf(
                "%-10s| %-10s | %-5s%n",
                "Student",
                "Course",
                "Total"
        );
        System.out.println(
                "-----------------------------------------------"
        );
        for(Map.Entry<String,Integer> entry : reportMap.entrySet()) {
            String[] splitKey = entry.getKey().split("\\|");
            String id = splitKey[0];
            String name = splitKey[1];
            String course = splitKey[2];
            int total = entry.getValue();

            System.out.printf("%-10s| %-10s | %-5s%n",
            name,
            course,
            total
            );

        }



    }
    public void displayAll(List<Student> studentList) {
        if(studentList.isEmpty()) {
            System.out.println("There are no students please add");
            createStudents();
        }
        System.out.printf(
                "%-5s| %-10s | %-25s | %-12s | %-10s%n",
                "No",
                "ID",
                "Student Name",
                "Semester",
                "Course"
        );
        System.out.println(
                "--------------------------------------------------------------------"
        );
        int index =1;
        for(Student student : studentList) {
            System.out.printf(
                    "%-5d| %-10s | %-25s | %-12s | %-10s%n",
                    index,
                    student.getId(),
                    student.getStudentName(),
                    student.getSemester(),
                    student.getCourseName()
            );
            index ++;
        }
    }
    //displayReport


}
