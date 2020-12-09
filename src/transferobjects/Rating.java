package transferobjects;

import java.io.Serializable;

public class Rating implements Serializable {
    private int id;
    private String name;
    private int star;
    private String comment;
    private int productid;



    public Rating(int id, String name, int star, String comment, int productid) {
        this.id = id;
        this.name = name;
        this.star = star;
        this.comment = comment;
        this.productid=productid;
    }
    public Rating(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }
}
