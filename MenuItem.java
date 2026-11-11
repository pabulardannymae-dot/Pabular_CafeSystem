public abstract class MenuItem {

    protected String name;
    protected double basePrice;
    private String itemCode;

    /** Default constructor. */
    public MenuItem() {
        this.name = "Unnamed Item";
        this.basePrice = 0.0;
        this.itemCode = "N/A";
    }

    /** Parameterized constructor. */
    public MenuItem(String name, double basePrice, String itemCode) {
        this.name = name;
        setBasePrice(basePrice);
        this.itemCode = itemCode;
    }

    /** Computes the final price. */
    public abstract double computePrice();

    /** Returns item description. */
    public String getDescription() {
        return name + " [" + itemCode + "]";
    }

    /** Gets item name. */
    public String getName() {
        return name;
    }

    /** Sets item name. */
    public void setName(String name) {
        this.name = name;
    }

    /** Gets base price. */
    public double getBasePrice() {
        return basePrice;
    }

    /** Sets base price and rejects negative values. */
    public void setBasePrice(double price) {
        if (price < 0) {
            System.out.println("Error: base price cannot be negative.");
        } else {
            basePrice = price;
        }
    }

    /** Gets item code. */
    public String getItemCode() {
        return itemCode;
    }

    /** Sets item code. */
    public void setItemCode(String code) {
        itemCode = code;
    }
}