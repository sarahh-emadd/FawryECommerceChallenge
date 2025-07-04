import java.util.*;

public class CheckoutService {
    private static final double SHIPPING_FEE_PER_ITEM = 10.0;

    public static void checkout(Customer customer) {
        Cart cart = customer.getCart();

        if (cart.isEmpty()) throw new IllegalStateException("Cart is empty");

        double subtotal = 0;
        double shippingFees = 0;
        List<Shippable> shippingItems = new ArrayList<>();

        for (CartItem item : cart.getItems()) {
            Product p = item.getProduct();
            int qty = item.getQuantity();

            if (qty > p.getQuantity()) throw new IllegalArgumentException(p.getName() + " is out of stock.");
            if (p.isExpired()) throw new IllegalArgumentException(p.getName() + " is expired.");

            subtotal += p.getPrice() * qty;

            if (p instanceof Shippable) {
                for (int i = 0; i < qty; i++) {
                    shippingItems.add((Shippable) p);
                    shippingFees += SHIPPING_FEE_PER_ITEM;
                }
            }

            p.reduceQuantity(qty);
        }

        double total = subtotal + shippingFees;
        if (total > customer.getBalance())
            throw new IllegalArgumentException("Customer has insufficient balance.");

        customer.deductBalance(total);

        if (!shippingItems.isEmpty()) {
            new ShippingService().ship(shippingItems);
        }

        System.out.println("** Checkout receipt **");
        for (CartItem item : cart.getItems()) {
            System.out.println(item.getQuantity() + "x " + item.getProduct().getName() +
                               " " + (item.getProduct().getPrice() * item.getQuantity()));
        }
        System.out.println("----------------------");
        System.out.println("Subtotal: " + subtotal);
        System.out.println("Shipping: " + shippingFees);
        System.out.println("Amount: " + total);
        System.out.println("Remaining Balance: " + customer.getBalance());
    }
}