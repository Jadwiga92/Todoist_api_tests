package com.todoist.tests.project;

import com.todoist.dto.request.CreateProjectRequestDto;
import com.todoist.dto.response.CreateProjectResponseDto;
import com.todoist.requests.projects.CreateTodoistProjectRequest;
import com.todoist.requests.projects.DeleteTodoistProjectRequest;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class DeleteDeletedProjectTest {

    String projectId;

    @Test
    void deleteDeletedProjectTest() {
        CreateProjectRequestDto projectParentDto = new CreateProjectRequestDto();
        projectParentDto.setName("Delete Project");

        CreateProjectResponseDto parentResponse = CreateTodoistProjectRequest.createTodoistProjectRequest(projectParentDto);
        projectId = parentResponse.getId();
        Assertions.assertThat(parentResponse.getName()).isEqualTo("Delete Project");

        Response deleteResponse = DeleteTodoistProjectRequest.deleteTodoistProjectRequest(projectId);
        Assertions.assertThat(deleteResponse.statusCode()).isEqualTo(204);

        //  I have contacted the application team, and the behavior described below is correct.
        Response deleteDeletedResponse = DeleteTodoistProjectRequest.deleteTodoistProjectRequest(projectId);
        Assertions.assertThat(deleteDeletedResponse.statusCode()).isEqualTo(204);
    }
}
