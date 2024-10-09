package com.todoist.tests.project;

import com.todoist.requests.projects.UpdateTodoistProjectRequest;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

class UpdateNotExistingProjectTest {

    String nonExistingProjectId = "2337614989";

    @Test
    void shouldReturn404WhenUpdatingNotExistingProjectTest() {
        JSONObject projectBody = new JSONObject();
        projectBody.put("name", "Updated");

        Response updateResponse = UpdateTodoistProjectRequest.updateTodoistProjectRequest(projectBody, nonExistingProjectId);

        Assertions.assertThat(updateResponse.statusCode()).isEqualTo(404);
        Assertions.assertThat(updateResponse.asString()).isEqualTo("Project not found");
    }
}
