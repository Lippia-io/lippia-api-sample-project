Feature: clockify

  @Workspace @Smoke
  Scenario Outline: Get all my workspaces
    Given tengo una apiKey correcta <apiKey>
    When I perform a '<operation>' to '<entity>' endpoint with the '<jsonName>' and ''
    Then validar que el status code sea 200
    And valido que el campo id no sea nulo


    Examples:
      | operation | entity    | jsonName           | apiKey                                           |
      | GET       | WORKSPACE | getAllMyWorkspaces | MTQzZTE1ZDAtMzI5MS00ZmQxLWFmOTMtZTUwOTIyOTBkYTlh |


  @Workspace @Smoke
  Scenario Outline: POST Add New Workspaces
    Given tengo una apiKey correcta <apiKey>
    When I perform a '<operation>' to '<entity>' endpoint with the '<jsonName>' and ''
    Then validar que el status code sea 201

    Examples:
      | operation | entity       | jsonName     | apiKey                                           |
      | POST      | ADDWORKSPACE | AddWorkspace | MTQzZTE1ZDAtMzI5MS00ZmQxLWFmOTMtZTUwOTIyOTBkYTlh |


  @Project  @Smoke
  Scenario Outline: GET all projects on workspace
    Given tengo una apiKey correcta <apiKey>
    When I perform a '<operation>' to '<entity>' endpoint with the '<jsonName>' and ''
    Then validar que el status code sea 200

    Examples:
      | operation | entity   | jsonName    | apiKey                                           |
      | GET       | PROJECTS | AllProjects | MTQzZTE1ZDAtMzI5MS00ZmQxLWFmOTMtZTUwOTIyOTBkYTlh |


  @Project  @Smoke
  Scenario Outline: POST Add a new project
    Given tengo una apiKey correcta <apiKey>
    And I perform a 'GET' to 'WORKSPACE' endpoint with the 'getAllMyWorkspaces' and ''
    And obtengo un id de workspace correcto
    When I perform a '<operation>' to '<entity>' endpoint with the '<jsonName>' and ''
    Then validar que el status code sea 201

    Examples:
      | operation | entity   | jsonName      | apiKey                                           |
      | POST      | PROJECTS | addNewProject | MTQzZTE1ZDAtMzI5MS00ZmQxLWFmOTMtZTUwOTIyOTBkYTlh |

  @Project  @Smoke
  Scenario Outline: Delete project from workspace
    Given tengo una apiKey correcta <apiKey>
    And I perform a 'GET' to 'WORKSPACE' endpoint with the 'getAllMyWorkspaces' and ''
    And obtengo un id de workspace correcto
    And I perform a 'POST' to 'PROJECTS' endpoint with the 'addNewProject' and ''
    Then validar que el status code sea 201
    And obtengo un id de projects correcto
    And archivo el proyecto con la operacion 'PUT' para 'PROJECTS' con 'ProjectJson'
    Then validar que el status code sea 200
    When I perform a '<operation>' to '<entity>' endpoint with the '<jsonName>' and ''
    Then validar que el status code sea 200

    Examples:
      | operation | entity   | jsonName    | apiKey                                           |
      | DELETE    | PROJECTS | ProjectJson | MTQzZTE1ZDAtMzI5MS00ZmQxLWFmOTMtZTUwOTIyOTBkYTlh |

  @Project  @Smoke
  Scenario Outline: GET Find project by ID
    Given tengo una apiKey correcta <apiKey>
    And I perform a 'GET' to 'WORKSPACE' endpoint with the 'getAllMyWorkspaces' and ''
    And obtengo un id de workspace correcto
    And I perform a 'POST' to 'PROJECTS' endpoint with the 'addNewProject' and ''
    Then validar que el status code sea 201
    And obtengo un id de projects correcto
    When Ejecuto el endpoint del proyecto con la operacion '<operation>' para '<entity>' con '<jsonName>'
    Then validar que el status code sea 200
    Examples:
      | operation | entity   | jsonName    | apiKey                                           |
      | GET       | PROJECTS | ProjectJson | MTQzZTE1ZDAtMzI5MS00ZmQxLWFmOTMtZTUwOTIyOTBkYTlh |

  @Project  @Smoke
  Scenario Outline: Crear y consultar nuevo cliente
    Given tengo una apiKey correcta <apiKey>
    And I perform a 'GET' to 'WORKSPACE' endpoint with the 'getAllMyWorkspaces' and ''
    And obtengo un id de workspace correcto
    When I perform a '<operation>' to '<entity>' endpoint with the '<jsonName>' and ''
    Then validar que el status code sea 201
    And obtengo el id del cliente
    When I perform a 'GET' to 'CLIENTS' endpoint with the 'ClienteJson' and ''
    Then validar que el status code sea 200


    Examples:
      | operation | entity  | jsonName    | apiKey                                           |
      | POST       | CLIENTS | ClienteJson | MTQzZTE1ZDAtMzI5MS00ZmQxLWFmOTMtZTUwOTIyOTBkYTlh |