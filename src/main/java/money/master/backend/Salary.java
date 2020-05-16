package money.master.backend;

import java.math.BigDecimal;

public class Salary {
    private BigDecimal salary;
    private String personName;
    
    public Salary(BigDecimal salary) {
        this.salary = salary;
    }
    
    public Salary(String name, BigDecimal salary) {
        this.personName = name;
        this.salary = salary;
    }
    
    public BigDecimal getSalary() {
        return salary;
    }
    
    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }
}
