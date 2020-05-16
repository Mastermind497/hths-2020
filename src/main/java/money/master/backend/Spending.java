package money.master.backend;

import java.math.BigDecimal;

public class Spending {
    private final String     item;
    private final BigDecimal amt;
    private boolean essential;
    private String name;
    private boolean change; //Gain or Lose
    private BigDecimal localDate;
    
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
}
