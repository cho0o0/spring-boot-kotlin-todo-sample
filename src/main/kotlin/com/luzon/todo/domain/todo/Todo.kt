package com.luzon.todo.domain.todo

import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Todo (
        @Id @GeneratedValue
        var id: TodoId,
        var message: String,
        val createdDate: LocalDateTime = LocalDateTime.now(),
        var updatedDate: LocalDateTime = LocalDateTime.now(),
        var isDone: Boolean = false
) {

    fun done(): Todo {
        this.isDone = true
        return this
    }
}