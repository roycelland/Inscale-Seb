Feature: Bank Manager
  Background:
    Given user is on login page
    When user click "Manager" login

  Scenario: Question 1
    Then user see "Add Customer" button in managers page
    When user click "Add Customer" button
    And user see "First Name" field
    And user add the following customers
#      | First Name  | Last Name   | Postcode |
      | Christopher | Connely     | L789C349 |
      | Frank       | Christopher | A897N450 |
      | Christopher | Minka       | M098Q585 |
      | Connely     | Jackson     | L789C349 |
      | Jackson     | Frank       | L789C349 |
      | Minka       | Jackson     | A897N450 |
      | Jackson     | Connely     | L789C349 |
    And user click "Customer" button
    And user see "Search Bar" field in customer tab
    Then user verify the following customers
#      | First Name  | Last Name   | Postcode |
      | Christopher | Connely     | L789C349 |
      | Frank       | Christopher | A897N450 |
      | Christopher | Minka       | M098Q585 |
      | Connely     | Jackson     | L789C349 |
      | Jackson     | Frank       | L789C349 |
      | Minka       | Jackson     | A897N450 |
      | Jackson     | Connely     | L789C349 |
    When user will delete the following customers
#      | First Name  | Last Name   | Postcode |
      | Jackson     | Frank   | L789C349 |
      | Christopher | Connely | L789C349 |
    Then user verify the following deleted customers
    #      | First Name  | Last Name   | Postcode |
      | Jackson     | Frank   | L789C349 |
      | Christopher | Connely | L789C349 |
