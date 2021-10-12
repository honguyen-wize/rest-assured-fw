Feature: Add Place Validations

  Scenario: Verify if a place is able to add
    Given the place Payload is created
    When user calls "AddPlaceAPI" with Post http request
    Then the API call got success with status code 200
    And "status" in response body is "OK"
    And "scope" in response body is "APP"
