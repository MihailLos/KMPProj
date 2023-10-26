package com.example.kmpproj.components

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import com.example.kmpproj.domain.TodoItem

interface TodoComponent {
    val model: Value<Model>

    fun onItemClicked(item: TodoItem)

    data class Model(
        val items: List<TodoItem>,
    )
}

class DefaultTodoComponent(
    componentContext: ComponentContext,
    private val onItemSelected: (item: TodoItem) -> Unit,
) : TodoComponent {
    override val model: Value<TodoComponent.Model> =
        MutableValue(
            TodoComponent.Model(
                items = listOf(TodoItem(1U, "test", "des", false))
            )
        )

    override fun onItemClicked(item: TodoItem) { onItemSelected(item) }
}