import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class get_test {
	@Test
	void test1(){
		Response response = get("https://jsonplaceholder.typicode.com/posts/");
		Assert.assertEquals(response.getStatusCode(), 200);
		System.out.println(response.asString());
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusCode());
		System.out.println(response.getTime());
	}
	
	@Test
	void test2() {
		given()
		.get("https://jsonplaceholder.typicode.com/posts/")
		.then()
			.statusCode(200)
			.body("[0].id", equalTo(1));
	}
}
