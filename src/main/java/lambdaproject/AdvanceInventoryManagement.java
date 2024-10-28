package lambdaproject;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class AdvanceInventoryManagement {

    // Create a method to display inventory
    public static void displayInventory(List<InventoryItem> inventory) {
        inventory.forEach(System.out::println);
    }



    // Create a method to sort the inventory by key
    public static List<InventoryItem> sortBySingleKey(List<InventoryItem> inventory, String key) {
        return inventory.stream().sorted((item1, item2) -> compareByKey(item1, item2, key)).collect(Collectors.toList());
    }


    public static List<InventoryItem> sortByMultipleKeys(List<InventoryItem> inventory, String primaryKey, String secondaryKey) {
        return inventory.stream().sorted((item1, item2) -> {
            int primaryComparison = compareByKey(item1, item2, primaryKey);
            if (primaryComparison != 0) {
                return primaryComparison;
            }
            return compareByKey(item1, item2, secondaryKey);
        }).collect(Collectors.toList());
    }


    // Create a method that allows to create
    private static int compareByKey(InventoryItem item1, InventoryItem item2, String key) {
        switch (key) {
            case "item":
                return item1.getItem().compareTo(item2.getItem());
            case "quantity":
                return Integer.compare(item1.getQuantity(), item2.getQuantity());
            case "price":
                return Double.compare(item1.getPrice(), item2.getPrice());
            default:
                throw new IllegalArgumentException("Invalid sort key: " + key);
        }
    }

    public static List<InventoryItem> filterByPredicate(List<InventoryItem> inventory, Predicate<InventoryItem> predicate) {
        return inventory.stream().filter(predicate).collect(Collectors.toList());
    }

    public static double totalInventoryValue(List<InventoryItem> inventory) {
        return inventory.stream().mapToDouble(item -> item.getQuantity() * item.getPrice()).sum();
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

    public static void saveInventoryToFile(List<InventoryItem> inventory, String fileName) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            inventory.forEach(writer::println);
        } catch (IOException e) {
            System.err.println("Error saving inventory to file: " + e.getMessage());
        }
    }

    public static List<InventoryItem> loadInventoryFromFile(String fileName) {
        List<InventoryItem> inventory = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(", ");
                if (parts.length == 3) {
                    try {
                        String item = parts[0].split("=")[1].replace("'", "");
                        int quantity = Integer.parseInt(parts[1].split("=")[1]);
                        double price = Double.parseDouble(parts[2].split("=")[1]);
                        inventory.add(new InventoryItem(item, quantity, price));
                    } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
                        System.err.println("Error parsing line: " + line);
                    }
                } else {
                    System.err.println("Invalid line format: " + line);
                }
            }
        } catch (IOException e) {
            System.err.println("Error loading inventory from file: " + e.getMessage());
        }
        return inventory;
    }
}
