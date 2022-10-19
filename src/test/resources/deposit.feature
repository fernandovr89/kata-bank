Feature: Verify deposit operations

  Scenario: Send a valid deposit request
    Given the client sends a request to "/deposit" with an amount of 600
    Then the response will return status 200 and successful message

  Scenario: Send an invalid deposit request with not amount field
    Given the client sends a request to "/deposit" with no field called amount
    Then the response will return status 400 and error message "The field amount is mandatory"

  Scenario: Send an invalid deposit request with amount equal to zero
    Given the client sends a request to "/deposit" with an amount of 0.0
    Then the response will return status 400 and error message "The operation amount must be greater than zero"

  Scenario: Send an invalid deposit request with negative amount
    Given the client sends a request to "/deposit" with an amount of -900.0
    Then the response will return status 400 and error message "The operation amount must be greater than zero"

  Scenario: Send an invalid deposit request with balance reaching a maximum value (Double.MAX_VALUE)
    Given the client sends a request to "/reset"
    And the client sends a request to "/deposit" with a huge amount
    And the client sends a request to "/deposit" with an amount of 1.0
    Then the response will return status 400 and error message "The account balance has reached the maximum value"