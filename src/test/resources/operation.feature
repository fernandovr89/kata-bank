Feature: Verify deposit operations

  Scenario: Send a valid deposit request
    Given the client sends a request to "/deposit" with an amount of 600
    Then the response will return status 200 and successful message

  Scenario: Send a valid deposit request with operation input (amount)
    Given the client sends a request to "/deposit" with an amount of 100
    Then the response will return status 200, successful message and deposit amount of 100