public class Customer {

    private String name;
    private boolean student;
    private int loyaltyPoints;

    /** Default constructor. */
    public Customer() {
        name = "Unknown";
        student = false;
        loyaltyPoints = 0;
    }

    /** Constructor with name. */
    public Customer(String name) {
        this.name = name;
        student = false;
        loyaltyPoints = 0;
    }

    /** Constructor with name and student status. */
    public Customer(String name, boolean student) {
        this.name = name;
        this.student = student;
        loyaltyPoints = 0;
    }

    /** Adds loyalty points directly. */
    public void addPoints(int points) {
        if (points > 0) {
            loyaltyPoints += points;
        }
    }

    /** Adds one point for every 50 pesos spent. */
    public void addPoints(double amountSpent) {
        if (amountSpent > 0) {
            loyaltyPoints += (int)(amountSpent / 50);
        }
    }

    /** Gets customer name. */
    public String getName() {
        return name;
    }

    /** Sets customer name. */
    public void setName(String name) {
        this.name = name;
    }

    /** Checks if customer is a student. */
    public boolean isStudent() {
        return student;
    }

    /** Sets student status. */
    public void setStudent(boolean student) {
        this.student = student;
    }

    /** Gets loyalty points. */
    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    /** Sets loyalty points. */
    public void setLoyaltyPoints(int points) {
        if (points >= 0) {
            loyaltyPoints = points;
        }
    }
}