package org.firstinspires.ftc.teamcode.intelligentdesign

import android.graphics.drawable.Drawable
import android.view.View

import java.util.Date

abstract class Logger(private val name: String) {

    private var startTime: Date? = null
    private var endTime: Date? = null

    init {
        this.startTime = Date()
    }

    private fun defineStartTime() {
        this.startTime = Date()
    }

    private fun defineStartTime(startTime: Date) {
        this.startTime = startTime
    }

    private fun defineEndTime() {
        this.endTime = Date()
    }

    private fun defineEndTime(endTime: Date) {
        this.endTime = endTime
    }

    abstract fun saveLogData()

    abstract fun drawLogs(): Array<View?>
}
