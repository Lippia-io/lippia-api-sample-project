Feature: Api example
  As an api user I want to execute request in order to get proper responses

  @Example @Success @First
  Scenario Outline: Example scenario for get user data
    When I perform a '<operation>' to '<entity>' endpoint with the '<jsonName>' and ''
    Then status code <statusCode> is obtained
    And expected response is obtained in '<entity>' with '<expectedResponse>'

    Examples:
      | jsonName    | statusCode | operation | entity   | expectedResponse   |
      | exampleJson | 200        | GET       | USER     | users              |

  @Example @Success @First
  Scenario Outline: Example scenario for get user data
    When I perform a '<operation>' to '<entity>' endpoint with the '<jsonName>' and ''
    Then status code <statusCode> is obtained
    And expected response is obtained in '<entity>'

    Examples:
      | jsonName    | statusCode | operation | entity   |
      | exampleJson | 200        | GET       | USER     |

  @Example @Success @First
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
  Scenario Outline: Example scenario for bad request
    When I perform a '<operation>' to '<entity>' endpoint with the '<jsonName>' and ''
    Then status code <statusCode> is obtained
    And text <text> was obtained in response

    Examples:
      | jsonName         | statusCode | operation    | entity     | text         |
      | exampleJson2      | 418        | GET          | SAMPLE     | I'm a teapot |


  @Example @Success
  Scenario Outline: Example scenario for input parameters
    When I perform a '<operation>' to '<entity>' endpoint with the '<jsonRequestName>' and '<inputParameters>'
    Then I will get the proper status code '<statusCode>'
    And I will get the proper response in '<jsonResponseName>'

    Examples:
      | jsonRequestName        | statusCode | operation | entity           | inputParameters         | jsonResponseName        |
      | responseHeadersRequest | 200        | GET       | RESPONSE_HEADERS | value1:bar1,value2:bar2 | responseHeadersResponse |