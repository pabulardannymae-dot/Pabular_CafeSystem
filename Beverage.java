public class Beverage extends MenuItem {

    private String size;

    /** Default constructor. */
    public Beverage() {
        super();
        size = "S";
    }

    /** Parameterized constructor. */
    public Beverage(String name, double basePrice,
                    String itemCode, String size) {
        super(name, basePrice, itemCode);
        setSize(size);
    }

    /** Computes beverage price based on size. */
    @Override
    public double computePrice() {
        if (size.equals("L")) {
            return basePrice + 25;
        } else if (size.equals("M")) {
            return basePrice + 15;
        } else {
            return basePrice;
        }
    }

    /** Returns beverage description. */
    @Override
    public String getDescription() {
        return super.getDescription() + " Size: " + size;
    }

    /** Gets size. */
    public String getSize() {
        return size;
    }

    /** Sets valid beverage size. */
    public void setSize(String size) {
        if (size.equals("S") || size.equals("M")
                || size.equals("L")) {
            this.size = size;
        }
    }
}