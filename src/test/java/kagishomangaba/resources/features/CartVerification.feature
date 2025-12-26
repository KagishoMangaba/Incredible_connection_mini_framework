Feature: Verify product added to cart matches selected product
  As a user
  I want to ensure the product I add is the same product displayed in the cart
  So that I can confidently proceed to checkout

  Background:
    Given the user is on the Incredible Connection landing page

  Scenario Outline: Add product to cart and verify product details
    When the user searches for "Apple iPhone 17 256GB Mist Blue"
    And the user adds the product "Apple iPhone 17 256GB Mist Blue" to the cart
    And the user navigates to the shopping cart
    Then the product name in the cart should be "Apple iPhone 17 256GB Mist Blue"

    Examples:
      | productName                     |
      | Apple iPhone 17 256GB Mist Blue |
