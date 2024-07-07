Feature: As a user of application I want to validate product functionality

  Scenario: validate list of products
    # Given user has launched url "https://www.saucedemo.com/"
    And user has entered username "standard_user" and password "secret_sauce"
    And User click on Login
    Then user validate the following products
      | Sauce Labs Backpack      |
      | Sauce Labs Bike Light    |
      | Sauce Labs Fleece Jacket |


  Scenario: validate list of products along with its price
    # Given user has launched url "https://www.saucedemo.com/"
    And user has entered username "standard_user" and password "secret_sauce"
    And User click on Login
    Then user verifies following Products and respective prices
      | Sauce Labs Backpack     | $29.99 |
      | Sauce Labs Bike Light   | $9.99  |
      | Sauce Labs Bolt T-Shirt | $15.99 |

 
  Scenario: validate product is added to card and removed from cart
    # Given user has launched url "https://www.saucedemo.com/"
    And user has entered username "standard_user" and password "secret_sauce"
    And User click on Login
    When User add "Sauce Labs Backpack" item to card
    Then User remove item from cart
    And User verify the item is removed from card
