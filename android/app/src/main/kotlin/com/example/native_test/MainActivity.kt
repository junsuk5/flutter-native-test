package com.example.native_test

import androidx.lifecycle.lifecycleScope
import com.example.native_test.todo.TodoRepository
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.MethodChannel
import kotlinx.coroutines.launch

class MainActivity : FlutterActivity() {
    private val channel = "sample.native_test/todos"

    private val todoRepository = TodoRepository()

    override fun configureFlutterEngine(flutterEngine: FlutterEngine) {
        super.configureFlutterEngine(flutterEngine)
        MethodChannel(
            flutterEngine.dartExecutor.binaryMessenger,
            channel,
        ).setMethodCallHandler { call, result ->
            if (call.method == "getJsonString") {
                lifecycleScope.launch {
                    val response = todoRepository.getTodo(
                        call.argument<Int>("id") ?: throw IllegalArgumentException()
                    )
                    result.success(response.body())
                }
            } else {
                result.notImplemented()
            }
        }
    }
}
