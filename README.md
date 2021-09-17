# LIPPIA API Example Project

## System Requirements : 
+ git client: https://www.atlassian.com/git/tutorials/install-git 
+ docker 18.09: https://docs.docker.com/install/linux/docker-ce/ubuntu/ 
+ docker compose 1.24: https://docs.docker.com/compose/install/

## Docker stack

The following project includes the basic Docker Lippia Containers to run this  web sample project. You can choose to run the code from your favourite IDE, run from console or from Jenkins using the Docker Stack.
To install and start a local instalation with Docker containers go to **Getting started** at the end of this guide. 

# Purpose: 

The following project has the purpose of demonstrate and let test automation developers to to test API requests using Lippia Automation Framework based on Rest Client library. 
This sample project includes the required components as binaries, docker containers and configuration files to simply download and run a set of sample tests in your local computer, using the Lippia container stack described bellow.

# Getting started

## Executing tests in you local machine 
- go to root project folder and you will find a pom.xml file
- run the following command : 
```
sudo docker-compose -f docker-compose.yml up --abort-on-container-exit --exit-code-from lippia
```
	
## Project structure

A typical Lippia Test Automation project usually looks like this 

```
	.
├── main
│   ├── java
│   │   └── com
│   │       └── crowdar
│   │           └── api
│   │		 └── config
│   │ 	         |    └── EntityConfiguration.java
│   │            └── model
│   │               │   └── Data.java
│   │               │   └── ResponseHeaders.java
│   │		    │	└── User.java
│   │               │   └── UserCreated.java
│   │               │   └── Users.java
│   │               └── services
│   │                   └── ResponseHeadersService.java
│   │                   └── UserService.java
│   └── resources
│       ├── config.properties
│       ├── cucumber.properties
│       └── log4j.properties
└── test
    ├── java
    │   ├── ApiExampleProjectParallelTestRunner.java
    │   ├── ApiExampleProjectTestRunner.java
    │   └──
	└── steps	
	│   └── ResponseHeadersSteps.java
	│   └── UserSteps.java
	└── apiExampleProject
    │           └── Hooks.java
    └── resources
        └── features
            └── ApiExample.feature
		└── jsons
	└── jsons
            └── request
	    	└── createUser.json
		└── errorRequest.json
		└── exampleJson.json
		└── responseHeadersRequest.json
	    └── response
	    	└── responseHeadersResponse.json
```

Folder's description:

|Path   |Description    |
|-------|----------------|
|main\java\\...\examples\model\\\*.java|Folder with all the **Mapped Objects** matching steps with java code |
|main\java\\...\examples\config\\\*Steps.java|Folder with all the **Settings** wich match with Gherkin Test Scenarios |
|test\resources\features\\\*.feature|Folder with all the **feature files** containing **Test Scenarios** and **Sample Data** |
|test\resources\request\\\*.json|Folder with all the **json files** containing **Request** data |
|test\resources\response\\\*.json|Folder with all the **json files** containing **Response** data if necessary |
|main\resources|Folder with all configuration needed to run Lippia |

In this example, *ApiExample* is the first endpoint the framework will interact with. The **steps** defined in *UserSteps.java* to execute the *Test Scenarios* defined in Gherkin language. 


|File   | Description    |
|-------|----------------|
|User.java   | Model: you can declare every attribute expected on the responses that you want to interact with. You need to add one new file for each response you want to model in your tests. |
|UserSteps.java   | StepOpject: Code to support the behaviour of each **step** coded into the feature files for the *User* endpoint. This code executes the interaction between the Framework and the api endopoint and match the steps with the code who run interactions. |
|ApiExample.feature| Feature file: Definition of the **Test Scenarios** with all the **steps** written in Cucumber format (http)|

# Lippia Architecture	

![Lippia Architecture API](docs/images/architectureApi.png)

The scenarios can be written using BDD methodology. 
	
	Given as a precondition
	
	When as actions
	
	Then as validations
	
	
On each declared step you can insert the calls defined from service classes

# Json Structure for request data

This project use json to manage request data like url parameters, body data, headers and url endpoints. The following picture shows the structure of the json


![Lippia Scenarios Example API](docs/images/jsonStructure.png)

# Getting started
    
- If you are Linux user 
    [`Getting started - Linux User`](docs/README_Linux.md)
- If you are Windws user
    [`Getting started - Windows User`](docs/README_Windows.md)

## Project type options:
- The project type option allows the user to say Lippia which library would need to download. For this project is setted the API one that only have all library needed for this kind of project.
  This option can be changed in the pom.xml file
  You can get more information checking the readme file from lippia-core project.
  
  API
        crowdar.projectType=API

