package money.master.backend;

public class EducationLevel {
    private String educationlevel;
    
    public static EducationLevel PhD = new EducationLevel("Ph. D");
    public static EducationLevel Masters = new EducationLevel("Masters");
    public static EducationLevel Bachelors = new EducationLevel("Bachelors");
    
    private EducationLevel(String educationlevel) {
        this.educationlevel = educationlevel;
    }
    
    public String getEducationlevel() {
        return educationlevel;
    }
}
