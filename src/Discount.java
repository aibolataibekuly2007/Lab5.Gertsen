public class Discount implements Cloneable {
    private String code;
    private double percentage;
    private String description;
    private boolean isActive;

    public Discount(String code, double percentage, String description) {
        this.code = code;
        this.percentage = percentage;
        this.description = description;
        this.isActive = true;
    }

    public Discount(Discount source) {
        this.code = source.code;
        this.percentage = source.percentage;
        this.description = source.description;
        this.isActive = source.isActive;
    }

    @Override
    public Discount clone() {
        return new Discount(this);
    }

    public double applyDiscount(double amount) {
        return amount * (1 - percentage / 100);
    }

    public String getCode() {
        return code;
    }

    public double getPercentage() {
        return percentage;
    }

    public String getDescription() {
        return description;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return String.format("Discount '%s': %.1f%% off - %s %s",
                code, percentage, description,
                isActive ? "[Active]" : "[Inactive]");
    }
}