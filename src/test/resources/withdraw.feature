Feature: Verify withdraw operations

  Scenario: Send a valid withdraw request
    Given the client sends a request to "/withdraw" with an amount of 600
    Then the response will return status 200 and successful message

  Scenario: Send a valid withdraw request with operation input (amount)
    Given the client sends a request to "/withdraw" with an amount of 100
    Then the response will return status 200, successful message and amount of 100

  Scenario: Send an invalid withdraw request with not amount field
    Given the client sends a request to "/withdraw" with no field called amount
    Then the response will return status 400 and error message "The field amount is mandatory"

  Scenario: Send an invalid withdraw request with amount equal to zero
    Given the client sends a request to "/withdraw" with an amount of 0.0
    Then the response will return status 400 and error message "The operation amount must be greater than zero"

  Scenario: Send an invalid withdraw request with negative amount
    Given the client sends a request to "/withdraw" with an amount of -900.0
    Then the response will return status 400 and error message "The operation amount must be greater than zero"