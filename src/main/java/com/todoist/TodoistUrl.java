package com.todoist;

public class TodoistUrl {

    private static final String BASE_URL = "https://api.todoist.com/rest/v2";
    private static final String PROJECTS = "/projects";

    public static String getProjectsUrl() {
        return BASE_URL + PROJECTS;
    }

    public static String getProjectUrl(String projectId) {
        return BASE_URL + PROJECTS + "/" + projectId;
    }
}
