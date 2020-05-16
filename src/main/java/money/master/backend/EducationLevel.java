package money.master.backend;

public class EducationLevel {
    private String educationlevel;
    
    public static EducationLevel PhD = new EducationLevel("Ph. D");
    public static EducationLevel MD = new EducationLevel("M.D.");
    public static EducationLevel Masters = new EducationLevel("Masters");
    public static EducationLevel Bachelors = new EducationLevel("Bachelors");
    
    private EducationLevel(String educationlevel) {
        this.educationlevel = educationlevel;
    }
    
    public String getLevel() {
        return educationlevel;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        
        EducationLevel that = (EducationLevel) o;
    
        return getLevel().equals(that.getLevel());
    }
}
