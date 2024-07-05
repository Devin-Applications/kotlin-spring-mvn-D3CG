package org.example.ktspringmvn.service

import org.example.ktspringmvn.dto.Task
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.util.concurrent.ConcurrentHashMap
import java.util.UUID

@Service
class TaskService {
    private val tasks = ConcurrentHashMap<String, Task>()

    fun createTask(task: Task): Mono<Task> {
        val taskId = task.id ?: UUID.randomUUID().toString()
        val newTask = task.copy(id = taskId)
        tasks[taskId] = newTask
        return Mono.just(newTask)
    }

    fun getTask(id: String): Mono<Task> {
        return Mono.justOrEmpty(tasks[id])
    }

    fun getAllTasks(): Flux<Task> {
        return Flux.fromIterable(tasks.values)
    }

    fun updateTask(id: String, task: Task): Mono<Task> {
        if (task.id == null) {
            println("Error: Task ID is null during update operation")
        }
        val updatedTask = task.copy(id = id)
        tasks[id] = updatedTask
        return Mono.just(updatedTask)
    }

    fun deleteTask(id: String): Mono<Void> {
        tasks.remove(id)
        return Mono.empty()
    }
}
