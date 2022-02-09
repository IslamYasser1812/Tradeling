Feature: Check the category page content

  Scenario: Check the total displayed number of results for category Smart Home | Televisions
    Given User goto home page
    And User selects shop by department from burger menu
    When User click on Settings
    And User select Country and Language
    And User changes currency from USD to AED
    Then Selected currency displayed for Deals and Promotions products