Feature: Place an order for a product

@ProductCheckout
  Scenario Outline: Verify product can be added to cart and order placed
    Given User is on GreenCart Landing Page
    When user searched with shortname <Name> and extracted actual name of Product
    And Adds 3 items of the product to the cart and Proceeds to checkout from the Cart Page
    Then The product name <Name> should be displayed in the Cart Page
    And Apply and Place Order buttons should be visible on the Cart Page

Examples:
	|Name|
	|Tom|

