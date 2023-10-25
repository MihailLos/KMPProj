package com.example.kmpproj.domain


interface TodoRepository {
    suspend fun getAll(): Result<List<TodoItem>>
    suspend fun save(todoItem: TodoItem): Result<Unit>
    suspend fun delete(todoItem: TodoItem): Result<Unit>
    suspend fun update(todoItem: TodoItem): Result<TodoItem>
}