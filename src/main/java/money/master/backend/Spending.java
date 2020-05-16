package money.master.backend;

import java.math.BigDecimal;

public class Spending {
    private final String     item;
    private final BigDecimal amt;
    
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
