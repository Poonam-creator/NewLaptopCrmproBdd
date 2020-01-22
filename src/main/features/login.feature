Feature: Login feature
  Scenario: validate login
    Given customer is on login page
    When customer enters emailId and password
    And  customer clicked on login button
    Then customer should be on homepage
    Then customer clicked on setting icon
    And  customer clicked on logout button