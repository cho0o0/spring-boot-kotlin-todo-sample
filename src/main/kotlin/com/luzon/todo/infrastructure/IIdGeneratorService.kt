package com.luzon.todo.infrastructure

interface IIdGeneratorService {
    fun generate(): Id
}