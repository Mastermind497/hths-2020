package money.master.backend;

import java.math.BigDecimal;

public class Budget {
    private Salary salary;
    private EducationLevel edulvl;
    public Budget(Salary salary, EducationLevel edulvl){
        this.salary = salary;
        this.edulvl = edulvl;
    }

    public Salary getSalary() {return salary;}

    public void setSalary(Salary salary) {this.salary = salary;}

    public EducationLevel getEdulvl() {return edulvl;}

    public void setEdulvl(EducationLevel edulvl) {this.edulvl = edulvl;}
}
