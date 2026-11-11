public class CafeApp {

    /** Starts the cafe ordering system. */
    public static void main(String[] args) {

        // Create customers
        Customer customer1 =
                new Customer("Danny Pabular", true);

        Customer customer2 =
                new Customer("Anna Hijara");

        // Create first order
        Order order1 = new Order("1001", customer1);

        // Create menu items
        Beverage chocolate = new Beverage(
                "Dark Chocolate", 85, "B-01", "L");

        Pastry pandesal = new Pastry(
                "Malunggay pandesal", 65, "P-01", true);

        Meal chicken = new Meal(
                "Lechon manok", 225, "M-01", true, 1);

        // Add items to order
        order1.addItem(chocolate);
        order1.addItem(pandesal);
        order1.addItem(chicken);

        // Try adding fourth item
        Pastry cake = new Pastry(
                "cheese cake", 20, "P-02", false);

        order1.addItem(cake);

        // Test invalid price
        chocolate.setBasePrice(-5);

        // Print first receipt
        order1.printReceipt();

        // Create second order
        Order order2 = new Order("1002", customer2);

        // Default constructor
        Beverage matcha = new Beverage();

        matcha.setName("Hot Chocolate");
        matcha.setItemCode("B-02");
        matcha.setBasePrice(-5);
        matcha.setBasePrice(80);
        matcha.setSize("M");

        // Parameterized constructor
        Meal bistek = new Meal(
                "Bistek", 285, "M-02", false, 0);

        // Add items
        order2.addItem(chocolate);
        order2.addItem(bistek);

        // Print second receipt with voucher
        order2.printReceipt(20);

        System.out.println("[Process Completed]");
    }
}
