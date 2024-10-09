package com.todoist.requests.projects;

import com.todoist.TodoistUrl;
import com.todoist.requests.BaseTodoistRequest;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class DeleteTodoistProjectRequest {

    public static Response deleteTodoistProjectRequest(String projectId) {
        return given()
                .spec(BaseTodoistRequest.requestSetup())
                .delete(TodoistUrl.getProjectUrl(projectId))
                .then()
                .log().ifError()
                .extract()
                .response();
    }
}
