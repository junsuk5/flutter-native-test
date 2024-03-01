package com.example.native_test.todo

class TodoRepository {
    private val dataSource = TodoDataSource.instance()

    suspend fun getTodo(id: Int) = dataSource.getTodo(id)
}