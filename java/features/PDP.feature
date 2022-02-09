Feature: Check filter by department

  Scenario: Check filter by department in Deals and Promotions page
    Given User goto home page
    When User Search for "Apple" and select first product
    And User swipe the product images
    Then Price of product displayed
    And Payment Options are displayed
    And Product availability information is displayed
    And Add to cart functionality works fine