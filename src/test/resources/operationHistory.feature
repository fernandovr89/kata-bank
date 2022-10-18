Feature: Verify operation history behavior

  Scenario: Send an operation history request
    Given the client sends a request to "/history"
    Then the response will return status 200 and successful message