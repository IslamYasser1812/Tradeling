Feature: Check filter by department

  Scenario: Check filter by department in Deals and Promotions page
    Given User goto home page
    And User Select Deals from Home Page
    When User choose category Computers and sub category Software Department
    Then Selected department is displayed