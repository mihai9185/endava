Feature: Add Employee

  Scenario: Add an employee with numeric name and alphabetic employee ID

    Given user is logged into OrangeHRM page with following credentials:
      | Username | Admin    |
      | Password | admin123 |
    And user selects PIM module
    And user clicks the + Add button

    When user populate Add Employee form with following details:
      | First Name  | 12345 |
      | Last Name   | 54321 |
      | Employee Id | Alex  |
    And clicks Save button

    Then an error message for invalid name and employee ID formats is displayed