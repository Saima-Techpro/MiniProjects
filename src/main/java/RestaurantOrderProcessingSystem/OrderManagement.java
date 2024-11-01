package RestaurantOrderProcessingSystem;

import java.util.Scanner;

public class OrderManagement {
    public static void main(String[] args) {

        Restaurant restaurant = new Restaurant();
        Scanner scanner = new Scanner(System.in);

        // Taking multiple orders
        String moreOrders;
        do {
            restaurant.addOrder();
            System.out.print("Would you like to add another order? (yes/no): ");
            moreOrders = scanner.nextLine();
        } while (moreOrders.equalsIgnoreCase("yes"));

        // Display all orders
        restaurant.displayOrders();

        // Calculate and display total revenue
        System.out.printf("Total revenue: ₺%.2f\n", restaurant.calculateTotalRevenue());
    }

}
