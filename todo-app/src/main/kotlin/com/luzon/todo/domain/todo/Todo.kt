package com.luzon.todo.domain.todo

import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.EmbeddedId
import javax.persistence.Entity
import javax.persistence.Table
import javax.validation.constraints.NotEmpty

@Entity
@Table(name = "todo")
data class Todo(
        @EmbeddedId @NotEmpty val id: TodoId,
        @Column(name = "message") var message: String
) {

    @Column(name = "created_date")
    val createdDate: LocalDateTime = LocalDateTime.now()

    @Column(name = "updated_date")
    var updatedDate: LocalDateTime = LocalDateTime.now()

    @Column(name = "is_done")
    var isDone: Boolean = false

    fun done(): Todo {
        println("a")
        this.isDone = true
        return this
    }
}