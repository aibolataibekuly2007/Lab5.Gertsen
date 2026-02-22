public class Product implements Cloneable {
    private String name;
    private double price;
    private int quantity;
    private String category;

    public Product(String name, double price, int quantity, String category) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
    }

    public Product(Product source) {
        this.name = source.name;
        this.price = source.price;
        this.quantity = source.quantity;
        this.category = source.category;
    }

    @Override
    public Product clone() {
        return new Product(this);
    }

    public double getTotalPrice() {
        return price * quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return String.format("%s [%s] - $%.2f x %d = $%.2f",
                name, category, price, quantity, getTotalPrice());
    }
}