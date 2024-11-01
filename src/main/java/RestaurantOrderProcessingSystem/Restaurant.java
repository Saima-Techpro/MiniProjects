package RestaurantOrderProcessingSystem;

import java.util.*;

public class Restaurant {
    private List<Order> orders;

    public Restaurant() {
        this.orders = new ArrayList<>();
    }

    // Add a new order with input from the user
    public void addOrder() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter customer name: ");
        String customerName = scanner.nextLine();

        // Menu items with prices
        Map<String, Double> menu = Map.of(
                "Kebab", 50.0,
                "Baklava", 20.0,
                "Ayran", 5.0,
                "Lahmacun", 30.0,
                "Sütlaç", 15.0,
                "Çay", 3.0
        );

        // Display menu
        System.out.println("\n--- Menu ---");
        for (var entry : menu.entrySet()) {
            System.out.printf("%-20s ₺%.2f\n", entry.getKey(), entry.getValue());
        }

        // Select items
        Map<String, Double> itemsOrdered = new HashMap<>();
        double subtotal = 0;
        while (true) {
            System.out.print("Enter item name to order (or type 'done' to finish): ");
            String itemName = scanner.nextLine();
            if (itemName.equalsIgnoreCase("done")) break;
            if (menu.containsKey(itemName)) {
                double price = menu.get(itemName);
                itemsOrdered.put(itemName, price);
                subtotal += price;
                System.out.println(itemName + " added to order.");
            } else {
                System.out.println("Item not on the menu. Please try again.");
            }
        }

        // Calculate discount
        double discount = (subtotal >= 100) ? 0.10 * subtotal : 0;
        double totalCost = subtotal - discount;

        // Add order
        Order order = new Order(customerName, itemsOrdered, totalCost);
        orders.add(order);
        System.out.println("Order added for " + customerName + "!\n");
    }

    // Display all orders
    public void displayOrders() {
        System.out.println("\n--- Turkish Restaurant Orders ---");
        if (orders.isEmpty()) {
            System.out.println("No orders have been placed.");
        } else {
            for (Order order : orders) {
                System.out.println(order);
                System.out.println();
            }
        }
    }

    // Calculate total revenue without using lambda
    public double calculateTotalRevenue() {
        double totalRevenue = 0;
        for (Order order : orders) {
            totalRevenue += order.totalCost();
        }
        return totalRevenue;
    }
}