// Customer Class Implementation

class Customer {
    // Instance variables
    String name;
    int points;

    // Static variable shared among all customers
    static int totalCustomers = 0;

    // Default constructor
    public Customer() {
        this.name = "Anonymous";
        this.points = 0;
        totalCustomers++;
    }

    // Parameterized constructor (name only)
    public Customer(String name) {
        this.name = name;
        this.points = 0;
        totalCustomers++;
    }

    // Parameterized constructor (name and points)
    public Customer(String name, int points) {
        this.name = name;
        this.points = points;
        totalCustomers++;
    }

    // Add points to the customer
    public void addPoints(int amount) {
        this.points += amount;
        System.out.println(this.name + " earned " + amount + " points. Total: " + this.points);
    }

    // Redeem reward if points >= 100
    public void redeemReward() {
        if (this.points >= 100) {
            int rewards = this.points / 100; // number of rewards
            this.points %= 100; // remove redeemed points
            System.out.println(this.name + " redeemed " + rewards + " free drink(s)!");
        } else {
            System.out.println(this.name + " has insufficient points to redeem a reward.");
        }
    }

    // Display customer information
    public void displayCustomerInfo() {
        System.out.println("Name: " + this.name + " | Points: " + this.points);
    }

    // Static method to display total customers
    public static void displayTotalCustomers() {
        System.out.println("Total Registered Customers: " + totalCustomers);
    }

    // Static method to show how many times a customer can redeem rewards
    public static void getAllowedRewardsRedemption(Customer c) {
        int rewards = c.points / 100;
        System.out.println(c.name + " can redeem " + rewards + " free drink(s).");
    }
}
