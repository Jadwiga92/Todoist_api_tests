package com.todoist.tests.project;

import com.todoist.dto.request.CreateProjectRequestDto;
import com.todoist.dto.response.CreateProjectResponseDto;
import com.todoist.requests.projects.CreateTodoistProjectRequest;
import com.todoist.requests.projects.DeleteTodoistProjectRequest;
import com.todoist.requests.projects.GetTodoistProjectsRequest;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class GetAllProjectsTest {

    private static String projectId;

    @Test
    void shouldGetAllProjectsTest() {
        CreateProjectRequestDto projectDto = new CreateProjectRequestDto();
        projectDto.setName("Duties");

        CreateProjectResponseDto response = CreateTodoistProjectRequest.createTodoistProjectRequest(projectDto);
        Assertions.assertThat(response.getName()).isEqualTo("Duties");
        projectId = response.getId();

        Response getAllProjectsResponse = GetTodoistProjectsRequest.getAllTodoistProjectsRequest();
        Assertions.assertThat(getAllProjectsResponse.statusCode()).isEqualTo(200);

        List<String> projectNames = getAllProjectsResponse.jsonPath().getList("name");
        Assertions.assertThat(projectNames).isNotEmpty();

        Response deleteResponse = DeleteTodoistProjectRequest.deleteTodoistProjectRequest(projectId);
        Assertions.assertThat(deleteResponse.statusCode()).isEqualTo(204);
    }
}
