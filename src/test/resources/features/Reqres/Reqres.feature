Feature: Reqress Feature test
  @Tugas
  Scenario: Post Register with valid json
    Given Post Register with valid json
    When Send Post Register request
    Then Status code should be 200 OK
    And Response body page should contain id 4 and token "QpwL5tke4Pnpja7X4"
    And Validate Register json schema


  Scenario: Post Register with invalid json
    Given Post Register with invalid json
    When Send Post FailRegister request
    Then status code should be 400
    And Response body page should contain error "Missing password"
    And Validate Register invalid json schema

  @Tugas
  Scenario: Post Login with valid json
    Given Post Login with valid json
    When Send Post Login request
    Then status code login should be 200 OK
    And Response body page should contain token "QpwL5tke4Pnpja7X4"
    And Validate Login json schema

    @Tugas
    Scenario: Post Login with invalid json
      Given Post Login with invalid json
      When Send Post Fail Login request
      Then status code login should be 400
      And Response body page should contain error Login "Missing password"
      And Validate Invalid Login json schema

      @Tugas
      Scenario: Post create new user with invalid json
        Given Post create user with invalid json
        When Send post create user request
        Then Status code should be 201
        And Response body page should contain name and job "leader%"
        And Validate Invalid Create User json schema

@Tugas
Scenario Outline: Get list user with valid parameter pages
  Given Get list user with parameter page <page>
  When Send get list user request
  Then Status code get list should be 200 OK
  And Response body page should be <page>
  And Validate get list user json schema

  Examples:
    | page       |
    | 1          |
    | 2          |
    | 3000       |
    | 100000     |
    | 1000000000 |

  @Tugas
  Scenario Outline: Put update user with valid json
    Given Put update user with valid json with id <id>
    When Send put update user request
    Then Status code should be 200 OK
    And Response body page should contain name "Hanifah Update" and job "QA Update"
    And Validate put update user json schema
    Examples:
      | id         |
      | 1          |
      | 2          |
      | 3000       |
      | 100000     |
      | 1000000000 |
  @Tugas
  Scenario Outline: Delete user with valid id
    Given Delete user with id <id>
    When Send delete user request
    Then Status code should be 204 No Content

    Examples:
      | id         |
      | 1          |
      | 2          |
      | 3000       |
      | 100000     |
      | 1000000000 |


