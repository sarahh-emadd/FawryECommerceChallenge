import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        Customer customer;

        try (Scanner scanner = new Scanner(System.in)) {

            System.out.println("Enter your name:");
            String customerName = scanner.nextLine();
            System.out.println("Enter your balance:");
            double balance = scanner.nextDouble();
            scanner.nextLine(); // Consume newline

            customer = new Customer(customerName, balance);

            System.out.println("Define your products:");
            while (true) {
                System.out.println("Product name:");
                String name = scanner.nextLine();

                System.out.println("Price:");
                double price = scanner.nextDouble();

                System.out.println("Quantity:");
                int quantity = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Does this product expire? (yes/no)");
                String expires = scanner.nextLine();

                System.out.println("Does this product require shipping? (yes/no)");
                String shippable = scanner.nextLine();

                Product product;

                if (expires.equalsIgnoreCase("yes")) {
                    System.out.println("Enter expiry date (YYYY-MM-DD):");
                    String dateInput = scanner.nextLine();
                    LocalDate expiryDate = LocalDate.parse(dateInput);

                    if (shippable.equalsIgnoreCase("yes")) {
                        System.out.println("Enter weight in kg:");
                        double weight = scanner.nextDouble();
                        scanner.nextLine();
                        product = new Cheese(name, price, quantity, expiryDate, weight);
                    } else {
                        product = new Biscuits(name, price, quantity, expiryDate);
                    }

                } else {
                    if (shippable.equalsIgnoreCase("yes")) {
                        System.out.println("Enter weight in kg:");
                        double weight = scanner.nextDouble();
                        scanner.nextLine();
                        product = new TV(name, price, quantity, weight);
                    } else {
                        product = new MobileScratchCard(name, price, quantity);
                    }
                }

                products.add(product);

                System.out.println("Add another product? (yes/no)");
                String again = scanner.nextLine();
                if (again.equalsIgnoreCase("no")) break;
            }

            // Add to cart
            while (true) {
                System.out.println("Available products:");
                for (int i = 0; i < products.size(); i++) {
                    Product p = products.get(i);
                    System.out.println(i + ": " + p.getName() + " (" + p.getPrice() + " EGP, " + p.getQuantity() + " in stock)");
                }

                System.out.println("Enter product number to add to cart (or -1 to checkout):");
                int choice = scanner.nextInt();
                if (choice == -1) break;

                if (choice < 0 || choice >= products.size()) {
                    System.out.println("Invalid choice.");
                    continue;
                }

                Product selectedProduct = products.get(choice);
                System.out.println("Enter quantity to add:");
                int qty = scanner.nextInt();
                scanner.nextLine();

                try {
                    customer.getCart().add(selectedProduct, qty);
                    System.out.println("Added to cart.");
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }

            // Checkout
            try {
                CheckoutService.checkout(customer);
            } catch (Exception e) {
                System.out.println("Checkout error: " + e.getMessage());
            }

        }
    }
}
