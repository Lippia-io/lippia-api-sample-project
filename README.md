# LIPPIA API Example Project

<!--## Architecture

![Lippia Architecture API](docs/images/architectureApi.png)

- Through Spring rest client, lippia supports API tests, being able to reuse definitions from other tests as well as including this behavior in tests of other types such as mobile, web, etc.

- We believe that the best approach to automate testing from conception to deployment is to use BDD (Behaviour Driven Development) to include not just Developers, but Testers and Business Analysts, and that is why...   

The scenarios can be written using BDD methodology. 
	
	Given as a precondition
	
	When as actions
	
	Then as validations
	
	
On each declared step you can insert the calls defined from service classes -->

## System Requirements: 
+ jdk: https://docs.oracle.com/en/java/javase/index.html 
+ maven: https://maven.apache.org/download.cgi 
+ git client: https://www.atlassian.com/git/tutorials/install-git 
+ docker 18.09+: https://docs.docker.com/install/linux/docker-ce/ubuntu/  _OPTIONAL_ 
+ docker compose 1.24+: https://docs.docker.com/compose/install/ _OPTIONAL_ 

# Getting started

The following project has the purpose of demonstrate and let test automation developers to test API requests by using Lippia Automation Framework based on Rest Client library. 
This sample project includes the required components as binaries, docker containers and configuration files to simply download and run a set of sample tests in your local computer, using the Lippia container stack.

- ## Running with Maven

  + ### First Step

    + Download and unzip the source repository for this guide, or clone it using Git:   
    ```
    $ git clone https://gitlab.com/lippia/products/samples/lippia-api-sample-project.git
    ```

    + Go to root directory:   
    ```
    $ cd lippia-api-sample-project
    ```   

  + ### Second Step

    If you want to run tests locally, you need maven as a minimum requirement   
    + Make sure you have installed maven correctly   

    ```
    $ mvn --version

      OUTPUT:
        Apache Maven 3.8.2 (ea98e05a04480131370aa0c110b8c54cf726c06f)
        Maven home: /opt/apache-maven-3.8.2
        Java version: 13.0.5.1, vendor: Debian, runtime: /usr/lib/jvm/java-13-openjdk-amd64
        Default locale: en_US, platform encoding: UTF-8
        OS name: "linux", version: "5.10.0-6parrot1-amd64", arch: "amd64", family: "unix"
    ```

    If you don't see a similar output:
    + Make sure you have the maven path configured   
    #### Linux user
    ```
    $ grep -Ew '(.*)(M2_HOME)' ~/.bashrc

      OUTPUT:
        M2_HOME=/opt/apache-maven-3.8.2
        PATH=$PATH:$M2_HOME/bin
    ```   
    #### Windows user
    ```
    $ set

      OUTPUT:
        M2_HOME=C:\Program Files\apache-maven-3.8.2
        PATH=%PATH%;%M2_HOME%\bin;
    ```

  + ### Third Step

    + To run the tests with maven, we must execute the following command:   

    ```
    $ mvn clean test -PSecuencial
    ```

- ## Running with Docker

    ## Docker stack

    The following project includes the basic Docker Lippia Containers to run this API sample project. You can choose the code from your favourite IDE, to run from console or from Jenkins by using the Docker Stack.

    Note that if you don't have installed docker & docker-compose, [Click here](#system-requirements)

    + ### First Step
      - Make sure you have installed docker-engine correctly   
      ```
      $ docker --version
        OUTPUT:
          Docker version 19.03.15, build 99e3ed8919
      ```   
    
    + ### Second Step
      - Make sure you have installed docker-compose correctly
      ```
      $ docker-compose --version
        OUTPUT:
          docker-compose version 1.29.2, build 5becea4c
      ```   

    + ### Third Step   
        #### Execute tests in you local machine   
        
        - Go to root project folder and you will find a pom.xml file   
        ```
        $ cd lippia-api-sample-project
        ```   
        
        - Run the following command:   
        ```
        $ sudo docker-compose -f docker-compose.yml up --abort-on-container-exit --exit-code-from lippia

          OUTPUT:
            Creating network "lippia-api-sample-project_default" with the default driver
            Creating lippia-api-sample-project_lippia_1 ... done
            Attaching to lippia-api-sample-project_lippia_1
            lippia_1  | Running custom Command mvn clean test -PSecuencial -Dcucumber.tags=@Success
            ...
        ```   
	
# Reports[](url)

We believe that the reports should express the results of our tests in the most legible, detailed and pleasant way possible, so that in this way, our clients have at their disposal a report on the operation and behavior of their product, as well as the performance of the team. That is why Lippia, in addition to supporting the integration with **ExtentReport**, provides a **ReportServer** for each client.   
Next, we will see the structure of the project and from where we can access them.

