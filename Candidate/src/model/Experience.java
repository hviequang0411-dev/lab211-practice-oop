package model;
//
//public class Experience extends Candidate {
//    private int expInYear;
//    private String proSkill;
//
//
//        public Experience(String candidateId,
//                      String firstName,
//                      String lastName,
//                      int birthYear,
//                      String address,
//                      String phone,
//                      String email,
//                      int candidateType,
//                      int expInYear,
//                      String proSkill) {
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
//        this.expInYear = expInYear;
//        this.proSkill = proSkill;
//    }
//
//    public int getExpInYear() {
//        return expInYear;
//    }
//
//    public void setExpInYear(int expInYear) {
//        this.expInYear = expInYear;
//    }
//
//    public String getProSkill() {
//        return proSkill;
//    }
//
//    public void setProSkill(String proSkill) {
//        this.proSkill = proSkill;
//    }
//}
/*
* -Experience candidate: year of experience (ExpInYear), Professional Skill (ProSkill). */
public class Experience extends Candidate{
       private int experience;
       private String proSkill;
       public Experience(String candidateId, String firstName, String lastName, int birthYear, String address, String phone, String email, int candidateType, int experience, String proSkill) {
        super(candidateId, firstName, lastName, birthYear, address, phone, email, candidateType);
        this.experience = experience;
        this.proSkill = proSkill;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String getProSkill() {
        return proSkill;
    }

    public void setProSkill(String proSkill) {
        this.proSkill = proSkill;
    }
}