package RestAssured_GetMethod;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetMethod extends ExtentReport{

	
	@BeforeClass

	public void setup() {
		CreateReport();

	}

	@Test(priority = 1, enabled = true)
	public void test1_getResponse() {

		System.out.println("\ntest1_getResponse test is started\n");
		logger = report.startTest("test1_getResponse");
		logger.log(LogStatus.INFO, "test1_getResponse test is started");
		Response res = RestAssured.given().get("https://jsonplaceholder.typicode.com/posts");

	    //Get the response
		System.out.println("\nResponse =" + res.asString());
		
		//Asserting the statusCode as 200 for Get method
		int statusCode = res.getStatusCode();
		System.out.println("StatusCode= " + statusCode);
		Assert.assertEquals(statusCode, 200);
		
		logger.log(LogStatus.INFO, "statusCode " + statusCode + " is displayed");
		logger.log(LogStatus.INFO, "Response is displayed");
		logger.log(LogStatus.PASS, "test1_getResponse test is passed");
		System.out.println("test1_getResponse test is completed");
	}

	@Test(priority = 2, enabled = true)
	public void test2_InvalidMethod() {

		System.out.println("\ntest2_InvalidMethod test is started\n");
		logger = report.startTest("test2_InvalidMethod");
		logger.log(LogStatus.INFO, "test2_InvalidMethod test is started");
		Response res = RestAssured.given().header("Content-Type","application/json").put("https://jsonplaceholder.typicode.com/posts");
		
		//Asserting the statusCode 
		int statusCode = res.getStatusCode();
		System.out.println("StatusCode= " + statusCode);
		Assert.assertNotEquals(statusCode, 200);
		
		logger.log(LogStatus.INFO, "statusCode " + statusCode + " is displayed");
		logger.log(LogStatus.PASS, "test2_InvalidMethod test is passed");

		System.out.println("test2_InvalidMethod test is completed");
	}

	@Test(priority = 3, enabled = true)
	public void test3_Invalid_Endpoint() {

		System.out.println("\ntest3_Invalid_Endpoint test is started\n");
		logger = report.startTest("test3_Invalid_Endpoint");
		logger.log(LogStatus.INFO, "test3_Invalid_Endpoint test is started");
		Response res = RestAssured.given().header("Content-Type","application/json").get("https://jsonplaceholder.typicode.com/post");
		
		//Asserting the statusCode 
		int statusCode = res.getStatusCode();
		System.out.println("StatusCode= " + statusCode);
		Assert.assertNotEquals(statusCode, 200);
		
		logger.log(LogStatus.INFO, "statusCode " + statusCode + " is displayed");
		logger.log(LogStatus.PASS, "test3_Invalid_Endpoint test is passed");
		
		System.out.println("test3_Invalid_Endpoint test is completed");
	}

	@Test(priority = 4, enabled = true)
	public void test4_Invalid_URL() {

		System.out.println("\ntest4_Invalid_URL test is started\n");
		logger = report.startTest("test4_Invalid_URL");
		logger.log(LogStatus.INFO, "test4_Invalid_URL test is started");
		Response res = RestAssured.get("https://jsonplaceholder.typicode.com//posts");
		
		//Asserting the statusCode 
		int statusCode = res.getStatusCode();
		System.out.println("StatusCode= " + statusCode);
		Assert.assertTrue(statusCode != 200);
		
		logger.log(LogStatus.INFO, "statusCode " + statusCode + " is displayed");
		logger.log(LogStatus.PASS, "test4_Invalid_URL test is passed");

		System.out.println("test4_No_URL test is completed");
	}

	@AfterClass

	public void TearDown() {

		CloseReport();
	}

}
