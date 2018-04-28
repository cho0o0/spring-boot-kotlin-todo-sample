package com.luzon.todo.application.todo

import com.luzon.todo.domain.todo.ITodoRepository
import com.luzon.todo.domain.todo.Todo
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/todos")
class CustomerController(private val repository: ITodoRepository) {

    @PostMapping("/")
    fun create(@RequestBody todo: Todo): Todo = repository.save(todo)

    @GetMapping("/")
    fun findAll(): List<Todo> = repository.findAll()

    @GetMapping("/{id}")
    fun findByLastName(@PathVariable id:Long) : Optional<Todo> = repository.findById(id)
}