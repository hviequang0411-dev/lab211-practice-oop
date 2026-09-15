package model;
//
//public class Fresher extends Candidate {
//    private String graduationDate;
//    private String graduationRank;
//    private String education;
//
//
//
//    public Fresher(String candidateId,
//                   String firstName,
//                   String lastName,
//                   int birthYear,
//                   String address,
//                   String phone,
//                   String email,
//                   int candidateType,
//                   String graduationDate,
//                   String graduationRank,
//                   String education) {
//
//        super(candidateId,
//                firstName,
//                lastName,
//                birthYear,
//                address,
//                phone,
//                email,
//                candidateType);
//
//        this.graduationDate = graduationDate;
//        this.graduationRank = graduationRank;
//        this.education = education;
//    }
//
//    public String getGraduationDate() {
//        return graduationDate;
//    }
//
//    public void setGraduationDate(String graduationDate) {
//        this.graduationDate = graduationDate;
//    }
//
//    public String getGraduationRank() {
//        return graduationRank;
//    }
//
//    public void setGraduationRank(String graduationRank) {
//        this.graduationRank = graduationRank;
//    }
//
//    public String getEducation() {
//        return education;
//    }
//
//    public void setEducation(String education) {
//        this.education = education;
//    }
//}
/*-graduated time (Graduation_date), Rank of Graduation (Graduation_rank) and university where student graduated (Education)
* */
public class Fresher extends Candidate {
    private  String graduationDate;
    private String graduationRank;
    private String education;

    public Fresher(String candidateId, String firstName, String lastName, int birthYear, String address, String phone, String email, int candidateType, String graduationDate, String graduationRank, String education) {
        super(candidateId, firstName, lastName, birthYear, address, phone, email, candidateType);
        this.graduationDate = graduationDate;
        this.graduationRank = graduationRank;
        this.education = education;
    }

    public String getGraduationDate() {
        return graduationDate;
    }

    public void setGraduationDate(String graduationDate) {
        this.graduationDate = graduationDate;
    }

    public String getGraduationRank() {
        return graduationRank;
    }

    public void setGraduationRank(String graduationRank) {
        this.graduationRank = graduationRank;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }
}
