package com.example.android.hilt.data

import com.example.android.hilt.data.local.Log

interface LoggerDataSource {

    fun addLog(msg: String) {
    }

    fun getAllLogs(callback: (List<Log>) -> Unit) {
    }

    fun removeLogs() {
    }
}