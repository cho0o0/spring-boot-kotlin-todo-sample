package com.luzon.todo.application.todo

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
    fun findById(@PathVariable id: String): TodoDTO? = queryService.todo(id)

    @PatchMapping("/{id}/done")
    fun done(@PathVariable id: String): TodoDTO? = mutationService.completeTodoById(id)
}