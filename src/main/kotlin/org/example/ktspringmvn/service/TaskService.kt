package org.example.ktspringmvn.service

import org.example.ktspringmvn.dto.Task
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.util.concurrent.ConcurrentHashMap

@Service
class TaskService {
    private val tasks = ConcurrentHashMap<String, Task>()

    fun createTask(task: Task): Mono<Task> {
        tasks[task.id] = task
        return Mono.just(task)
    }

    fun getTask(id: String): Mono<Task> {
        return Mono.justOrEmpty(tasks[id])
    }

    fun getAllTasks(): Flux<Task> {
        return Flux.fromIterable(tasks.values)
    }

    fun updateTask(id: String, task: Task): Mono<Task> {
        tasks[id] = task
        return Mono.just(task)
    }

    fun deleteTask(id: String): Mono<Void> {
        tasks.remove(id)
        return Mono.empty()
    }
}
