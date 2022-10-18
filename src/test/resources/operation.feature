Feature: Verify deposit operations

  Scenario: Send a valid deposit request and verify history
    Given the client sends a request to "/deposit" with an amount of 600
    Then the response will return status 200 and successful message