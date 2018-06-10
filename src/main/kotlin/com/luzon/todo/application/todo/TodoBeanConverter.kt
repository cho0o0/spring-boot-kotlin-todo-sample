package com.luzon.todo.application.todo

import com.luzon.todo.domain.todo.Todo
import com.luzon.todo.infrastructure.IIdGeneratorService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
object TodoBeanConverter {

    @Autowired
    private lateinit var idGeneratorService: IIdGeneratorService

    fun convertToTodo(todoDto: TodoDTO): Todo = Todo(idGeneratorService.generate(), todoDto.message)


    fun convertToTodoDTO(todo: Todo): TodoDTO = TodoDTO(
            todo.id, todo.message, todo.createdDate, todo.updatedDate, todo.isDone
    )

    fun convertToTodoDTOs(todos: List<Todo>): List<TodoDTO> = todos.map { convertToTodoDTO(it) }

}