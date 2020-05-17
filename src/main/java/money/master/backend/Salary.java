package money.master.backend;

import java.math.BigDecimal;
import java.util.*;

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
    
    public Salary getRemaining(List<Spending> spendingList, BigDecimal saving) {
        BigDecimal remainder = salary.subtract(saving);
        for (Spending s : spendingList) {
            if (s.isGain()) remainder = remainder.add(s.getAmt());
            else remainder = remainder.subtract(s.getAmt());
        }
        
        return new Salary(remainder);
    }
    
    @Override
    public String toString() {
        return String.format("$%s", salary.toString());
    }
}
