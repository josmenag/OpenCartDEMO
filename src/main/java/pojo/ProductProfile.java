package pojo;

public class ProductProfile {

    private String productName;
    private String id;
    private String usd;
    private String eur;
    private String pnd;

    public ProductProfile(String productName, String id, String usd, String eur, String pnd){
        this.setProductName(productName);
        this.setId(id);
        this.setUsd(usd);
        this.setEur(eur);
        this.setPnd(pnd);
    }


    public String getUsd() {
        return usd;
    }

    public void setUsd(String usd) {
        this.usd = usd;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
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

    public void setEur(String eur) {
        this.eur = eur;
    }

    public String getPnd() {
        return pnd;
    }

    public void setPnd(String pnd) {
        this.pnd = pnd;
    }
}
