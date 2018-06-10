package com.luzon.todo.infrastructure

import java.io.Serializable
import javax.persistence.Embeddable

@Embeddable
class Id<out T>(var id: String) : Serializable