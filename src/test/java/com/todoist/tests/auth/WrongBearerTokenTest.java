package com.todoist.tests.auth;

import com.todoist.TodoistUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

class WrongBearerTokenTest {

    @Test
    void shouldReturn401WhenWrongBearerTokenTest() {
        JSONObject project = new JSONObject();
        project.put("name", "Wrong Bearer Token");

        Response response = given()
                .header("Authorization", "Bearer u8alkjdm4234m028302098skjsdk")
                .contentType(ContentType.JSON)
                .body(project)
                .post(TodoistUrl.getProjectsUrl())
                .then()
                .log().ifError()
                .extract()
                .response();

        Assertions.assertThat(response.statusCode()).isEqualTo(401);
    }
}
