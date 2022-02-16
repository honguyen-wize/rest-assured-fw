Feature: Add Place Validations

  @Regression
  @AddPlace
  Scenario Outline: Verify if a place is able to add
    Given Add place Payload with "<name>" "<language>" "<address>"
    When user calls "ADD_PLACE_API" with "POST" http request
    Then the API call got success with status code 200
    And "status" in response body is "OK"
    And "scope" in response body is "APP"
    And verify created place_id maps to "<name>" using "GET_PLACE_API"
    And the added place has the correct schema

    Examples:
    |name         |language     |address              |
    |Ho Nguyen    |Vietnamese   |MoonLight Park View  |
#    |Mr Bean      |Chinese      |Viettel Building     |

  @Regression
  @DeletePlace
  Scenario: Verify delete a place
    Given Delete place Payload
    When user calls "DELETE_PLACE_API" with "POST" http request
    Then the API call got success with status code 200
    And "status" in response body is "OK"