package client;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class ApiClient {
  
  public static Response getUsers() {
    return given.when().get("/api/users?page=2");
  }

   public static Response createUsers(String body) {
    return given.header("Content-Type","application/json").body(body).when().post("/api/users");
  }
  
}
