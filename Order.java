public class Order {

    private Customer customer;
    private MenuItem item1, item2, item3;
    private int itemCount;
    private String orderId;

    /** Creates a new order. */
    public Order(String orderId, Customer customer) {
        this.orderId = orderId;
        this.customer = customer;
        itemCount = 0;
    }

    /** Adds an item if a slot is available. */
    public boolean addItem(MenuItem item) {
        if (itemCount >= 3) {
            System.out.println("Order is full. Cannot add "
                    + item.getName() + " [" + item.getItemCode() + "].");
            return false;
        }

        if (item1 == null) {
            item1 = item;
        } else if (item2 == null) {
            item2 = item;
        } else {
            item3 = item;
        }

        itemCount++;
        return true;
    }

    /** Computes subtotal. */
    public double computeSubtotal() {
        double total = 0;

        if (item1 != null) total += item1.computePrice();
        if (item2 != null) total += item2.computePrice();
        if (item3 != null) total += item3.computePrice();

        return total;
    }

    /** Computes total with student discount. */
    public double computeTotal() {
        double total = computeSubtotal();

        if (customer.isStudent()) {
            total -= total * 0.10;
        }

        return total;
    }

    /** Computes total after voucher discount. */
    public double computeTotal(double voucher) {
        double total = computeTotal();

        if (voucher > 0) {
            total -= voucher;
        }

        if (total < 0) {
            total = 0;
        }

        return total;
    }

    /** Prints receipt and updates loyalty points. */
    public void printReceipt() {

        System.out.println("\nOrder #" + orderId + " - "
                + customer.getName()
                + (customer.isStudent() ? " (Student)" : ""));

        if (item1 != null) printItem(item1);
        if (item2 != null) printItem(item2);
        if (item3 != null) printItem(item3);

        double subtotal = computeSubtotal();
        double total = computeTotal();

        System.out.printf("Subtotal: %.2f%n", subtotal);

        if (customer.isStudent()) {
            System.out.printf("Student discount (10%%): -%.2f%n",
                    subtotal * 0.10);
        }

        System.out.printf("TOTAL: %.2f%n", total);

        customer.addPoints(total);

        System.out.println("Loyalty points: "
                + customer.getLoyaltyPoints());
    }

    /** Prints one item and its price. */
    private void printItem(MenuItem item) {
        System.out.printf("%s ........ %.2f%n",
                item.getDescription(), item.computePrice());
    }

    /** Prints receipt with voucher. */
    public void printReceipt(double voucher) {

        System.out.println("\nOrder #" + orderId + " - "
                + customer.getName()
                + (customer.isStudent() ? " (Student)" : ""));

        if (item1 != null) printItem(item1);
        if (item2 != null) printItem(item2);
        if (item3 != null) printItem(item3);

        double subtotal = computeSubtotal();
        double total = computeTotal();

        System.out.printf("Subtotal: %.2f%n", subtotal);

        if (customer.isStudent()) {
            System.out.printf("Student discount (10%%): -%.2f%n",
                    subtotal * 0.10);
        }

        System.out.printf("Voucher: -%.2f%n", voucher);

        total = computeTotal(voucher);

        System.out.printf("TOTAL: %.2f%n", total);

        customer.addPoints(total);

        System.out.println("Loyalty points: "
                + customer.getLoyaltyPoints());
    }
}