package model;
//
//public class Internship extends Candidate {
//
    //    private String majors;
    //    private int semester;
    //    private String universityName;
//
//    public Internship(String candidateId, String firstName, String lastName, int birthYear, String address, String phone, String email, int candidateType, String majors, int semester, String universityName) {
//        super(candidateId, firstName, lastName, birthYear, address, phone, email, candidateType);
//        this.majors = majors;
//        this.semester = semester;
//        this.universityName = universityName;
//    }
//
//    public String getMajors() {
//        return majors;
//    }
//
//    public void setMajors(String majors) {
//        this.majors = majors;
//    }
//
//    public int getSemester() {
//        return semester;
//    }
//
//    public void setSemester(int semester) {
//        this.semester = semester;
//    }
//
//    public String getUniversityName() {
//        return universityName;
//    }
//
//    public void setUniversityName(String universityName) {
//        this.universityName = universityName;
//    }
//}
/*- Majors, Semester, University name
* */
public class Internship extends Candidate{
        private String majors;
        private int semester;
        private String universityName;

    public Internship(String candidateId, String firstName, String lastName, int birthYear, String address, String phone, String email, int candidateType, String majors, int semester, String universityName) {
        super(candidateId, firstName, lastName, birthYear, address, phone, email, candidateType);
        this.majors = majors;
        this.semester = semester;
        this.universityName = universityName;
    }

    public String getMajors() {
        return majors;
    }

    public void setMajors(String majors) {
        this.majors = majors;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }
}