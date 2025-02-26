package mvp.project.taskservice.model.entity;

import app.tozzi.annotation.Searchable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "tasks", schema = "task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id", nullable = false)
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "performer_id", nullable = false)
    private User performer;

    @Searchable
    @Size(max = 256)
    @NotNull
    @Column(name = "name", nullable = false, length = 256)
    private String name;

    @Searchable
    @NotNull
    @Column(name = "start_time", nullable = false)
    private Instant startTime;

    @Searchable
    @NotNull
    @Column(name = "deadline_time", nullable = false)
    private Instant deadlineTime;

    @Searchable
    @Size(max = 256)
    @NotNull
    @Column(name = "status", nullable = false, length = 256)
    private String status;

    @Searchable
    @Size(max = 256)
    @NotNull
    @Column(name = "task_type", nullable = false, length = 256)
    private String taskType;

}