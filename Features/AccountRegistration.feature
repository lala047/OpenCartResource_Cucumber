Feature: Account Registration
 
Background: background steps
    Given User Launch browser
    And opens URL "https://demo.opencart.com/"
    When User navigate to MyAccount menu
    
  Scenario: Successful Account Registration with Valid user details
    And click on Register
    Then user navigates to Register Account page
    When user provide valid details
    And Check the Privacy Policy
    And Click on continue
    Then User should see "Your Account Has Been Created!" message