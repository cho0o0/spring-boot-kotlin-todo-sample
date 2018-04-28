package  com.luzon.todo.domain.todo

import org.springframework.data.jpa.repository.JpaRepository

interface ITodoRepository : JpaRepository<Todo, Long> {
}