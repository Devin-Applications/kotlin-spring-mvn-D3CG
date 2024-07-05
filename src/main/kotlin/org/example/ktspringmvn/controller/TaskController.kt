package org.example.ktspringmvn.controller

import org.example.ktspringmvn.dto.Task
import org.example.ktspringmvn.service.TaskService
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/tasks")
class TaskController(private val taskService: TaskService) {

    @PostMapping
    fun createTask(@RequestBody task: Task): Mono<Task> {
        return taskService.createTask(task)
    }

    @GetMapping("/{id}")
    fun getTask(@PathVariable id: String): Mono<Task> {
        return taskService.getTask(id)
    }

    @GetMapping
    fun getAllTasks(): Flux<Task> {
        return taskService.getAllTasks()
    }

    @PutMapping("/{id}")
    fun updateTask(@PathVariable id: String, @RequestBody task: Task): Mono<Task> {
        return taskService.updateTask(id, task)
    }

    @DeleteMapping("/{id}")
    fun deleteTask(@PathVariable id: String): Mono<Void> {
        return taskService.deleteTask(id)
    }
}
