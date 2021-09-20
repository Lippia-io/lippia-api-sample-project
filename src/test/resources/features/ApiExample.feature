Feature: Api example
  As an api user I want to execute request in order to get proper responses

  @Example @Success
  Scenario Outline: Example scenario for get user data
    When I perform a '<operation>' to '<entity>' endpoint with the '<jsonName>' and ''
    Then status code <statusCode> is obtained
    And expected response is obtained in '<entity>' with '<expectedResponse>'

    Examples:
      | jsonName    | statusCode | operation | entity   | expectedResponse   |
      | exampleJson | 200        | GET       | USER     | users              |

  @Example @Success
  Scenario Outline: Example scenario for get user data
    When I perform a '<operation>' to '<entity>' endpoint with the '<jsonName>' and ''
    Then status code <statusCode> is obtained
    And expected response is obtained in '<entity>'

    Examples:
      | jsonName    | statusCode | operation | entity   |
      | exampleJson | 200        | GET       | USER     |

  @Example @Success
  Scenario Outline: Example scenario for bad request
    When I perform a '<operation>' to '<entity>' endpoint with the '<jsonName>' and ''
    Then status code <statusCode> is obtained
    And not response at all is obtained

    Examples:
      | jsonName         | statusCode | operation    | entity   |
      | exampleJsonError | 404        | GET          | USER     |

  @Example @Success
  Scenario Outline: Example scenario for delete user
    When I perform a '<operation>' to '<entity>' endpoint with the '<jsonName>' and ''
    Then status code <statusCode> is obtained
    And not response at all is obtained

    Examples:
      | jsonName         | statusCode | operation    | entity   |
      | exampleDelete    | 204        | DELETE       | USER     |

  @Example @Success
  Scenario Outline: Example scenario for get user data empty
    When I perform a '<operation>' to '<entity>' endpoint with the '<jsonName>' and ''
    Then status code <statusCode> is obtained
    And response is empty

    Examples:
      | jsonName         | statusCode | operation    | entity         |
      | exampleJson      | 200        | GET          | emptyUsers     |

  @Example @Success
  Scenario Outline: Example scenario for bad request
    When I perform a '<operation>' to '<entity>' endpoint with the '<jsonName>' and ''
    Then status code <statusCode> is obtained
    And text <text> was obtained in response

    Examples:
      | jsonName         | statusCode | operation    | entity     | text         |
      | exampleJson2     | 418        | GET          | SAMPLE     | I'm a teapot |

  @Example @Success
  Scenario Outline: Example scenario for get users
    When I perform a '<operation>' to '<entity>' endpoint with the '<jsonName>' and ''
    Then status code <statusCode> is obtained
    And expected response is obtained in '<entity>' with '<jsonExpected>' and the parameters '<parameters>'

    Examples:
      | jsonName    | statusCode | operation | entity | jsonExpected    | parameters  |
      | exampleJson | 200        | GET       | USER   | usersWithParams | name:Janet  |