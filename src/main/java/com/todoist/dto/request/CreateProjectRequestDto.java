package com.todoist.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateProjectRequestDto {

    private String name;
    @JsonProperty("parent_id")
    private String parentId;
    private String color;
    @JsonProperty("is_favorite")
    private Boolean isFavorite;
    @JsonProperty("view_style")
    private String viewStyle;
}
