Feature: Check the category page content

  Scenario: Check the total displayed number of results for category Smart Home | Televisions
    Given User goto home page
    And User selects shop by department from burger menu
    When User choose category Electronics and sub category TV and Video
    And User Filter with smart TV
    And User clicks show results
    Then Total number of results match the total displayed in filter