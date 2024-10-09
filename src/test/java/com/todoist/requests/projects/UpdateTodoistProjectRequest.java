package com.todoist.requests.projects;

import com.todoist.TodoistUrl;
import com.todoist.dto.request.UpdateProjectRequestDto;
import com.todoist.dto.response.UpdateProjectResponseDto;
import com.todoist.requests.BaseTodoistRequest;
import io.restassured.response.Response;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;

public class UpdateTodoistProjectRequest {

    public static UpdateProjectResponseDto updateTodoistProjectRequestDto(UpdateProjectRequestDto projectDto, String projectId) {
        return given()
                .spec(BaseTodoistRequest.requestSetup())
                .body(projectDto)
                .post(TodoistUrl.getProjectUrl(projectId))
                .then()
                .log().ifError()
                .statusCode(200)
                .extract()
                .response()
                .as(UpdateProjectResponseDto.class);
    }

    public static Response updateTodoistProjectRequest(JSONObject projectBody, String projectId) {
        return given()
                .spec(BaseTodoistRequest.requestSetup())
                .body(projectBody.toString())
                .post(TodoistUrl.getProjectUrl(projectId))
                .then()
                .log().ifError()
                .extract()
                .response();
    }
}
