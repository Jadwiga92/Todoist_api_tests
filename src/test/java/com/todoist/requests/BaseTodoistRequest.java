package com.todoist.requests;

import com.todoist.properties.TodoistProperties;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class BaseTodoistRequest {

    public static RequestSpecBuilder requestBuilder;

    public static RequestSpecification requestSetup() {
        requestBuilder = new RequestSpecBuilder();
        requestBuilder.addHeader("Authorization", TodoistProperties.getBearer());
        requestBuilder.setContentType(ContentType.JSON);
        requestBuilder.addFilter(new RequestLoggingFilter());
        requestBuilder.addFilter(new ResponseLoggingFilter());
        return requestBuilder.build();
    }
}
