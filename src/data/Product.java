package data;

import tools.Validate;

/**
 *
 * @author User
 */
public class Product {
    private static double PRICE_UPPERBOUND = 10000;
    private static double PRICE_LOWERBOUND = 0;
    private static int QUANTITY_UPPERBOUND = 1000;
    private static int QUANTITY_LOWERBOUND = 0;
    
    static String SEP = ",";
    
    private String ID;
    private String name;
    private double price;
    private int quantity;
    private String status;
    
    public Product() {}

    public Product(String ID, String name, double price, int quantity, String status) {
        setID(ID);
        setName(name);
        setPrice(price);
        setQuantity(quantity);
        setStatus(status);
    }
    
    public Product(String ID, String name, String price, String quantity, String status) {
        setID(ID);
        setName(name);
        setPrice(Double.parseDouble(price));
        setQuantity(Integer.parseInt(quantity));
        setStatus(status);
    }

    public String getID() {
        return ID;
    }

    public final void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public final void setName(String name) {
        this.name = Validate.stringNonEmpty(name) && Validate.name(name) ? name : null;
    }

    public double getPrice() {
        return price;
    }

    public final void setPrice(double price) {
        this.price = Validate.doubleRange(price, PRICE_LOWERBOUND, PRICE_UPPERBOUND, true) ? price : 0;
    }

    public int getQuantity() {
        return quantity;
    }

    public final void setQuantity(int quantity) {
        this.quantity = Validate.intRange(quantity, QUANTITY_LOWERBOUND, QUANTITY_UPPERBOUND, true) ? quantity : 0;
    }

    public String getStatus() {
        return status;
    }

    public final void setStatus(String status) {
        this.status = status;
    }
    
    @Override
    public String toString() {
        return ID + SEP + name + SEP + price + SEP + quantity + SEP + status;
    }
    
    public Product createProduct() {
        Product newProduct = new Product();
    }s
}
