Feature: Create a post

  Scenario: Create a post in the Buzz module

    Given user is logged into OrangeHRM page with following credentials:
      | Username | Admin    |
      | Password | admin123 |
    And user selects Buzz module

    When user populate 'What's on your mind? field with space value
    And clicks the Post button

    Then an error message for empty post is displayed