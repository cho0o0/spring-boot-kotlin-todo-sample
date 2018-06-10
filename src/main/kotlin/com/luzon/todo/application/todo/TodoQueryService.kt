package com.luzon.todo.application.todo

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import org.springframework.stereotype.Component

@Component
class TodoQueryService : GraphQLQueryResolver {
    fun version() = "0.0.1"
}