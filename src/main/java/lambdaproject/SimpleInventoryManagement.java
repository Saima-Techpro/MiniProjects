package lambdaproject;

import java.util.List;
import java.util.stream.Collectors;

public class SimpleInventoryManagement {

    // Create a method to display inventory
    public static void displayInventory(List<InventoryItem> inventory) {
        inventory.forEach(System.out::println);
    }

    // Create a method that returns an inventory sorted by the given key

    public static List<InventoryItem> sortByKey(List<InventoryItem> inventory, String key) {
        return inventory.stream().sorted((item1, item2) -> {
            switch (key) {
                case "item":
                    return item1.getItem().compareTo(item2.getItem());
                case "quantity":
                    return Integer.compare(item1.getQuantity(), item2.getQuantity());
                case "price":
                    return Double.compare(item1.getPrice(), item2.getPrice());
                default:
                    throw new IllegalArgumentException("Invalid key: " + key);
            }
        }).collect(Collectors.toList());
    }

    // Create a method that returns list of items which have not reached minimum quantity
    public static List<InventoryItem> filterByMinQuantity(List<InventoryItem> inventory, int minQuantity) {
        return inventory.stream()
                .filter(item -> item.getQuantity() >= minQuantity)
                .collect(Collectors.toList());
    }

    // Create a method that returns total value of the inventory items
    public static double totalInventoryValue(List<InventoryItem> inventory) {
        return inventory.stream().mapToDouble(item -> item.getQuantity() * item.getPrice())
                .sum();
    }


    public static void addItem(List<InventoryItem> inventory, InventoryItem newItem) {
        inventory.add(newItem);
    }

    public static void removeItem(List<InventoryItem> inventory, String itemName) {
        inventory.removeIf(item -> item.getItem().equalsIgnoreCase(itemName));
    }

    public static void updateItemQuantity(List<InventoryItem> inventory, String itemName, int newQuantity) {
        inventory.stream().filter(item -> item.getItem().equalsIgnoreCase(itemName)).findFirst().ifPresent(item -> item.setQuantity(newQuantity));
    }
}
