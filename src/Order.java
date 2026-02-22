import java.util.ArrayList;
import java.util.List;

public class Order implements Cloneable {
    private static int nextId = 1000;

    private int orderId;
    private List<Product> products;
    private double deliveryCost;
    private Discount discount;
    private String paymentMethod;
    private String customerName;
    private String shippingAddress;

    public Order(String customerName, String shippingAddress) {
        this.orderId = nextId++;
        this.products = new ArrayList<>();
        this.customerName = customerName;
        this.shippingAddress = shippingAddress;
        this.deliveryCost = 5.99;
    }

    public Order(Order source) {
        this.orderId = nextId++;
        this.products = new ArrayList<>();

        for (Product product : source.products) {
            this.products.add(product.clone());
        }

        this.deliveryCost = source.deliveryCost;

        if (source.discount != null) {
            this.discount = source.discount.clone();
        }

        this.paymentMethod = source.paymentMethod;
        this.customerName = source.customerName;
        this.shippingAddress = source.shippingAddress;
    }

    @Override
    public Order clone() {
        return new Order(this);
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void addProduct(String name, double price, int quantity, String category) {
        products.add(new Product(name, price, quantity, category));
    }

    public double calculateSubtotal() {
        double subtotal = 0;
        for (Product product : products) {
            subtotal += product.getTotalPrice();
        }
        return subtotal;
    }

    public double calculateTotal() {
        double total = calculateSubtotal() + deliveryCost;

        if (discount != null && discount.isActive()) {
            total = discount.applyDiscount(total);
        }

        return total;
    }

    public void applyDiscount(Discount discount) {
        this.discount = discount;
    }

    public void setDeliveryCost(double deliveryCost) {
        this.deliveryCost = deliveryCost;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void displayOrder() {
        System.out.println("\n=== ORDER #" + orderId + " ===");
        System.out.println("Customer: " + customerName);
        System.out.println("Shipping: " + shippingAddress);
        System.out.println("Payment: " + (paymentMethod != null ? paymentMethod : "Not selected"));

        System.out.println("\nProducts:");
        for (Product product : products) {
            System.out.println("  " + product);
        }

        System.out.println("\nSubtotal: $" + String.format("%.2f", calculateSubtotal()));
        System.out.println("Delivery: $" + String.format("%.2f", deliveryCost));

        if (discount != null && discount.isActive()) {
            System.out.println("Discount: " + discount.getPercentage() + "% off");
            System.out.println("Discount saved: $" + String.format("%.2f",
                    (calculateSubtotal() + deliveryCost) * discount.getPercentage() / 100));
        }

        System.out.println("TOTAL: $" + String.format("%.2f", calculateTotal()));
    }

    public int getOrderId() {
        return orderId;
    }

    public List<Product> getProducts() {
        return products;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }
}