/* CodingNomads (C)2024 */
package com.codingnomads.springweb.gettingdatafromclient.pathvariable.controllers;

import com.codingnomads.springweb.gettingdatafromclient.pathvariable.models.Task;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
public class TaskController {

    @GetMapping(value = "/{id}/{name}/{completed}")
    public Task getTask(
            @PathVariable(name = "id") Long id,
            @PathVariable(name = "name") String name,
            @PathVariable(name = "completed") Boolean completed) {

        return Task.builder().id(id).name(name).completed(completed).build();
    }

    @GetMapping(value = "/{name}")
    public String getTask (
            @PathVariable(name = "name") String name) {

                return name;
    }

    @GetMapping(value = {"/path-variable-optional", "/path-variable-optional/{name}"})
    public String pathVariableOptional(@PathVariable(required = false) String name) {
        if (!StringUtils.isEmpty(name)) {
            return "Path Variable value:" + name;
        } else {
            return "Path Variable Value : Not Provided";
        }
    }

    @GetMapping(value = "/with-map/{id}/{name}/{completed}")
    public Task getTask(@PathVariable Map<String, String> pathVariableMaps) {
        return Task.builder()
                .id(Long.valueOf(pathVariableMaps.get("id")))
                .name(pathVariableMaps.get("name"))
                .completed(Boolean.parseBoolean(pathVariableMaps.get("completed")))
                .build();
    }

    @GetMapping(value = "/request-param-encoded", produces = MediaType.APPLICATION_JSON_VALUE)
    public String requestParamEncoded(@RequestParam String name) {
        return name;
    }

    @GetMapping(value = "/path-variable-not-encoded/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String pathVariableIsNotEncoded(@PathVariable String name) {
        return name;
    }

    @GetMapping(value = "/products/{name}")
    public String getProduct(@PathVariable String name) {
        return name;
    }

    @GetMapping("/employees/{id}/{name}")
    public String getEmployeeByIdAndName(@PathVariable String id, @PathVariable String name) {
        return "ID: " + id + ", name: " + name;
    }

}
