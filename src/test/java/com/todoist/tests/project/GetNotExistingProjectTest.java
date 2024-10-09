package com.todoist.tests.project;

import com.todoist.requests.projects.GetTodoistProjectsRequest;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class GetNotExistingProjectTest {

    String tooLongProjectId = "258761937494872";
    String properLengthProjectId = "2337613958";
    String tooShortProjectId = "2337613";

    @Test
    void shouldGetStatus400WhenNonExistingTooLongProjectNameTest() {
        Response response = GetTodoistProjectsRequest.getSingleTodoistProjectRequest(tooLongProjectId);
        Assertions.assertThat(response.statusCode()).isEqualTo(400);
        Assertions.assertThat(response.getBody().asString()).isEqualTo("Invalid argument value");
    }

    @Test
    void shouldGetStatus404WhenNonExistingProperSizeProjectNameTest() {
        Response response = GetTodoistProjectsRequest.getSingleTodoistProjectRequest(properLengthProjectId);
        Assertions.assertThat(response.statusCode()).isEqualTo(404);
        Assertions.assertThat(response.getBody().asString()).isEqualTo("Project not found");
    }

    @Test
    void shouldGetStatus404WhenNonExistingTooShortProjectNameTest() {
        Response response = GetTodoistProjectsRequest.getSingleTodoistProjectRequest(tooShortProjectId);
        Assertions.assertThat(response.statusCode()).isEqualTo(404);
        Assertions.assertThat(response.getBody().asString()).isEqualTo("Project not found");
    }
}
