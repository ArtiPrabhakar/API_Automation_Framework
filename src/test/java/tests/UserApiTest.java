package tests;

import base.BaseTest;
import client.ApiClient;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserApiTest extends BaseTest
{

    @Test
    public void verifyGetUsers() {
        Response response = ApiClient.getUsers();
        Assert.AssertEquals(response.getStatusCode(),200);
        Assert.AssertTrue(response.getBody().asString().contains("email"));
    }

    @Test
    public void verifyCreateUser() {
        String payload = "{
        \"name\":\"Arti\",\"job\":\"QA\" }";

        Response response = ApiClient.createUsers(payload);
        Assert.AssertEquals(response.getStatusCode(),201);

        Assert.AssertEquals(response.jsonPath().getString("name"),"Arti");
    }
}