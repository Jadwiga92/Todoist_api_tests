package com.todoist.tests.project;

import com.todoist.dto.request.CreateProjectRequestDto;
import com.todoist.dto.response.CreateProjectResponseDto;
import com.todoist.requests.projects.CreateTodoistProjectRequest;
import com.todoist.requests.projects.DeleteTodoistProjectRequest;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class CreateTodoistProjectOnlyWithNameTest {

    private static String projectId;

    @ParameterizedTest(name = "Create project with projectName: {0}")
    @MethodSource("createProjectData")
    void shouldCreateTodoistProjectWithVariousProjectNamesTest(String projectName) {
        CreateProjectRequestDto projectDto = new CreateProjectRequestDto();
        projectDto.setName(projectName);

        CreateProjectResponseDto response = CreateTodoistProjectRequest.createTodoistProjectRequest(projectDto);

        Assertions.assertThat(response.getIsShared()).isEqualTo(false);
        Assertions.assertThat(response.getIsFavorite()).isEqualTo(false);
        Assertions.assertThat(response.getName()).isEqualTo(projectName);
        projectId = response.getId();

        Response deleteResponse = DeleteTodoistProjectRequest.deleteTodoistProjectRequest(projectId);
        Assertions.assertThat(deleteResponse.statusCode()).isEqualTo(204);
    }

    private static Stream<Arguments> createProjectData() {
        return Stream.of(
                Arguments.of("Some Long Project Name Here"),
                Arguments.of("2345324"),
                Arguments.of("@"),
                Arguments.of("0"),
                Arguments.of("+"),
                Arguments.of("project Name")
        );
    }
}
