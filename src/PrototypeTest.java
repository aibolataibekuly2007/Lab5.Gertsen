public class PrototypeTest {
    public static void main(String[] args) {
        System.out.println("=== Prototype Pattern Test ===");

        Order originalOrder = new Order("John Doe", "123 Main St, City");

        originalOrder.addProduct("Laptop", 1200.00, 1, "Electronics");
        originalOrder.addProduct("Mouse", 25.00, 2, "Accessories");
        originalOrder.addProduct("USB Cable", 10.00, 3, "Accessories");

        originalOrder.setDeliveryCost(7.99);
        originalOrder.setPaymentMethod("Credit Card");

        Discount discount = new Discount("SAVE10", 10.0, "Spring Sale");
        originalOrder.applyDiscount(discount);

        System.out.println("\n=== ORIGINAL ORDER ===");
        originalOrder.displayOrder();

        Order clonedOrder = originalOrder.clone();
        System.out.println("\n=== CLONED ORDER (Identical) ===");
        clonedOrder.displayOrder();

        clonedOrder.setCustomerName("Jane Smith");
        clonedOrder.setShippingAddress("456 Oak Ave, Town");
        clonedOrder.setPaymentMethod("PayPal");

        clonedOrder.getProducts().get(0).setQuantity(2);
        clonedOrder.getProducts().get(1).setPrice(30.00);

        Discount newDiscount = new Discount("SUMMER20", 20.0, "Summer Special");
        clonedOrder.applyDiscount(newDiscount);

        System.out.println("\n=== MODIFIED CLONED ORDER ===");
        clonedOrder.displayOrder();

        System.out.println("\n=== ORIGINAL ORDER (Unchanged) ===");
        originalOrder.displayOrder();

        System.out.println("\n=== Deep Clone Verification ===");
        System.out.println("Original order ID: " + originalOrder.getOrderId());
        System.out.println("Cloned order ID: " + clonedOrder.getOrderId());
        System.out.println("Original product quantities: " +
                originalOrder.getProducts().get(0).getQuantity() + ", " +
                originalOrder.getProducts().get(1).getQuantity());
        System.out.println("Cloned product quantities: " +
                clonedOrder.getProducts().get(0).getQuantity() + ", " +
                clonedOrder.getProducts().get(1).getQuantity());
    }
}