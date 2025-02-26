package mvp.project.taskservice.service;

import mvp.project.taskservice.model.dto.TaskDTO;
import mvp.project.taskservice.model.entity.Task;
import mvp.project.taskservice.model.mapper.TaskMapper;
import mvp.project.taskservice.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class TaskService {
    @Autowired
    TaskRepository taskRepository;

    @Autowired
    private EmailService emailService;

    public TaskDTO createTask(TaskDTO taskDTO) {
        Task task = TaskMapper.MAPPER.taskDTOtoTask(taskDTO);
        int id = Math.toIntExact(taskRepository.save(task).getId());

        String url = "http://localhost:8080/task/" + id;
        String message = "Задача " + url + " создана для вас";
        emailService.sendSimpleEmail(taskDTO.getPerformer().getEmail(),
                "Новая задача " + taskDTO.getName(),
                message);

        return taskDTO;
    }

    public TaskDTO getTaskById(Long id) {
        Task task = taskRepository.findById(id).orElse(null);
        return TaskMapper.MAPPER.taskToTaskDTO(task);
    }

    public List<TaskDTO> getAllTasks() {
        List<Task> tasks = taskRepository.findAll();
        return tasks.stream().map(TaskMapper.MAPPER::taskToTaskDTO).toList();
    }

    public List<TaskDTO> find(Map<String, String> filters) {
        List<Task> tasks = taskRepository.findAll(filters, Task.class).stream().toList();
        return tasks.stream().map(TaskMapper.MAPPER::taskToTaskDTO).toList();
    }
}
