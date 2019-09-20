package org.firstinspires.ftc.teamcode.intelligentdesign

import android.graphics.drawable.Drawable
import android.view.View
import android.widget.TextView

import java.util.ArrayList
import java.util.Date

class TextLogger : Logger {
    private val logs = ArrayList<LogItem<String>>()


    val logStrings: Array<String>
        get() {
            val logs = ArrayList<String>()
            for (li in this.logs) {
                li.data?.let { logs.add(it) }
            }
            return logs.toTypedArray<String>()
        }

    constructor(name: String) : super("[TextLogger] $name") {}

    constructor() : super("[TextLogger]") {}

    fun logData(text: String) {
        this.logs.add(LogItem(text))
    }

    fun logData(text: String, date: Date) {
        this.logs.add(LogItem(text, date))
    }

    fun logData(textqs: Array<String>) {

    }

    fun logData(texts: Array<LogItem<String>>) {

    }

    override fun saveLogData() {

    }

    override fun drawLogs(): Array<View?> {
        val views = ArrayList<View>()

        //        for(LogItem<String> li : this.logs) {
        ////            new TextView(li.getData() + " (" + li.getTime().toString() + ")");
        //        }

        return arrayOfNulls(0)
    }
}
