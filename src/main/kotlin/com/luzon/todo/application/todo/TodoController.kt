package com.luzon.todo.application.todo

import com.luzon.todo.domain.todo.TodoId
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/todos")
class CustomerController(
        private val mutationService: TodoMutationServiceService,
        private val queryService: TodoQueryService
) {

    @PostMapping("/")
    fun create(@RequestBody todoDto: TodoDTO): TodoDTO = mutationService.create(todoDto)

    @GetMapping("/")
    fun findAll(): List<TodoDTO> = queryService.todos()

    @GetMapping("/{id}")
    fun findById(@PathVariable id: TodoId): TodoDTO? = queryService.todo(id)

    @PatchMapping("/{id}/done")
    fun done(@PathVariable id: TodoId): TodoDTO? = mutationService.completeTodoById(id)
}