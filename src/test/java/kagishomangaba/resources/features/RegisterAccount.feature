@Regression
Feature: Register Account

  As a new user
  I want to create an account
  So that I can access the application

  Background:
    Given I am on the landing page

  @Positive
  Scenario Outline: Fill registration form safely
    When I navigate to the account creation page
    When I enter the registration details:
      | firstName | <firstName> |
      | lastName  | <lastName>  |
      | phone     | <phone>     |
      | vatNumber | <vatNumber> |
      | email     | <email>     |
      | password  | <password>  |
      | confirm   | <confirm>   |

    Examples:
      | firstName | lastName | phone       | vatNumber | email                 | password    | confirm     |
      | Kagisho   | Mangaba  | 0712345678  | 12345678  | kagisho@test.com     | Test@1234   | Test@1234   |
      | Sarah     | Smith    | 0729876543  | 87654321  | sarah@test.com       | Password@1  | Password@1  |
