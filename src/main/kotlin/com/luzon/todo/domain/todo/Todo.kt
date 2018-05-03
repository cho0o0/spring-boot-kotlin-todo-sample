package com.luzon.todo.domain.todo

import java.time.LocalDateTime
import javax.persistence.Entity
import javax.validation.constraints.NotEmpty

@Entity
data class Todo (
        @NotEmpty val id: TodoId,
        var message: String
) {

    val createdDate: LocalDateTime = LocalDateTime.now()
    var updatedDate: LocalDateTime = LocalDateTime.now()
    var isDone: Boolean = false

    fun done(): Todo {
        this.isDone = true
        return this
    }
}