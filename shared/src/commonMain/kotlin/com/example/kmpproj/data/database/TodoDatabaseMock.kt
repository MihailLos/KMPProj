package com.example.kmpproj.data.database

object TodoDatabaseMock : TodoDatabase {
    private val todos = mutableListOf<TodoItemEntity>(
        TodoItemEntity(1U, "Todo 1", "Description 1", false),
        TodoItemEntity(2U, "Todo 2", "Description 2", false),
        TodoItemEntity(3U, "Todo 3", "Description 3", false),
        TodoItemEntity(4U, "Todo 4", "Description 4", false),
        TodoItemEntity(5U, "Todo 5", "Description 5", false),
    )
    override suspend fun getAll(): List<TodoItemEntity> {
        return todos
    }

    override suspend fun save(todoItem: TodoItemEntity) {
        todos.add(todoItem)
    }

    override suspend fun deleteById(id: ULong) {
        todos.removeAll { it.id == id }
    }

    override suspend fun updateById(id: ULong, todoItem: TodoItemEntity): TodoItemEntity {
        val index = todos.indexOfFirst { it.id == id }
        todos[index] = todoItem
        return todos[index]
    }
}