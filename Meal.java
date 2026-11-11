public class Meal extends MenuItem {

    private boolean upsized;
    private int extraSides;

    /** Default constructor. */
    public Meal() {
        super();
        upsized = false;
        extraSides = 0;
    }

    /** Parameterized constructor. */
    public Meal(String name, double basePrice,
                String itemCode, boolean upsized,
                int extraSides) {
        super(name, basePrice, itemCode);
        this.upsized = upsized;
        setExtraSides(extraSides);
    }

    /** Computes meal price. */
    @Override
    public double computePrice() {
        double price = basePrice;

        if (upsized) {
            price += 20;
        }

        price += 12 * extraSides;

        return price;
    }

    /** Returns meal description. */
    @Override
    public String getDescription() {
        String status = upsized ? "Upsized" : "Regular";
        return super.getDescription() + " " + status
                + ", " + extraSides + " side(s)";
    }

    /** Gets extra sides. */
    public int getExtraSides() {
        return extraSides;
    }

    /** Sets extra sides. */
    public void setExtraSides(int sides) {
        if (sides >= 0) {
            extraSides = sides;
        }
    }

    /** Gets upsized status. */
    public boolean isUpsized() {
        return upsized;
    }

    /** Sets upsized status. */
    public void setUpsized(boolean upsized) {
        this.upsized = upsized;
    }
}