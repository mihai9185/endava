Feature: Terminate Employee

  Scenario: Terminate an employee and check confirmation

    Given user is logged into OrangeHRM page with following credentials:
      | Username | Admin    |
      | Password | admin123 |
    And user selects PIM module
    And user clicks the edit icon next to first employee that appear
    And user navigates to the Job tab in the employee profile

    When user clicks on the Terminate Employment button
    And selects the following termination details:
      | Termination Date   | 2025-10-05 |
      | Termination Reason | Laid-off   |
    And clicks the Save button

    Then a confirmation message is displayed, informing the user that the termination is permanent and cannot be undone