Feature: Bank Manager

  Background:
    Given user is on login page
    When user click "Customer" login

  Scenario: Question 2
    Then user see "User Select" button in customers page
    When user select "Hermoine Granger" as user name
    And user click "Login" button in customers page
    Then user see "Transaction" button in customers page
    When user select "1003" as account number
    And user click "Deposit Tab" button in customers page
    And user input "50000" amount
    And user click "Deposit" button in customers page
    Then balance will be "50000"
    When user click "Withdrawal Tab" button in customers page
    Then successful message will disappear
    When  user input "3000" amount
    And user click "Withdraw" button in customers page
    Then balance will be "47000"
    When user click "Withdrawal Tab" button in customers page
    And  user input "2000" amount
    And user click "Withdraw" button in customers page
    Then balance will be "45000"
    When user click "Deposit Tab" button in customers page
    Then successful message will disappear
    When  user input "5000" amount
    And user click "Deposit" button in customers page
    Then balance will be "50000"
    When user click "Withdrawal Tab" button in customers page
    Then successful message will disappear
    When  user input "10000" amount
    And user click "Withdraw" button in customers page
    Then balance will be "40000"
    When user click "Withdrawal Tab" button in customers page
    And  user input "15000" amount
    And user click "Withdraw" button in customers page
    Then balance will be "25000"
    When user click "Deposit Tab" button in customers page
    Then successful message will disappear
    When  user input "1500" amount
    And user click "Deposit" button in customers page
    Then balance will be "26500"