# Gherkin Examples

## JSON Assertions

### Json obtained against json expected

![Assertion 1, assertion of json obtained against json expected](docs/images/assertion-1_sample.png)

### Entities explanation

The EntityConfiguration class has located in config folder, and here, is where entities are declared.
For example:

EntityConfiguration CLASS: (note that USER entity is declared here, and it returns UserService CLASS)
```
public enum EntityConfiguration {

    USER {
        @Override
        public Class<?> getEntityService() {
            return UserService.class;
        }
    },
    
    public abstract Class<?> getEntityService();
}
```

UserService CLASS: (note that it´s extended from MethodsService CLASS and here the _HTTP Methods_ are declared,
in UserService are declared some methods who will be called according to operation value defined for Examples in the Scenario.
This method, which will receive 2 mandatory parameters:
the json name and the model class to deserialize the response)
```
public class UserService extends MethodsService {

    public static Response get(String jsonName) {
        return get(jsonName, Data.class);
    }

    public static Response post(String jsonName) {
        return post(jsonName, UserCreated.class);
    }

    public static Response delete(String jsonName) {
        return delete(jsonName, null);
    }

}
```

## Data composition

In the model examples you can mapped the expected objects from different api responses. We can show you a little example:
```
{
    "data": {
        "id": 2,
        "email": "janet.weaver@reqres.in",
        "first_name": "Janet",
        "last_name": "Weaver",
        "avatar": "https://s3.amazonaws.com/uifaces/faces/twitter/josephstein/128.jpg"
    }
}
```

So the model class will be something like this:
```
public class User {

    @JsonProperty("id")
    private int id;
    @JsonProperty("email")
    private String email;
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("last_name")
    private String lastNamelast_name;
    @JsonProperty("avatar")
    private String avatar;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public String getFirstName() { return firstName; }
    public void setFirstName(String first_name) { this.firstName = first_name; }
    
    public String getLastName() { return lastName; }
    public void setLastName(String last_name) { this.lastName = last_name; }
    
    public String getAvatar() { return avatar; }
    public void setAvatar(String avatar) { this.avatar = avatar; }
}
```

The idea is have one attribute per field to map on the response

![Json Examples](docs/images/JsonExamples.png)

### Json obtained against json mapped in the model class

![Assertion 2, assertion of json obtained against json mapped in the model class](docs/images/assertion-2_sample.png)

### Json obtained is null

![Assertion 3, validates that json obtained is null](docs/images/assertion-3_sample.png)

### Json obtained is an empty array

![Assertion 4, validates that json obtained is an empty array](docs/images/assertion-4_sample.png)

### Common Steps

The base url is defined in the pom.xml, in the property: <base.api.url></base.api.url>
e.g.
<base.api.url>https://reqres.in/api/users</base.api.url>

APIManager -> this class is used to set and get responses of the performed requests
BASE_URL Variable: contains the base url, which will you get the value of the base.api.url property defined previously

Constructor: EMPTY
Methods:
	setLastResponse() -> receives 1 parameter: the response, and it sets the last response of the performed request 
	getLastResponse() -> returns last response of the performed request 
	getResponseFromJsonFile() -> 
	getListResponseFromJsonFile() -> 

Response -> this class is used to set and get some attributes of the response
Constructor: 4 parameters: status code, message, response, and headers
 METHODS: 
-	getters 
            - getStatusCode() -> returns status code
            - getMessage() -> returns message
            - getResponse() -> returns response
            - getHeader() -> returns headers



```
@And("status code (.*) is obtained")
public void iWillGetTheProperStatusCodeStatusCode(int expStatusCode) {
	int actualStatusCode = APIManager.getLastResponse().getStatusCode();
        Assert.assertEquals(actualStatusCode, expStatusCode, "Status code are not equals.");
}

```
-This step, perform an assertion of status code obtained against status code expected    
        - The first line of code, calls getStatusCode() method that´s contained in Response class. 
                    and it´s, is called by getLastResponse() method that´s is contained in APIManager class.            
        - The second line of code, perform the assertion.

```   
    @Then("se obtuvo el response esperado en ([^ ]*) con el ([^ ]*)")
    @And("expected response is obtained in '([^']*)' with '([^']*)'")
    public void iWillGetTheProperResponse(String entity, String jsonName) throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException {
        this.setInjectorParameters(jsonName);
        this.invokeValidateMethod(entity, this.objectClass, this.objectClass, this.expectedJsonResponse, this.actualJsonResponse);
    }

```
-This step performs a validation data from object with the expected data         
        - In the first line of code, setInjectorParameters: sets actual data.
        -  In the second line of code, calls invokeValidateMethod that validates expected and actual datas.

