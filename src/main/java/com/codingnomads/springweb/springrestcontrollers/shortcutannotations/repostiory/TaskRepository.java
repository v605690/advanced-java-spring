/* CodingNomads (C)2024 */
package com.codingnomads.springweb.springrestcontrollers.shortcutannotations.repostiory;

import com.codingnomads.springweb.springrestcontrollers.shortcutannotations.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> id(Long id);

    List<Task> getTasksByCompleted(Boolean completed);

    List<Task> getTasksByName(String name);
}