### Reports are generated in the folder called **target**, which will be generated once the execution of the test suite is finished.   
Note that the following structure is part of the report generated with ExtentReport library.
```
├── lippia-api-sample-project
|   ├── docs
|   |   └── ...
|   ├── src
|   |   └── ...
│   ├── target
│   |   └── reports
|   |       └── index.html
|   └── ...
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

# Json Structure for request data

This project use json to manage request data like url parameters, body data, headers and url endpoints. The following picture shows the structure of the json


![Lippia Scenarios Example API](docs/images/jsonStructure.png)

<!--
# Getting started
    
- If you are Linux user 
    [`Getting started - Linux User`](docs/README_Linux.md)
- If you are Windws user
    [`Getting started - Windows User`](docs/README_Windows.md)
-->
## Project type options:
- The project type option allows the user to say Lippia which library will need to download. For this project is set the API one that only have all library needed for this kind of project.
  This option can be changed in the pom.xml file   
  You can get more information checking the README file from lippia-core project.
  
```
├── config.properties
        └── base.api.url = urlBase
        |   └── This option allows the user to say Lippia which urlBase would need to perform requests
        |
        └── crowdar.projectType = API
        |
        └── crowdar.api.entityConfiguration = api.config.entityConfiguration
            └── This option allows the user to say Lippia where to look for the defined constants or entities
                (note that java folder is ignored, the path must be specified from the java child folder)
```

# Runner configuration   
### Cucumber and TestNG integration
To have a proper configuration of Lippia and Cucumber, you should have a Runner class that extends from   
| RunnerType          | ExtendsFrom          |
| ------------------- | -------------------- |
| Secuencial          | TestNgRunner         |
| Parallel            | TestNGParallelRunner |

### Implementations
```
public class ExampleTestsRunner extends TestNgRunner {}

public class ExampleParallelTestRunner extends TestNGParallelRunner {}
```

Followed by that, you should implement an XML that points to the Runner   
For example, **parallelTestng.xml** contains    
```
<suite name="BDD Test Suite" verbose="1" parallel="methods" data-provider-thread-count="10" thread-count="10" configfailurepolicy="continue">
    <test name="Test 1" annotations="JDK" preserve-order="true">
        <classes> 
            <class name="ExampleParallelTestRunner"/>
        </classes> 
    </test>
</suite> 
```
This XML, is telling the Runner called "ExampleParallelTestRunner" to run the tests in 10 threads

# Key classes explanation   
### We recommend taking a look at the following classes before you start looking at the usage examples

### Summary
_If you want to know more about the use of the following classes, click on the link on your left and you will be redirected to a specific section of it._
| Class               | Description                                                                                                    |
| ------------------- | -------------------------------------------------------------------------------------------------------------- |
| Request             | It´s used to set and get some attributes of the request                                                        |
| Response            | It´s used to set and get some attributes of the response                                                       |
| APIManager          | It´s used to set and get responses of the performed requests                                                   |
| MethodsService      | It´s where HTTP Methods are declared, It´s used to perform requests, and contains some methods for validations |
| Headers             | It´s used to set and get a list of headers                                                                     |
| EntityConfiguration | It´s where entities should be declared, and each declared constant should return a service                     |  


# Gherkin examples using _Codeless steps_ 

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
    };
    
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

<!-- ![Json Examples](docs/images/JsonExamples.png) -->

### Json obtained against json expected modified by some parameters

![Assertion 5, assertion of json obtained against json expected modified by some parameters](docs/images/assertion-5_sample.png)

It uses a override method called "validateFields", in this case, it receives 3 parameters: Object actual, Object jsonExpected, and a list of parameters   
It works in the following way:   

```
usersWithParams.json (note that first_name field contains a variable enclosed between {{}})
    {
        "data": {
            "id": 2,
            "email": "janet.weaver@reqres.in",
            "first_name": "{{name}}",
            "last_name": "Weaver",
            "avatar": "https://reqres.in/img/faces/2-image.jpg"
        }
    }

It´s sended to service class returned by entity defined, where:
UserService class contains:

    @Override
    public void validateFields(Object expected, Object actual, Map<String, String> parameters) throws Exception {
        Map<String, Object> expectedObjectMapped = MapUtils.convertObjectToMap(expected);
        Map<String, String> expectedData = (Map<String, String>) expectedObjectMapped.get("data");
        expectedData.replace("first_name", parameters.get("name"));

        validateFields(expected, actual);
    }

This code is an example of what we must do to make an assertion modifying values ​​of a json with parameters   
** Note that if you don't overwrite the validateFields function, the existing ones in MethodsService will be called by default **
[This overwrite is necessary, if you want to make assertions by modifying an expected json with parameters]
```


### Json obtained against json mapped in the model class

![Assertion 2, assertion of json obtained against json mapped in the model class](docs/images/assertion-2_sample.png)

### Json obtained is null

![Assertion 3, validates that json obtained is null](docs/images/assertion-3_sample.png)

### Json obtained is an empty array

![Assertion 4, validates that json obtained is an empty array](docs/images/assertion-4_sample.png)

<!--
### Codeless Steps / Code explanation
```
~@ignore for now
```

<details><summary>Steps</summary>

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


</details> -->



