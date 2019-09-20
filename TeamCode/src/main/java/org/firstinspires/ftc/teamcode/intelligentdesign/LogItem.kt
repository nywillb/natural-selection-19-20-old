package org.firstinspires.ftc.teamcode.intelligentdesign

import java.util.Date

class LogItem<T> {
    var time: Date? = null
        private set
    var data: T? = null
        private set

    constructor(data: T) {
        this.time = Date()
        this.data = data
    }

    constructor(data: T, time: Date) {
        this.time = time
        this.data = data
    }
}
