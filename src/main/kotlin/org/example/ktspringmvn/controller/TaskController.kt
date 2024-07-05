package org.example.ktspringmvn.controller

import org.example.ktspringmvn.dto.Task
import org.example.ktspringmvn.service.TaskService
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import org.slf4j.LoggerFactory

@RestController
@RequestMapping("/tasks")
class TaskController(private val taskService: TaskService) {

    private val logger = LoggerFactory.getLogger(TaskController::class.java)

    @PostMapping
    fun createTask(@RequestBody task: Task): Mono<Task> {
        logger.info("Received request to create task: $task")
        return taskService.createTask(task)
            .doOnSuccess { createdTask -> logger.info("Successfully created task: $createdTask") }
            .doOnError { error -> logger.error("Error creating task: ${error.message}", error) }
    }

    @GetMapping("/{id}")
    fun getTask(@PathVariable id: String): Mono<Task> {
        logger.info("Received request to get task with id: $id")
        return taskService.getTask(id)
            .doOnSuccess { task -> logger.info("Successfully retrieved task: $task") }
            .doOnError { error -> logger.error("Error retrieving task: ${error.message}", error) }
    }

    @GetMapping
    fun getAllTasks(): Flux<Task> {
        logger.info("Received request to get all tasks")
        return taskService.getAllTasks()
            .doOnComplete { logger.info("Successfully retrieved all tasks") }
            .doOnError { error -> logger.error("Error retrieving all tasks: ${error.message}", error) }
    }

    @PutMapping("/{id}")
    fun updateTask(@PathVariable id: String, @RequestBody task: Task): Mono<Task> {
        logger.info("Received request to update task with id: $id, task: $task")
        return taskService.updateTask(id, task)
            .doOnSuccess { updatedTask -> logger.info("Successfully updated task: $updatedTask") }
            .doOnError { error -> logger.error("Error updating task: ${error.message}", error) }
    }

    @DeleteMapping("/{id}")
    fun deleteTask(@PathVariable id: String): Mono<Void> {
        logger.info("Received request to delete task with id: $id")
        return taskService.deleteTask(id)
            .doOnSuccess { logger.info("Successfully deleted task with id: $id") }
            .doOnError { error -> logger.error("Error deleting task: ${error.message}", error) }
    }
}
