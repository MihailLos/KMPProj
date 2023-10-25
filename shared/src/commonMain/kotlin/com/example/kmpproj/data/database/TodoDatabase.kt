package com.example.kmpproj.data.database

interface TodoDatabase {
    suspend fun getAll(): List<TodoItemEntity>
    suspend fun save(todoItem: TodoItemEntity)
    suspend fun deleteById(id: ULong)
    suspend fun updateById(id: ULong, todoItem: TodoItemEntity): TodoItemEntity
}