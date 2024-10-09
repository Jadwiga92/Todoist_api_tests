package com.todoist.tests.project;

import com.todoist.dto.request.CreateProjectRequestDto;
import com.todoist.dto.response.CreateProjectResponseDto;
import com.todoist.requests.projects.CreateTodoistProjectRequest;
import com.todoist.requests.projects.DeleteTodoistProjectRequest;
import com.todoist.requests.projects.GetTodoistProjectsRequest;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class GetSingleProjectTest {

    String projectId;

    @Test
    void shouldGetSingleProjectTest() {
        CreateProjectRequestDto projectDto = new CreateProjectRequestDto();
        projectDto.setName("Single Project");

        CreateProjectResponseDto response = CreateTodoistProjectRequest.createTodoistProjectRequest(projectDto);

        Assertions.assertThat(response.getIsShared()).isEqualTo(false);
        Assertions.assertThat(response.getIsFavorite()).isEqualTo(false);
        Assertions.assertThat(response.getName()).isEqualTo("Single Project");
        projectId = response.getId();

        Response getSingleProjectsResponse = GetTodoistProjectsRequest.getSingleTodoistProjectRequest(projectId);

        JsonPath json = getSingleProjectsResponse.jsonPath();
        Assertions.assertThat(json.getString("id")).isEqualTo(projectId);

        Response deleteResponse = DeleteTodoistProjectRequest.deleteTodoistProjectRequest(projectId);
        Assertions.assertThat(deleteResponse.statusCode()).isEqualTo(204);
    }
}
