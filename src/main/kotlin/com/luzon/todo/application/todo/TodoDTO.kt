package com.luzon.todo.application.todo

import java.time.LocalDateTime

data class TodoDTO(
        val id: String?,
        val message: String,
        val createdDate: LocalDateTime?,
        val updatedDate: LocalDateTime?,
        val isDone: Boolean?
)