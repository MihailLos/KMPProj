package com.example.kmpproj.data

import com.example.kmpproj.data.database.TodoItemEntity
import com.example.kmpproj.domain.TodoItem

fun TodoItemEntity.toDomain(): TodoItem {
    return TodoItem(
        id = id,
        title = title,
        description = description,
        isDone = completed
    )
}

fun TodoItem.toEntity(): TodoItemEntity {
    return TodoItemEntity(
        id = id,
        title = title,
        description = description,
        completed = isDone
    )
}