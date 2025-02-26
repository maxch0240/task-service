package mvp.project.taskservice.controller;

import mvp.project.taskservice.model.dto.TaskDTO;
import mvp.project.taskservice.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/task/")
public class TaskController {
    @Autowired
    TaskService taskService;

    @PostMapping("/create")
    public TaskDTO createTask(@RequestBody @Validated TaskDTO taskDTO) {
        return taskService.createTask(taskDTO);
    }

    @GetMapping("/{id}")
    public TaskDTO getTask(@PathVariable Long id) {
        return taskService.getTaskById(id);
    }

    @GetMapping("/all")
    public List<TaskDTO> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/find")
    public List<TaskDTO> findTasks(@RequestParam Map<String, String> requestParams) {
        return taskService.find(requestParams);
    }
}
