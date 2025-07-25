/* CodingNomads (C)2024 */
package com.codingnomads.springweb.springrestcontrollers.shortcutannotations.controller;

import com.codingnomads.springweb.springrestcontrollers.shortcutannotations.model.Task;
import com.codingnomads.springweb.springrestcontrollers.shortcutannotations.repostiory.TaskRepository;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    TaskRepository taskRepository;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Task> createNewTask(@RequestBody Task task) throws URISyntaxException {

        if (StringUtils.isEmpty(task.getName()) || task.getId() != null) {
            throw new IllegalStateException();
        }
        final Task savedTask = taskRepository.save(task);

        return ResponseEntity.created(new URI("/api/tasks/" + savedTask.getId()))
                .body(savedTask);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(
            @PathVariable long id,
            @RequestBody Task task)
            // @RequestParam(required = false, defaultValue = "false") String completed)
            throws URISyntaxException {
        Task updateTask = taskRepository.findById(id).orElseThrow();

        updateTask.setName(task.getName());
        updateTask.setCompleted(task.getCompleted());

        final Task saveTask = taskRepository.save(updateTask);
        return ResponseEntity.ok(saveTask);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Task> getTask(@PathVariable Long id) {

        Optional<Task> taskToReturn = taskRepository.findById(id);

        if (taskToReturn.isPresent()) {
            return ResponseEntity.ok().body(taskToReturn.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteTask(@PathVariable Long id) {
        if (id == null || !taskRepository.existsById(id)) {
            throw new IllegalStateException();
        }
        taskRepository.deleteById(id);
        return ResponseEntity.ok().body(id);
    }
}
