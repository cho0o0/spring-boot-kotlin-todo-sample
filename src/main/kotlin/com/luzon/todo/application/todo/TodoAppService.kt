package com.luzon.todo.application.todo

import com.luzon.todo.domain.todo.ITodoRepository
import com.luzon.todo.domain.todo.Todo
import com.luzon.todo.domain.todo.TodoId
import com.luzon.todo.domain.todo.TodoSpecification
import com.luzon.todo.infrastructure.IIdGeneratorService
import org.springframework.stereotype.Service

@Service
class TodoAppService(
        private val repository: ITodoRepository,
        private val idGeneratorService: IIdGeneratorService,
        private val todoSpecification: TodoSpecification
) {
    fun create(todoDto: TodoDTO): TodoDTO {
        return convertToTodoDTO(repository.save(convertToTodo(todoDto)))
    }

    fun findAllTodos(): List<TodoDTO> {
        return convertToTodoDTOs(repository.findAll())
    }

    fun findByTodoId(todoId: TodoId): TodoDTO? {
        return repository.findOne(todoSpecification.id(todoId))
                .map(this::convertToTodoDTO)
                .orElse(null)
    }

    fun completeTodoById(todoId: TodoId): TodoDTO? {
        return repository.findOne(todoSpecification.id(todoId))
                .map({ it.done() })
                .map({ todo -> repository.save(todo) })
                .map(this::convertToTodoDTO)
                .orElse(null)
    }

    private fun convertToTodo(todoDto: TodoDTO): Todo {
        return Todo(idGeneratorService.generate(), todoDto.message)
    }

    private fun convertToTodoDTO(todo: Todo): TodoDTO {
        return TodoDTO(
                todo.id, todo.message, todo.createdDate, todo.updatedDate, todo.isDone
        )
    }

    private fun convertToTodoDTOs(todos: List<Todo>): List<TodoDTO> {
        return todos.map { convertToTodoDTO(it) }
    }

}