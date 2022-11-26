# spring-cloud-config-exception-issue
This project is created as an example of possible spring-cloud-config issue, where we could not override default exception handling for `NoSuchResourceException`.
To get `NoSuchResourceException` and reproduce this issue, you should run the project and make a request to the url where `label`, `application` and `profile` is correct, but filename is not.

Example: GET `{app-url}/scc/developmemt/main/application1.properties`(wrong filename). And then you could see that exception handling for `NoSuchResourceException` in `com.isvyry.example.scc.controller.DefaultControllerAdvice` does not work, because it is being handled in the controller itself. 

To run this project you should clone/downolad it -> build it -> and run with corresponding maven configuration.
