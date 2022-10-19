Feature: Verify operation history behavior

  Scenario: Send an operation history request
    Given the client sends a request to "/history"
    Then the response will return status 200

  Scenario: Send a valid operation request and verify history
    Given the client sends a request to "/reset"
    And the client sends a request to "/deposit" with an amount of 51.0
    And the client sends a request to "/history" to verify his account statement
    Then the response will return status 200 and the history with the new deposit record

  Scenario: Send a valid operation requests and verify updated balance
    Given the client sends a request to "/reset"
    And the client sends a request to "/deposit" with an amount of 1000.0
    And the client sends a request to "/withdraw" with an amount of 300.0
    And the client sends a request to "/deposit" with an amount of 99.0
    And the client sends a request to "/history" to verify his account statement
    Then the response will return status 200 and the history with the updated balance of 799.0