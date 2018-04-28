package com.luzon.todo.application.todo

import com.luzon.todo.domain.todo.ITodoRepository
import com.luzon.todo.domain.todo.Todo
import com.luzon.todo.domain.todo.TodoId
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
    fun findByLastName(@PathVariable id: TodoId) : Optional<Todo> = repository.findById(id)

    @PatchMapping("/{id}/done")
    fun done(@PathVariable id: TodoId) : Optional<Todo> {
        val todo = repository.findById(id)
        todo.map({ todo -> todo.done()})
        return todo
    }
}