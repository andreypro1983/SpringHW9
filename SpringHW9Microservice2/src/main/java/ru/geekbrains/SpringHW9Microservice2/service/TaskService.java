package ru.geekbrains.SpringHW9Microservice2.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.SpringHW9Microservice2.model.Task;
import ru.geekbrains.SpringHW9Microservice2.model.TaskStatus;
import ru.geekbrains.SpringHW9Microservice2.repository.TaskRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class TaskService {
    private final TaskRepository tasksRepository;

    //метод получения всех задач
    public List<Task> getAllTasks() {
        return tasksRepository.findAll();
    }

    //метод добавления новой задачи
    public Task addTask(Task task) {
        return tasksRepository.save(task);
    }

    //метод получения всех задач с определенным статусом
    public List<Task> getTasksByStatus(TaskStatus status) {
        return tasksRepository.findAllByStatus(status);
    }


    //обновление статуса задачи на следующий по очереди
    public Task updateTaskStatus(Long id) {
        Task task = tasksRepository.findById(id).orElse(null);
        if (task != null && !(task.getStatus().equals(TaskStatus.COMPLETED))) {
            task.setStatus(TaskStatus.values()[task.getStatus().ordinal() + 1]);
        }
        return tasksRepository.save(task);
    }

    //удаление задачи
    public void deleteTaskById(Long id) {
        tasksRepository.deleteById(id);
    }
}
