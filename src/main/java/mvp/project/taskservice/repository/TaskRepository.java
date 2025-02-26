package mvp.project.taskservice.repository;

import app.tozzi.repository.JPASearchRepository;
import mvp.project.taskservice.model.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long>, JPASearchRepository<Task> {
}
