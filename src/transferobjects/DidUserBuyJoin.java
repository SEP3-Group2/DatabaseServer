package transferobjects;

import java.io.Serializable;

public class DidUserBuyJoin implements Serializable {
    private int transactionid;
    private String email;
    private int productid;

    public DidUserBuyJoin(int transactionid, String email, int productid) {
        this.transactionid = transactionid;
        this.email = email;
        this.productid = productid;
    }

    public DidUserBuyJoin() {
    }

    public int getTransactionid() {
        return transactionid;
    }

    public void setTransactionid(int transactionid) {
        this.transactionid = transactionid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }
}
