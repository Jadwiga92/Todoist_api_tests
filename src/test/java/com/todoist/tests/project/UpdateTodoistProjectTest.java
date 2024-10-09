package com.todoist.tests.project;

import com.todoist.dto.request.CreateProjectRequestDto;
import com.todoist.dto.request.UpdateProjectRequestDto;
import com.todoist.dto.response.CreateProjectResponseDto;
import com.todoist.dto.response.UpdateProjectResponseDto;
import com.todoist.requests.projects.CreateTodoistProjectRequest;
import com.todoist.requests.projects.DeleteTodoistProjectRequest;
import com.todoist.requests.projects.UpdateTodoistProjectRequest;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class UpdateTodoistProjectTest {

    private static String projectId;

    @Test
    void shouldUpdateTodoistProjectTest() {
        CreateProjectRequestDto projectDto = new CreateProjectRequestDto();
        projectDto.setName("Shopping List");

        CreateProjectResponseDto response = CreateTodoistProjectRequest.createTodoistProjectRequest(projectDto);
        Assertions.assertThat(response.getName()).isEqualTo("Shopping List");
        projectId = response.getId();

        UpdateProjectRequestDto updatedProjectDto = new UpdateProjectRequestDto();
        updatedProjectDto.setName("Updated Shopping List");

        UpdateProjectResponseDto updateResponse = UpdateTodoistProjectRequest.updateTodoistProjectRequestDto(updatedProjectDto, projectId);
        Assertions.assertThat(updateResponse.getName()).isEqualTo("Updated Shopping List");

        Response deleteResponse = DeleteTodoistProjectRequest.deleteTodoistProjectRequest(projectId);
        Assertions.assertThat(deleteResponse.statusCode()).isEqualTo(204);
    }
}
