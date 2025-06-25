package com.codingnomads.springweb.resttemplate.DELETE.models;

import com.codingnomads.springweb.resttemplate.POST.models.Error;
import com.codingnomads.springweb.resttemplate.POST.models.User;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UsrResObj {
    MyUser data;
    Error error;
    String status;
}
