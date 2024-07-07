Feature: As a user of application I want to validate login functionality

  Scenario Outline: Validate login functionality with data driven
    # Given user has launched url "https://www.saucedemo.com/"
    And user has entered username "<username>" and password "<password>"
    And User click on Login
    Then user verify "Products" on Dashboard

    Examples: 
      | username                 | password     |
      | standard_user            | secret_sauce |
      | locked_out_user          | secret_sauce |
      | problem_user             | secret_sauce |
      | performance_glitch_userr | secret_sauce |
      | error_user               | secret_sauce |
      | visual_user              | secret_sauce |

  #Background:
  #And user has entered username "standard_user" and password "secret_sauce"
  #And User click on Login
  Scenario: Validate login functionality with valid credentials
    # Given user has launched url "https://www.saucedemo.com/"
    And user has entered username "standard_user" and password "secret_sauce"
    And User click on Login
    Then user verify "Products" on Dashboard

  Scenario: Validate logout functionality
    # Given user has launched url "https://www.saucedemo.com/"
    Given user has entered username "standard_user" and password "secret_sauce"
    And User click on Login
    And User click on menu on Dashboard
    And User click on Logout
    Then User verify title

  Scenario: Validate login functionality with datatable with only one data entry
    # Given user has launched url "https://www.saucedemo.com/"
    And user has entered credentials
      | UserName | standard_user |
      | Password | secret_sauce  |
    When User click on Login
    Then user verify "Products" on Dashboard


  Scenario: Validate login functionality with list of map
    # Given user has launched url "https://www.saucedemo.com/"
    And user has entered credentials with list of map
      | UserName      | Password     |
      | standard_user | secret_sauce |
    When User click on Login
    Then user verify "Products" on Dashboard
