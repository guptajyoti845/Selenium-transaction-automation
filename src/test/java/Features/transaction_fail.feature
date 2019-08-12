Feature: Launching Web Application

  Scenario: User proceeding for successful transaction for Midtrans Pillow
    Given Initialize the browser with chrome
    Given "Midtrans Pillow" title is visible
    Given "BUY NOW" button is visible
    Then "BUY NOW" button is clicked
    When "CHECKOUT" button is visible
    Then "CHECKOUT" button is clicked
    Given "CONTINUE" button is visible
    When "CONTINUE" button is clicked
    Then "Select Payment" title is visible
    Then "Credit Card" button is clicked
    Then Enter CardNumber "4911 1111 1111 1113"
    And Enter ExpiryDate "0220"
    And Enter CVV "123"
    Then "PAY NOW" button is visible
    And "PAY NOW" button is clicked
    Then Enter Password "112233"
    Then "OK" button is clicked
    Then "RETRY" button is visible
    And "Transaction failed" title is visible
    Then "RETRY" button is clicked
    Then "Select Payment" title is visible
    Then "Credit Card" button is clicked
    Then Enter CardNumber "4811 1111 1111 1114"
    And Enter ExpiryDate "0220"
    And Enter CVV "123"
    Then "PAY NOW" button is visible
    And "PAY NOW" button is clicked
    Then Enter Password "112233"
    Then "OK" button is clicked
    Then "Thank you for your purchase." title is visible
    And close the browser