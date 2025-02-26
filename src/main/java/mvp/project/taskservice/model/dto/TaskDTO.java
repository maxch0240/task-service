package mvp.project.taskservice.model.dto;

import app.tozzi.annotation.Searchable;
import lombok.*;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskDTO {
    private Long id;
    private UserDTO performer;
    @Searchable
    private String name;
    @Searchable
    private Instant startTime;
    @Searchable
    private Instant deadlineTime;
    @Searchable
    private String status;
    @Searchable
    private String taskType;
}