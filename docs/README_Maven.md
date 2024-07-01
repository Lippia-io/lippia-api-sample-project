# System Requirements:
+ JDK: https://docs.oracle.com/en/java/javase/index.html 
+ Maven: https://maven.apache.org/download.cgi 
+ Git client: https://www.atlassian.com/git/tutorials/install-git 

# Getting started

## Running with Maven

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
   + Additionally, other options are available for running the tests, as outlined in the following table:
    ```
        * -D is used to define system properties or command-line properties, which Maven will utilize during the project's building and/or execution process.
        * Using -P followed by the profile name allows Maven to apply the configurations associated with that specific profile during the project's build process.
        * -Pparallel: indicates the profile that enables the opening of multiple execution threads.
        


           |                                  Command                                  |                     Description                       |
           |---------------------------------------------------------------------------|-------------------------------------------------------|
           | clean test -DforkCount=0                                                  | In case you need to debug, for use in the IDE runner  |
           | mvn clean test -DforkCount=0 "-Dcucumber.tags=@Smoke"                     | specifying a tag and including the debug option       |
           | mvn clean test -PSecuencial -Plocal                                       | Multiple profiles enabled                             |
           | mvn clean test -PParalelo "-Dcucumber.tags='@Accounts and @Regression'"   | Multiple tags and profiles enabled                    |

  ```

### How to select Sequential or Parallel Runner:

**Sequential Runner:**

- In the pom.xml file, it looks for the POM in the current directory and assign the value of "testngSecuencial.xml".

- This would be as follows:
```  
        <runner>testngSecuencial.xml</runner>
```         

**Parallel Runner:**

- In the pom.xml file, it looks for the POM in the current directory and assign the value of "testingParalel.xml"

- This would be as follows:
```
        <runner>testngParallel.xml</runner>
```        
### How to avoid data concurrency:

- In our Lippia core we have a class called **MyThreadLocal** which allows us to save variables in independent threads for each execution. This functionality provides us with the solution to data concurrency in parallel executions.

Use the setData() method to save our variables:
```
MyThreadLocal.setData(key, value)
```
Use the getData() method to obtain the value of our variable saved in our thread:
```
MyThreadLocal.getData(key)
``` 

