Test Plan: Incredible Connection E-commerce Automation
1. Introduction

This document outlines the automated testing approach for the Incredible Connection e-commerce website.
The purpose of this test plan is to validate core online shopping functionality, ensuring that users can search for products, add items to the cart, enter checkout information, and review order details prior to payment.

Testing focuses on functional accuracy, form validation, and user interaction reliability across supported browsers and network conditions.

2. Scope

- Product search and product listing navigation
- Product selection and add-to-cart functionality
- Cart review and item quantity validation
- Checkout information entry and validation
- Order summary review screen
- Keyboard navigation using the Enter key

Out of Scope

- Payment processing
- Full login flow
- Order payment confirmation and reference number generation

3. Test Objectives

The testing aims to verify that:
- Users can successfully search for products using valid keywords or categories
- Users Verify that the product they searched for matches
  with product in the cart
- Product details pages display correct information
- Items can be added to and removed from the cart
- Cart totals update correctly based on quantity changes
- Users can enter and save checkout information

4.  Test Tools

- Selenium WebDriver
- Java
- TestNG
- Cucumber (BDD)
- Maven (build and dependency management)
- Git (version control)
- Extent Reports / TestNG Reports (test execution reporting)
- Log4j (logging)
- Jenkins CI pipeline configuration and automated test execution
