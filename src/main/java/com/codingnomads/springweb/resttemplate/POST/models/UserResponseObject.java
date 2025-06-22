package com.codingnomads.springweb.resttemplate.POST.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserResponseObject {
    User data;
    Error error;
    String status;
}
