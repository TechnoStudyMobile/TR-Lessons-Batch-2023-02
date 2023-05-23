package com.example.w13d5_workmanager

import android.content.Context
import androidx.annotation.RequiresPermission
import androidx.work.Worker
import androidx.work.WorkerParameters

class MyWorker(context: Context, workerParams: WorkerParameters) : Worker(context, workerParams) {
    override fun doWork(): Result {
        return try {
            Thread.sleep(3000)
            Result.success()
        } catch (e: Exception){
            Result.failure()
        }
    }
}