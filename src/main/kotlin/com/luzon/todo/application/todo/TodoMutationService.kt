package com.luzon.todo.application.todo

import com.luzon.todo.domain.todo.ITodoRepository
import com.luzon.todo.domain.todo.TodoId
import com.luzon.todo.domain.todo.TodoSpecification
import org.springframework.stereotype.Service
import java.util.stream.Stream

@Service
class TodoMutationServiceService(
        private val specification: TodoSpecification,
        private val repository: ITodoRepository,
        private val converter: TodoBeanConverter
) {

    fun create(todoDto: TodoDTO): TodoDTO =
            Stream.of(todoDto)
                    .map(converter::convertToTodo)
                    .map { it -> repository.save(it) }
                    .map(converter::convertToTodoDTO)
                    .findAny()
                    .get()

    fun completeTodoById(todoId: TodoId): TodoDTO? = repository.findOne(specification.id(todoId))
            .map { it.done() }
            .map { todo -> repository.save(todo) }
            .map(converter::convertToTodoDTO)
            .orElse(null)

}