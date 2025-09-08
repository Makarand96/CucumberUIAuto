
Feature: Search and Place the order for Products
  
@Product
Scenario Outline: Search Experience for product search in both home and Offers page 
    Given User is on GreenCart Landing Page
    When user searched with shortname <Name> and extracted actual name of Product
    Then user searched for <Name> shortname in offers page
    And Validate product name offers page matches with Landing Page

Examples:
 	| Name  | 
  | Tom  	|
  | Beet  |
