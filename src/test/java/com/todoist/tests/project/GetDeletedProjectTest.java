package com.todoist.tests.project;

import com.todoist.dto.request.CreateProjectRequestDto;
import com.todoist.dto.response.CreateProjectResponseDto;
import com.todoist.requests.projects.CreateTodoistProjectRequest;
import com.todoist.requests.projects.DeleteTodoistProjectRequest;
import com.todoist.requests.projects.GetTodoistProjectsRequest;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class GetDeletedProjectTest {

    String projectId;

    @Test
    void shouldGetDeletedElement() {
        CreateProjectRequestDto project = new CreateProjectRequestDto();
        project.setName("Delete Project");

        CreateProjectResponseDto parentResponse = CreateTodoistProjectRequest.createTodoistProjectRequest(project);
        projectId = parentResponse.getId();
        Assertions.assertThat(parentResponse.getName()).isEqualTo("Delete Project");

        Response deleteResponse = DeleteTodoistProjectRequest.deleteTodoistProjectRequest(projectId);
        Assertions.assertThat(deleteResponse.statusCode()).isEqualTo(204);

        // I have contacted the application team, and the behavior described below is correct.
        Response getDeletedProjectResponse = GetTodoistProjectsRequest.getSingleTodoistProjectRequest(projectId);
        Assertions.assertThat(getDeletedProjectResponse.statusCode()).isEqualTo(200);
    }
}
