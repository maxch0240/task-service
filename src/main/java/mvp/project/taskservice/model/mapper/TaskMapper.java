package mvp.project.taskservice.model.mapper;

import mvp.project.taskservice.model.dto.TaskDTO;
import mvp.project.taskservice.model.dto.UserDTO;
import mvp.project.taskservice.model.entity.Task;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.time.Instant;

@Mapper
public interface TaskMapper {
    TaskMapper MAPPER = Mappers.getMapper(TaskMapper.class);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "performer", target = "performer")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "startTime", target = "startTime")
    @Mapping(source = "deadlineTime", target = "deadlineTime")
    @Mapping(source = "status", target = "status")
    @Mapping(source = "taskType", target = "taskType")
    TaskDTO taskToTaskDTO(Task task);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "performer", target = "performer")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "startTime", target = "startTime")
    @Mapping(source = "deadlineTime", target = "deadlineTime")
    @Mapping(source = "status", target = "status")
    @Mapping(source = "taskType", target = "taskType")
    Task taskDTOtoTask(TaskDTO taskDTO);
}
