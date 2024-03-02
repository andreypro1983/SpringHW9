package ru.geekbrains.SpringHW9Microservice2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.SpringHW9Microservice2.model.Task;
import ru.geekbrains.SpringHW9Microservice2.model.TaskStatus;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findAllByStatus(TaskStatus status);

}