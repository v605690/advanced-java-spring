package com.codingnomads.springweb.resttemplate.PUT.models;

import com.codingnomads.springweb.resttemplate.POST.models.Error;
import com.codingnomads.springweb.resttemplate.POST.models.User;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserResponseObject {
    User data;
    Error error;
    String status;
}
