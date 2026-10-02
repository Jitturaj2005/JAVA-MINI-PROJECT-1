import java.util.Scanner;

public class FoodOrderingSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Food menu
        String[] foodItems = {
            "Pizza",
            "Burger",
            "Pasta",
            "Sandwich",
            "French Fries",
            "Cold Drink"
        };

        double[] prices = {
            250.00,
            120.00,
            180.00,
            100.00,
            80.00,
            60.00
        };

        int[] quantities = new int[foodItems.length];

        int choice;

        System.out.println("====================================");
        System.out.println("       WELCOME TO FOOD CART");
        System.out.println("====================================");

        do {
            System.out.println("\n----------- FOOD MENU -----------");

            for (int i = 0; i < foodItems.length; i++) {
                System.out.println(
                    (i + 1) + ". " + foodItems[i] + " - ₹" + prices[i]
                );
            }

            System.out.println("7. View Cart");
            System.out.println("8. Place Order");
            System.out.println("9. Exit");

            System.out.print("\nEnter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:

                    System.out.print(
                        "Enter quantity of " + foodItems[choice - 1] + ": "
                    );

                    int quantity = sc.nextInt();

                    if (quantity > 0) {
                        quantities[choice - 1] += quantity;

                        System.out.println(
                            quantity + " " + foodItems[choice - 1]
                            + "(s) added to cart."
                        );
                    } else {
                        System.out.println("Invalid quantity!");
                    }

                    break;

                case 7:

                    System.out.println("\n----------- YOUR CART -----------");

                    double cartTotal = 0;
                    boolean empty = true;

                    for (int i = 0; i < foodItems.length; i++) {

                        if (quantities[i] > 0) {

                            double itemTotal =
                                quantities[i] * prices[i];

                            System.out.println(
                                foodItems[i]
                                + " x "
                                + quantities[i]
                                + " = ₹"
                                + itemTotal
                            );

                            cartTotal += itemTotal;
                            empty = false;
                        }
                    }

                    if (empty) {
                        System.out.println("Your cart is empty.");
                    } else {
                        System.out.println("-------------------------------");
                        System.out.println("Cart Total: ₹" + cartTotal);
                    }

                    break;

                case 8:

                    double total = 0;
                    boolean hasOrder = false;

                    for (int i = 0; i < foodItems.length; i++) {

                        if (quantities[i] > 0) {
                            total += quantities[i] * prices[i];
                            hasOrder = true;
                        }
                    }

                    if (!hasOrder) {
                        System.out.println("\nYour cart is empty!");
                        break;
                    }

                    System.out.println("\n========== BILL ==========");

                    for (int i = 0; i < foodItems.length; i++) {

                        if (quantities[i] > 0) {

                            double itemTotal =
                                quantities[i] * prices[i];

                            System.out.println(
                                foodItems[i]
                                + " x "
                                + quantities[i]
                                + " = ₹"
                                + itemTotal
                            );
                        }
                    }

                    System.out.println("--------------------------");
                    System.out.println("Total Amount: ₹" + total);

                    System.out.println("\nOrder placed successfully!");
                    System.out.println("Thank you for ordering!");

                    // Clear cart after placing order
                    for (int i = 0; i < quantities.length; i++) {
                        quantities[i] = 0;
                    }

                    break;

                case 9:
                    System.out.println(
                        "\nThank you for using Food Ordering System!"
                    );
                    break;

                default:
                    System.out.println(
                        "Invalid choice! Please select 1-9."
                    );
            }

        } while (choice != 9);

        sc.close();
    }
} 
