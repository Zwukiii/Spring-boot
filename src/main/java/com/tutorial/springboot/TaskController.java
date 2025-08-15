package com.tutorial.springboot;

import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/tasks")
public class TaskController {

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    private final TaskService taskService;

    @GetMapping
    public List<Tasks> getAllTasks()  {
        return taskService.getAllTasks();
    }

    @GetMapping("{id}")

    public Tasks getAllID(@PathVariable("id") Integer id) {
        return taskService.getTaskById(id).orElseThrow(() -> new RuntimeException("Task not found!"));

    }

    @PostMapping
    public Tasks createdTask(@RequestBody  Tasks task) {
        return taskService.createTask(task);
    }
    @PutMapping("{id}")

    public Tasks updateId(@PathVariable("id") Integer id, @RequestBody Tasks task) {
        return taskService.updateTask(id, task);

    }
    @DeleteMapping("{id}")

    public void deleteTask(@PathVariable("id") Integer id) {
        taskService.deleteTask(id);
    }
}
