package money.master.backend;

import java.math.BigDecimal;

public class Spending {
    private String item;
    private BigDecimal amt;
    private boolean essential;
    private String name;
    private boolean change; //Gain or Lose
    private BigDecimal localDate;

    public Spending(){

    }

    public Spending(String item, BigDecimal amt) {
        this.item = item;
        this.amt  = amt;
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

    public BigDecimal getLocalDate() {
        return localDate;
    }
    public boolean isEssential() {
        return essential;
    }
}
