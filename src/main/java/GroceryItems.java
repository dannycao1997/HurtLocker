
// https://www.w3schools.com/java/java_regex.asp

public class GroceryItems {

    private String name;
    private Double price;
    private String type;
    private String expiration;

    public GroceryItems(String name, Double price, String type, String expiration) {
        this.name = name;
        this.price = price;
        this.type = type;
        this.expiration = expiration;
    }

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice(){
        return price;
    }

    public void setPrice(Double price){
        this.price = price;
    }

    public String getType(){
        return type;
    }

    public void setType(String type){
        this.type = type;
    }

    public String getExpiration(){
        return expiration;
    }

    public void setExpiration(String expiration){
        this.expiration = expiration;
    }

}