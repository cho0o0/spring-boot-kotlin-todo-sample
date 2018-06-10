package com.luzon.todo.application.todo

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import com.luzon.todo.domain.todo.ITodoRepository
import com.luzon.todo.domain.todo.TodoId
import com.luzon.todo.domain.todo.TodoSpecification
import org.springframework.stereotype.Component

@Component
class TodoQueryService(
        private val repository: ITodoRepository,
        private val specification: TodoSpecification,
        private val converter: TodoBeanConverter
) : GraphQLQueryResolver {

    fun version() = "0.0.1"

    fun todo(todoId: TodoId): TodoDTO = repository.findOne(specification.id(todoId))
            .map(converter::convertToTodoDTO)
            .orElse(null)

    fun todos(): List<TodoDTO> = converter.convertToTodoDTOs(repository.findAll())
}