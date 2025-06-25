package com.codingnomads.springweb.resttemplate.PATCH.models;

import com.codingnomads.springweb.resttemplate.POST.models.Error;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UsrResObj {
    NwUser data;
    Error error;
    String status;
}
