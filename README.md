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

## 💡 Ex

