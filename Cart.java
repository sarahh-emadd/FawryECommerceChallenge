import java.util.*;

public class Cart {
    List<CartItem> items = new ArrayList<>();

    public void add(Product product, int quantity) {
        if (quantity > product.getQuantity()) {
            throw new IllegalArgumentException("Not enough stock for: " + product.getName());
        }
        if (product.isExpired()) {
            throw new IllegalArgumentException("Product expired: " + product.getName());
        }
        items.add(new CartItem(product, quantity));
    }

    public boolean isEmpty() { return items.isEmpty(); }

    public List<CartItem> getItems() { return items; }
}