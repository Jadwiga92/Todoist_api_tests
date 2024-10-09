package com.todoist.requests.projects;

import com.todoist.TodoistUrl;
import com.todoist.requests.BaseTodoistRequest;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class GetTodoistProjectsRequest {

    public static Response getAllTodoistProjectsRequest() {
        return given()
                .spec(BaseTodoistRequest.requestSetup())
                .get(TodoistUrl.getProjectsUrl())
                .then()
                .log().ifError()
                .extract()
                .response();
    }

    public static Response getSingleTodoistProjectRequest(String projectId) {
        return given()
                .spec(BaseTodoistRequest.requestSetup())
                .get(TodoistUrl.getProjectUrl(projectId))
                .then()
                .log().ifError()
                .extract()
                .response();
    }
}
