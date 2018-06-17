package  com.luzon.todo.domain.todo

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor

interface ITodoRepository : JpaRepository<Todo, Long>, JpaSpecificationExecutor<Todo>