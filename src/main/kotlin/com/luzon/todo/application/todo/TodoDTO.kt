package com.luzon.todo.application.todo

import com.luzon.todo.infrastructure.Id
import java.time.LocalDateTime

data class TodoDTO(
        val id: Id?,
        val message: String,
        val createdDate: LocalDateTime?,
        val updatedDate: LocalDateTime?,
        val isDone: Boolean?
)