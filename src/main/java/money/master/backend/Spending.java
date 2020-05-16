package money.master.backend;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Spending {
    private String item;
    private BigDecimal amt;
    private boolean essential;
    private String name;
    private boolean change; //Gain or Lose
    private LocalDate localDate;

    public Spending(){

    }

    public void setItem(String item) {
        this.item = item;
    }

    public void setAmt(BigDecimal amt) {
        this.amt = amt;
    }

    public void setEssential(boolean essential) {
        this.essential = essential;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setChange(boolean change) {
        this.change = change;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public Spending(String item, BigDecimal amt, boolean essential, String name,
                    boolean change, LocalDate localDate) {
        this.item = item;
        this.amt  = amt;
        this.essential = essential;
        this.name = name;
        this.change = change;
        this.localDate = localDate;
    }
    
    public String getItem() {
        return item;
    }
    
    public BigDecimal getAmt() {
        return amt;
    }

    public String getName() {
        return name;
    }

    public boolean isChange() {
        return change;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }
    public boolean isEssential() {
        return essential;
    }
}
