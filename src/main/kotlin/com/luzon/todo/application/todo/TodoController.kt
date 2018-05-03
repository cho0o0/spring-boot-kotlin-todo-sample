package com.luzon.todo.application.todo

import com.luzon.todo.domain.todo.Todo
import com.luzon.todo.domain.todo.TodoId
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/todos")
class CustomerController(private val todoAppService: TodoAppService) {

    @PostMapping("/")
    fun create(@RequestBody todoDto: TodoDTO): TodoDTO = todoAppService.create(todoDto)

    @GetMapping("/")
    fun findAll(): List<TodoDTO> = todoAppService.findAllTodos()

    @GetMapping("/{id}")
    fun findById(@PathVariable id: TodoId) : TodoDTO? = todoAppService.findByTodoId(id)

    @PatchMapping("/{id}/done")
    fun done(@PathVariable id: TodoId) : TodoDTO? = todoAppService.completeTodoById(id)
}