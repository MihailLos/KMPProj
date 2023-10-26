package com.example.kmpproj.viewModels

import com.example.kmpproj.domain.TodoItem
import com.example.kmpproj.domain.TodoRepository
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


class TodoViewModel(
    private val todoRepository: TodoRepository
) : ViewModel() {
    suspend fun saveTodo(todoItem: TodoItem) {
        todoRepository.save(todoItem)
        fetchTodos()
    }

    private val _todos = MutableStateFlow(emptyList<TodoItem>())
    val todos = _todos.asStateFlow()

    init {
        fetchTodos()
    }

    private fun fetchTodos() {
        viewModelScope.launch {
            todoRepository.getAll().onSuccess {
                _todos.emit(it)
            }
        }
    }
}