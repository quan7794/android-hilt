package com.example.android.hilt.data.memory

import com.example.android.hilt.data.LoggerDataSource
import com.example.android.hilt.data.local.Log
import dagger.hilt.android.scopes.ActivityScoped
import java.util.LinkedList
import javax.inject.Inject

@ActivityScoped
class LoggerMemoryDataSource @Inject constructor(): LoggerDataSource {
    private val logs = LinkedList<Log>()

    override fun removeLogs() {
        logs.clear()
    }

    override fun addLog(msg: String) {
        logs.addFirst(Log(msg, System.currentTimeMillis()))
    }

    override fun getAllLogs(callback: (List<Log>) -> Unit) {
        callback(logs)
    }
}