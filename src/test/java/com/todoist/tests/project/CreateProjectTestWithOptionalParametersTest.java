package com.todoist.tests.project;

import com.todoist.dto.request.CreateProjectRequestDto;
import com.todoist.dto.response.CreateProjectResponseDto;
import com.todoist.requests.projects.CreateTodoistProjectRequest;
import com.todoist.requests.projects.DeleteTodoistProjectRequest;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CreateProjectTestWithOptionalParametersTest {

    String projectId;

    @Test
    void shouldCreateTodoistProjectwithOptionalParametersTest() {
        CreateProjectRequestDto projectDto = new CreateProjectRequestDto();
        projectDto.setName("Optional parameters");
        projectDto.setColor("berry_red");
        projectDto.setIsFavorite(true);
        projectDto.setViewStyle("board");

        CreateProjectResponseDto response = CreateTodoistProjectRequest.createTodoistProjectRequest(projectDto);
        projectId = response.getId();

        Assertions.assertThat(response.getName()).isEqualTo("Optional parameters");
        Assertions.assertThat(response.getIsFavorite()).isEqualTo(true);
        Assertions.assertThat(response.getColor()).isEqualTo("berry_red");
        Assertions.assertThat(response.getViewStyle()).isEqualTo("board");

        Response deleteResponse = DeleteTodoistProjectRequest.deleteTodoistProjectRequest(projectId);
        Assertions.assertThat(deleteResponse.statusCode()).isEqualTo(204);
    }
}
