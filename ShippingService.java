import java.util.*;

public class ShippingService {
    public void ship(List<Shippable> items) {
        double totalWeight = 0;
        System.out.println("** Shipment notice **");
        for (Shippable item : items) {
            System.out.println(item.getName() + " " + item.getWeight() + "kg");
            totalWeight += item.getWeight();
        }
        System.out.println("Total package weight: " + totalWeight + "kg");
    }
}