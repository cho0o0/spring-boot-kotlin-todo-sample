package com.luzon.todo.domain.todo

import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Todo (
        @Id @GeneratedValue
        val id: TodoId,
        val message: String,
        val createdDate: LocalDateTime = LocalDateTime.now(),
        val updatedDate: LocalDateTime = LocalDateTime.now(),
        val isDone: Boolean = false
)