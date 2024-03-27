Feature: Api example
  As an api user I want to execute request in order to get proper responses

  @Example @Success @Candidate @GetData
  Scenario Outline: Example scenario for get user data
    When I perform a '<operation>' to '<entity>' endpoint with the '<jsonName>' and ''
    Then status code <statusCode> is obtained
    And expected response is obtained in '<entity>' with '<expectedResponse>'

    Examples:
      | jsonName    | statusCode | operation | entity   | expectedResponse   |
      | exampleJson | 200        | GET       | USER     | users              |

  @Example @Success @NoCandidate @GetData
  Scenario Outline: Example scenario for get user data
    When I perform a '<operation>' to '<entity>' endpoint with the '<jsonName>' and ''
    Then status code <statusCode> is obtained
    And expected response is obtained in '<entity>'

    Examples:
      | jsonName    | statusCode | operation | entity   |
      | exampleJson | 200        | GET       | USER     |

  @Example @Success @ToBeAutomated @DeleteUser
  Scenario Outline: Example scenario for delete user
    When I perform a '<operation>' to '<entity>' endpoint with the '<jsonName>' and ''
    Then status code <statusCode> is obtained
    And not response at all is obtained

    Examples:
      | jsonName         | statusCode | operation    | entity   |
      | exampleJson      | 204        | DELETE       | USER     |

  @Example @Success @Automated @GetUsers
  Scenario Outline: Example scenario for get users
    When I perform a '<operation>' to '<entity>' endpoint with the '<jsonName>' and ''
    Then status code <statusCode> is obtained
    And expected response is obtained in '<entity>' with '<jsonExpected>' and the parameters '<parameters>'

    Examples:
      | jsonName    | statusCode | operation | entity | jsonExpected    | parameters  |
      | exampleJson | 200        | GET       | USER   | usersWithParams | name:Janet  |