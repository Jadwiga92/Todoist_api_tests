package com.todoist.requests.projects;

import com.todoist.TodoistUrl;
import com.todoist.dto.request.CreateProjectRequestDto;
import com.todoist.dto.response.CreateProjectResponseDto;
import com.todoist.requests.BaseTodoistRequest;

import static io.restassured.RestAssured.given;

public class CreateTodoistProjectRequest {

    public static CreateProjectResponseDto createTodoistProjectRequest(CreateProjectRequestDto project) {
        return given()
                .spec(BaseTodoistRequest.requestSetup())
                .body(project)
                .post(TodoistUrl.getProjectsUrl())
                .then()
                .log().ifError()
                .statusCode(200)
                .extract()
                .response()
                .as(CreateProjectResponseDto.class);
    }
}
