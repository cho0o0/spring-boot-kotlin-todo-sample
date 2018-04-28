package  com.luzon.todo.domain.todo

import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface ITodoRepository : JpaRepository<Todo, Long> {

    override fun findById(id: TodoId): Optional<Todo>
}