# FawryECommerceChallenge
Java console-based e-commerce system for Fawry Internship Challenge

# E-Commerce System - Fawry Internship Challenge

This Java console-based application simulates a simple e-commerce system designed for the **Fawry Quantum Internship Challenge**. It demonstrates core Object-Oriented Programming (OOP) concepts, user interaction, error handling, and modular design.

---

## ✅ Features

- **Product Management**
  - Create products with `name`, `price`, and `quantity`.
  - Support for **expirable** and **non-expirable** products.
  - Support for **shippable** products (requiring `weight`).
  
- **Shopping Cart**
  - Customers can add products to their cart in specific quantities (limited by stock).
  - Cart enforces rules for:
    - Expired products
    - Out-of-stock items

- **Checkout**
  - Calculates and prints:
    - Order **subtotal**
    - **Shipping fees** (if applicable)
    - **Total amount**
    - Customer’s **remaining balance**
  - Collects shippable items into `ShippingService` using a clean interface design.

- **Error Handling**
  - Displays errors if:
    - Cart is empty
    - Product is expired
    - Customer has insufficient balance

---

## 💡 Example Usage

```text
Enter your name:
Sarah
Enter your balance:
1000

Define your products:
Product name:
Cheese
Price:
100
Quantity:
2
Does this product expire? (yes/no)
yes
Enter expiry date (YYYY-MM-DD):
2025-07-10
Does this product require shipping? (yes/no)
yes
Enter weight in kg:
0.2

Add another product? (yes/no)
no

Available products:
0: Cheese (100.0 EGP, 2 in stock)
Enter product number to add to cart (or -1 to checkout):
0
Enter quantity to add:
2

** Shipment notice **
Cheese 0.2kg
Cheese 0.2kg
Total package weight: 0.4kg

** Checkout receipt **
2x Cheese 200.0
----------------------
Subtotal: 200.0
Shipping: 30.0
Amount: 230.0
Remaining Balance: 770.0

---

## 💡 Ex

