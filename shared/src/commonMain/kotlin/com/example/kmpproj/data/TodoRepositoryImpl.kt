package com.example.kmpproj.data

import com.example.kmpproj.data.database.TodoDatabase
import com.example.kmpproj.domain.TodoItem
import com.example.kmpproj.domain.TodoRepository

class TodoRepositoryImpl(private val todoDatabase: TodoDatabase) : TodoRepository {
    override suspend fun getAll(): Result<List<TodoItem>> = try {
        Result.success(todoDatabase.getAll().map { it.toDomain() })
    } catch (e: Exception) {
        Result.failure(e)
    }

    override suspend fun save(todoItem: TodoItem) = try {
        Result.success(todoDatabase.save(todoItem.toEntity()))
    } catch (e: Exception) {
        Result.failure(e)
    }

    override suspend fun delete(todoItem: TodoItem) = try {
        Result.success(todoDatabase.deleteById(todoItem.id))
    } catch (e: Exception) {
        Result.failure(e)
    }

    override suspend fun update(todoItem: TodoItem) = try {
        Result.success(todoDatabase.updateById(todoItem.id, todoItem.toEntity()).toDomain())
    } catch (e: Exception) {
        Result.failure(e)
    }
}