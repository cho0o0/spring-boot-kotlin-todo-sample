package com.luzon.todo.domain.todo

import org.springframework.data.jpa.domain.Specification
import javax.persistence.criteria.CriteriaQuery
import javax.persistence.criteria.Root

class TodoSpecification {
    fun id(todoId: TodoId) : Specification<Todo> {
        return Specification { root: Root<Todo>, query: CriteriaQuery<*>, criteriaBuilder ->
            criteriaBuilder.equal(root.get<Todo>("id"), todoId)
        }
    }
}