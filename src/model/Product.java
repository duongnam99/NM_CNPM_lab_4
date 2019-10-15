package model;

public class Product {
    private int productID;
    private String name;
    private int quantity;
    private int price;
    private int categoryID;

    public Product () {}
    public Product(int productID, String name, int quantity, int price, int categoryID) {
        this.productID = productID;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.categoryID = categoryID;
    }

    public int getCategoryID() {
        return categoryID;
    }
    public void setProductID(int productID) {
        this.productID = productID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public int getProductID() {
        return productID;
    }
}
