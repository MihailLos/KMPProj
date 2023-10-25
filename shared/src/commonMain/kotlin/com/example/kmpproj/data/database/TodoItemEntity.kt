package com.example.kmpproj.data.database

data class TodoItemEntity(
    val id: ULong,
    val title: String,
    val description: String,
    val completed: Boolean
)
