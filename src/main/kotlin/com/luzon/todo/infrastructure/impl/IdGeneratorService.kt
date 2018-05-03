package com.luzon.todo.infrastructure.impl

import com.fasterxml.uuid.Generators
import com.fasterxml.uuid.impl.TimeBasedGenerator
import com.luzon.todo.infrastructure.IIdGeneratorService
import com.luzon.todo.infrastructure.Id
import org.springframework.stereotype.Service

@Service
class IdGeneratorService : IIdGeneratorService {
    private val generator: TimeBasedGenerator = Generators.timeBasedGenerator()

    override fun generate(): Id {
        return generator.generate().toString()
    }
}