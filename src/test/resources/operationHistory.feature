Feature: Verify operation history behavior

  Scenario: Send an operation history request
    Given the client sends a request to "/history"
    Then the response will return status 200 and successful message

  Scenario: Send a valid deposit request and verify history
    Given the client sends a request to "/deposit" with an amount of 51.0
    And the client sends a request to "/history" to verify his account statement
    Then the response will return status 200 and the history with the new deposit record