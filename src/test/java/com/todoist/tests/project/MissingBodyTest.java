package com.todoist.tests.project;

import com.todoist.TodoistUrl;
import com.todoist.properties.TodoistProperties;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

class MissingBodyTest {

    @Test
    void shouldReturn400WhenMissingBodyTest() {
        Response response = given()
                .header("Authorization", TodoistProperties.getBearer())
                .contentType(ContentType.JSON)
                .post(TodoistUrl.getProjectsUrl())
                .then()
                .log().ifError()
                .extract()
                .response();

        String responseBody = response.asString();
        Assertions.assertThat(response.statusCode()).isEqualTo(400);
        Assertions.assertThat(responseBody).isEqualTo("Name must be provided for the project creation");
    }
}
