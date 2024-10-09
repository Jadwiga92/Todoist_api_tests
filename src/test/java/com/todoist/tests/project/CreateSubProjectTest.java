package com.todoist.tests.project;

import com.todoist.dto.request.CreateProjectRequestDto;
import com.todoist.dto.response.CreateProjectResponseDto;
import com.todoist.requests.projects.CreateTodoistProjectRequest;
import com.todoist.requests.projects.DeleteTodoistProjectRequest;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CreateSubProjectTest {

    String projectId;

    @Test
    void shouldCreateSubProjectTest() {
        CreateProjectRequestDto projectParentDto = new CreateProjectRequestDto();
        projectParentDto.setName("Parent Project");

        CreateProjectResponseDto parentResponse = CreateTodoistProjectRequest.createTodoistProjectRequest(projectParentDto);
        projectId = parentResponse.getId();
        Assertions.assertThat(parentResponse.getName()).isEqualTo("Parent Project");

        CreateProjectRequestDto projectChildDto = new CreateProjectRequestDto();
        projectChildDto.setName("Child Project");
        projectChildDto.setParentId(projectId);

        CreateProjectResponseDto childResponse = CreateTodoistProjectRequest.createTodoistProjectRequest(projectChildDto);
        Assertions.assertThat(childResponse.getName()).isEqualTo("Child Project");
        Assertions.assertThat(childResponse.getParentId()).isEqualTo(projectId);

        Response deleteResponse = DeleteTodoistProjectRequest.deleteTodoistProjectRequest(projectId);
        Assertions.assertThat(deleteResponse.statusCode()).isEqualTo(204);
    }
}
