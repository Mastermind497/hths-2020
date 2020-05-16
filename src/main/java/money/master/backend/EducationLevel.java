package money.master.backend;

public class EducationLevel {
    private String educationlevel;
    
    public static final EducationLevel PhD       = new EducationLevel("Ph. D"    );
    public static final EducationLevel MD        = new EducationLevel("M.D."     );
    public static final EducationLevel Masters   = new EducationLevel("Masters"  );
    public static final EducationLevel Bachelors = new EducationLevel("Bachelors");
    
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
