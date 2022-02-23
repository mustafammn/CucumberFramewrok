package API;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class HardCodedExamples {

    @Test
    public void sampleTest(){
        //storing the base uri to use further
        String baseURI = RestAssured.baseURI = "http://hrm.syntaxtechs.net/syntaxapi/api";

        //preparing the request to get an employee
        RequestSpecification preparedRequest = given().header("Content-Type", "application/json").
                header("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2NDU1ODI0MjQsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTY0NTYyNTYyNCwidXNlcklkIjoiMzQzOSJ9.vyeIpbEczolUfYyQx6eYGBH4BncHAArZMVFeE_WjUIc").
                queryParam("employee_id","26579A");

        Response response = preparedRequest.when().get("/getOneEmployee.php");
        System.out.println(response.asString());

        response.then().assertThat().statusCode(200);

    }

}