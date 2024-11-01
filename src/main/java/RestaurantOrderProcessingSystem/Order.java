package RestaurantOrderProcessingSystem;

import java.util.Map;

public record Order(String customerName, Map<String, Double> items, double totalCost) {


    // compact constructor Unique to Records in Java
    public Order {
        if (totalCost < 0) {
            throw new IllegalArgumentException("Total cost cannot be negative.");
        }
    }

    @Override
    public String toString() {
        StringBuilder receipt = new StringBuilder("Order for " + customerName + ":\n"); // A StringBuilder is used to construct the receipt in a memory-efficient way, allowing us to build the string line by line.
        for (var entry : items.entrySet()) {
            receipt.append(String.format("%-20s ₺%.2f\n", entry.getKey(), entry.getValue()));
        }
        receipt.append(String.format("Total Cost (after discount if any): ₺%.2f", totalCost));
        return receipt.toString();


        /*
        In Java, the var keyword is used for local variable type inference.
        This means that the compiler can automatically infer the type of a variable based on the
        type of its initializer, saving you from specifying it explicitly. var was introduced in Java 10
        and can only be used for local variables within methods, loops, and lambda expressions—not for
        instance variables, method parameters, or return types.

Understanding items.entrySet()
items: Here, items is a Map<String, Double>, where each entry represents a dish name (a String) and its price (a Double).
items.entrySet(): This returns a Set<Map.Entry<String, Double>>, where each Map.Entry contains a key-value pair from the map.
Since items.entrySet() returns a set of Map.Entry<String, Double>, the compiler infers that each entry is
of type Map.Entry<String, Double>. So, the var keyword is equivalent to writing:

for (Map.Entry<String, Double> entry : items.entrySet()) {
    // ...
}

Using var makes the code shorter and potentially more readable, especially in cases where the type is lengthy or complex.
         */


        /*

In String.format(), the %-20s format specifier is used to print a left-aligned string within a field
that’s 20 characters wide. Let’s break it down:

Detailed Breakdown of %-20s:
%: Starts the format specifier.
-: Left-aligns the text within the field. By default, text is right-aligned, so the - ensures it’s aligned to the left.
20: Specifies the field width, meaning a minimum of 20 characters will be reserved for the text.
s: Indicates that the value to be formatted is a String.
Example
Suppose we have the following code snippet:

String itemName = "Kebab";
System.out.printf("%-20s ₺%.2f\n", itemName, 50.00);
Output:

Kebab               ₺50.00
Here, "Kebab" takes up 5 characters, so 15 additional spaces are added after "Kebab" to reach the
total width of 20 characters. This ensures that any other items, regardless of length, will also take
up 20 characters, aligning all item names into a neat column.

Without - (Default Right-Alignment)
If you used %20s (without the -), the text would be right-aligned within the 20-character field:

System.out.printf("%20s ₺%.2f\n", itemName, 50.00);
Output:

             Kebab ₺50.00
This right-aligned formatting is typically less readable in a list, especially when printing columns of data.
Using %-20s makes for a consistent, organized appearance, especially for receipts or tables with
varying item lengths.
         */
    }
}