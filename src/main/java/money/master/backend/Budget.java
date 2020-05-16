package money.master.backend;

public class Budget {
    private Salary         salary;
    private EducationLevel educationLevel;
    
    public Budget(Salary salary, EducationLevel edulvl){
        this.salary         = salary;
        this.educationLevel = edulvl;
    }

    public Salary getSalary() {return salary;}

    public void setSalary(Salary salary) {this.salary = salary;}

    public EducationLevel getEducationLevel() {return educationLevel;}

    public void setEducationLevel(EducationLevel educationLevel) { this.educationLevel = educationLevel;}
}
