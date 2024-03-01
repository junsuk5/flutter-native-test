package com.example.native_test.todo

import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test

class TodoRepositoryTest {

    @Test
    fun getTodo() = runBlocking {
        val repository = TodoRepository()

        val result = repository.getTodo(1)
        Assert.assertEquals(
            """{
  "userId": 1,
  "id": 1,
  "title": "delectus aut autem",
  "completed": false
}""", result.body().toString()
        )
    }
}