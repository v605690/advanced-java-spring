/* CodingNomads (C)2024 */
package com.codingnomads.springweb.gettingdatafromclient.requestparam.controllers;

import com.codingnomads.springweb.gettingdatafromclient.requestparam.models.Task;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
public class TaskController {

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public String getTask(@RequestParam Long id) {
        return "ID: " + id;
    }

    @GetMapping(value = "/param-name-variable-name-different", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getTaskWithDifferentParamAndVariableName(@RequestParam(name = "id") Long taskId) {
        return "ID: " + taskId;
    }

    @GetMapping(value = "/custom-name-path", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getTaskWithCustomNamePath(@RequestParam(name = "name") String name) {
        return "NAME: " + name;
    }

    @GetMapping(value = "/custom-variable-path", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getTaskWithCustomVariablePath1(@RequestParam(name = "id") Long taskId) {
        return "ID: " + taskId;
    }

    @GetMapping(value = "/request-param-optional", produces = MediaType.APPLICATION_JSON_VALUE)
    public Task getTaskWithOptionalRequestPram(@RequestParam(name = "id", required = false) Long taskId) {
        if (taskId != null) {
            return Task.builder().id(taskId).name("Task One").build();
        } else return Task.builder().name("Task One").build();
    }

    @GetMapping(value = "/default-request-param-value", produces = MediaType.APPLICATION_JSON_VALUE)
    public Task getTaskWithDefaultRequestParam(
            @RequestParam(name = "name", required = false, defaultValue = "Task One") String taskName) {
        return Task.builder().name(taskName).build();
    }

    @GetMapping(value = "/custom-param-path", produces = MediaType.APPLICATION_JSON_VALUE)
    public Task getTaskWithCustomParamPath(
            @RequestParam(name = "name", required = false, defaultValue = "Custom Path One") String taskName) {
        return Task.builder().name(taskName).build();
    }


    @GetMapping(value = "/request-parameter-with-multiple-values", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Task> getTasksWithNamesRequestParam(@RequestParam(name = "names") List<String> names) {
        return IntStream.range(0, names.size())
                .mapToObj(i -> Task.builder().id((long) i).name(names.get(i)).build())
                .collect(Collectors.toList());
    }
}
