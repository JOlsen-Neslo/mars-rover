# Mars Rover Task
A simple navigation system for rovers that have been sent to Mars.

## Stack
- Java 8
- Maven 3

## Building and Running the application
The application can be built and packaged into a runnable JAR using the following command:

    $ mvn clean install

If you do not want to build and package the application yourself, the source control 
contains an already built JAR file that is runnable.

To run the application you just need to to perform the following command:

    $ java -jar view/target/mars-rover-view-1.0-jar-with-dependencies.jar

## Design Decisions
I followed the MVC design pattern to ensure that all necessary logic is encapsulated into 
its own component, ensuring that each component is responsible for its own behaviour.

This gives me the ability to use each component independently and also gives me the flexibility
to test each component in isolation. Swapping components in and out will not need much refactoring.

## Static Code Analysis
Technologies:

- Checkstyle
- SpotBugs

Checkstyle is a Java linting library that is used to ensure certain coding standards are met. A few examples of 
rules that are checked are - line length does not exceed 100 characters; methods do not exceed more than 30 lines; etc..

To generate the checkstyle report, execute the following command:

    $ mvn compile site

The full set of rules can be seen in the **_checkstyle.xml_** file. 
The result of the report can be opened in your browser from the following location:

**_{module_to_view}/target/site/checkstyle.html_**

SpotBugs is a static analysis tool used to find flawed logic and potential bugs throughout the application.
To generate the checkstyle report, execute the following command:

    $ mvn compile site
    
The result of the report can be opened in your browser from the following location:

**_{module_to_view}/target/site/spotbugs.html_**

## Testing
Technologies:

- JUnit
- Jacoco

JUnit is used as the base of my testing strategy. It will be used to perform unit tests that define system
behaviour. It integrates seamlessly with Maven and multiple mocking and assertion libraries are built ontop
of it for testing Java applications.

Jacoco is a library that scans all unit tested Java code and generates a report stating what percentage of all code
has been covered with a unit test. Jacoco can be leveraged within a Maven build cycle using a simple plugin.
To view the unit test coverage report, run the following command:

    $ mvn clean package 
 _* NOTE (install will work too)_
 
Then you can view of any module in your browser:

**_{module_to_view}/target/site/index.html_**

