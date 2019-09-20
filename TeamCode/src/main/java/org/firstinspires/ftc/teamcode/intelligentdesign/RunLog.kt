package org.firstinspires.ftc.teamcode.intelligentdesign

import java.util.Date

class RunLog {
    private var loggers: Array<Logger>? = null
    private var runTime: Date? = null

    constructor(loggers: Array<Logger>) {
        this.loggers = loggers
        this.runTime = Date()
    }

    constructor(logger: Logger) {
        this.loggers = arrayOf(logger)
        this.runTime = Date()
    }

    constructor(loggers: Array<Logger>, runTime: Date) {
        this.loggers = loggers
        this.runTime = runTime
    }

    constructor(logger: Logger, runTime: Date) {
        this.loggers = arrayOf(logger)
        this.runTime = runTime
    }
}
