package money.master.backend;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

public class Spending {
    private String     item;
    private BigDecimal amt;
    private boolean    essential;
    private String     name;
    private boolean    change; //Gain or Lose
    private LocalDate  localDate;
    
    public Spending() {
    
    }
    
    public Spending(String item, BigDecimal amt, boolean essential, String name,
                    boolean change, LocalDate localDate) {
        this.item      = item;
        this.amt       = amt;
        this.essential = essential;
        this.name      = name;
        this.change    = change;
        this.localDate = localDate;
    }
    
    public static Salary getSum(List<Spending> fixedList) {
        BigDecimal sum = BigDecimal.ZERO;
        
        for (Spending s : fixedList) {
            if (s.isGain()) sum = sum.subtract(s.getAmt());
            else sum = sum.add(s.getAmt());
        }
        
        return new Salary(sum);
    }
    
    public String getItem() {
        return item;
    }
    
    public void setItem(String item) {
        this.item = item;
    }
    
    public BigDecimal getAmt() {
        return amt;
    }
    
    public void setAmt(BigDecimal amt) {
        this.amt = amt;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public boolean isGain() {
        return change;
    }
    
    public String getChange() {
        if (change) return "Gain";
        else return "Loss";
    }
    
    public void setChange(boolean change) {
        this.change = change;
    }
    
    public LocalDate getLocalDate() {
        return localDate;
    }
    
    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }
    
    public boolean isEssential() {
        return essential;
    }
    
    public String getEssential() {
        if (essential) return "Essential";
        else return "Non-essential";
    }
    
    public void setEssential(boolean essential) {
        this.essential = essential;
    }
}
