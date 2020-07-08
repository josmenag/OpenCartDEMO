package pojo;

public class ProductProfile {

    private String productName;
    private String id;
    private String usd;
    private String eur;
    private String pnd;

    public ProductProfile(String productName, String id, String usd, String eur, String pnd){
        this.productName = productName;
        this.id = id;
        this.usd = usd;
        this.eur = eur;
        this.pnd = pnd;
    }


    public String getUsd() {
        return usd;
    }

    public String getProductName() {
        return productName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEur() {
        return eur;
    }


    public String getPnd() {
        return pnd;
    }
}
