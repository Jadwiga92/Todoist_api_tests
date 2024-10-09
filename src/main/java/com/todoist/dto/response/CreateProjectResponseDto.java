package com.todoist.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
public class CreateProjectResponseDto {

    private String id;
    private String name;
    private String color;
    @JsonProperty("view_style")
    private String viewStyle;
    @JsonProperty("is_shared")
    private Boolean isShared;
    @JsonProperty("is_favorite")
    private Boolean isFavorite;
    @JsonProperty("parent_id")
    private String parentId;
}