```
    @Then("se obtuvo el response esperado en ([^ ]*) con el ([^ ]*) y sus parametros ([^ ]*)")
    @And("expected response is obtained in '([^']*)' with '([^ ]*)' and the parameters '([^']*)'")
    public void iWillGetTheProperResponseWithParameters(String entity, String jsonName, String inputParameters) throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException {
        this.setInjectorParameters(jsonName);
        Map<String, String> parameters = MapUtils.splitIntoMap(inputParameters, ",", ":");
        this.invokeValidateMethod(entity, parameters, this.objectClass, this.expectedJsonResponse);
    }

```
-This step performs a validation datas with parameters          
        - In the first line of code, setInjectorParameters: sets actual data.
        - In the second line of code, calls invokeValidateMethod that validates expected and actual datas with parameters.


```
    @Then("se obtuvo el response esperado en ([^ ]*) y sus parametros ([^ ]*)")
    @And("expected response is obtained in '([^']*)' and the parameters '([^']*)'")
    public void iWillGetTheProperResponseWithObjectAndParameters(String entity, String inputParameters) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, IOException, ClassNotFoundException, InstantiationException {
        this.setInjectorParameters((String)null);
        Map<String, String> parameters = MapUtils.splitIntoMap(inputParameters, ",", ":");
        this.invokeValidateMethod(entity, this.objectClass, Map.class, this.actualJsonResponse, parameters);
    }

```
-This step performs a validation datas with object and parameters    
        - In the first line of code, setInjectorParameters: sets actual data.
        - In the second line of code, calls invokeValidateMethod that validates expected and actual datas with object and parameters.

```
    @Then("se obtuvo el response esperado en ([^ ]*) modificando el ([^ ]*)")
    @And("expected response is obtained in '([^']*)' with '([^']*)' modifying the '([^']*)'")
    public void iWillGetTheProperResponseModified(String entity, String expectedJsonName) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, IOException, ClassNotFoundException, InstantiationException {
        this.setInjectorParameters((String)null);
        this.invokeValidateMethod(entity, String.class, this.objectClass, "response/".concat(expectedJsonName), this.actualJsonResponse);
    }

```
-This step performs a validation modified expected data with actual data.
        - In the first line of code, setInjectorParameters: sets actual data.
        - In the second line of code, calls invokeValidateMethod;                                                       
                - Modifies expected data with "response" by using "concat" method.
                - Validates expected and actual datas.

```

    @Then("se obtuvo el response esperado en ([^ ]*) modificando el ([^ ]*) y sus parametros ([^ ]*)")
    @And("expected response is obtained in '([^']*)' modifying the '([^ ]*)' and the parameters '([^']*)'")
    public void iWillGetTheProperResponseModifiedWithParameters(String entity, String expectedJsonName, String inputParameters) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, IOException, ClassNotFoundException, InstantiationException {
        this.setInjectorParameters((String)null);
        Map<String, String> parameters = MapUtils.splitIntoMap(inputParameters, ",", ":");
        this.invokeValidateMethod(entity, parameters, String.class, "response/".concat(expectedJsonName));
    }

```
-This step performs a validation modified expected data - actual data with the parameters.

        - In the first line of code, setInjectorParameters: sets actual data.                        
        - In the second line of code, calls invokeValidateMethod 
                        - Modifies expected data with "response" by using "concat" method.
                        - Validates expected and actual datas with parameters.


```
    @Then("se obtuvo el response esperado en ([^ ]*)")
    @And("expected response is obtained in '([^']*)'")
    public void iWillGetTheProperResponseWithObject(String entity) throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        this.setInjectorParameters((String)null);
        this.invokeValidateMethod(entity, "validateFields");
    }

```
-This step performs a validation data from method.
                
        - In the first line of code, sets actual data.
        - In the second line of code, calls validateFields method that validates datas.


```  
    @Then("se obtuvo el response esperado en ([^ ]*) con el metodo ([^ ]*)")
    @And("expected response is obtained in '([^']*)' with the method '([^']*)'")
    public void iWillGetTheProperResponseWithObject(String entity, String method) throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        this.setInjectorParameters((String)null);
        this.invokeValidateMethod(entity, method);
    }

```
-This step performs a validation data from method.
                    
        - In the first line of code, sets actual data.
        - In the second line of code, calls validateFields method that validates datas with method.

