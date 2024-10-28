package lambdaproject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static javapractice.miniproject_lambda.AdvanceInventoryManagement.*;

public class AdvanceRunner {
    public static void main(String[] args) {
        List<InventoryItem> inventory = new ArrayList<>(Arrays.asList(
                new InventoryItem("apple", 10, 0.50),
                new InventoryItem("banana", 5, 0.20),
                new InventoryItem("orange", 8, 0.30),
                new InventoryItem("pear", 15, 0.40),
                new InventoryItem("grape", 12, 0.25)
        ));

        /*
        we use the new InventoryItem constructor inside the Arrays.asList() method to create and initialize
        each InventoryItem object. This ensures that each object in the list is a fully constructed instance
        of the InventoryItem class.
        - InventoryItem is a class with a constructor that initializes its fields (item, quantity, price).
        - Using new InventoryItem(...) calls this constructor and creates a new instance of the InventoryItem
          class with the provided values.

         */

        displayInventory(inventory);

        System.out.println("\nSorted by Name then Price:");
        displayInventory(sortByMultipleKeys(inventory, "item", "price"));

        System.out.println("\nFiltered by Price Range (0.20 - 0.40):");
        displayInventory(filterByPredicate(inventory, item -> item.getPrice() >= 0.20 && item.getPrice() <= 0.40));

        System.out.println("\nTotal Inventory Value: " + totalInventoryValue(inventory));

        System.out.println("\nAdding new item 'mango':");
        addItem(inventory, new InventoryItem("mango", 7, 1.00));
        displayInventory(inventory);

        System.out.println("\nRemoving item 'apple':");
        removeItem(inventory, "apple");
        displayInventory(inventory);

        System.out.println("\nUpdating item 'banana' quantity to 20:");
        updateItemQuantity(inventory, "banana", 20);
        displayInventory(inventory);

        System.out.println("\nSaving inventory to file:");
        saveInventoryToFile(inventory, "inventory.txt");

        System.out.println("\nLoading inventory from file:");
        List<InventoryItem> loadedInventory = loadInventoryFromFile("inventory.txt");
        displayInventory(loadedInventory);
    }
}
