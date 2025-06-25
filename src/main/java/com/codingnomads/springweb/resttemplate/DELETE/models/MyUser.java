package com.codingnomads.springweb.resttemplate.DELETE.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MyUser {
    private long id;
    private String email;
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("last_name")
    private String lastName;
    private long createdAt;
    private long updatedAt;
}
