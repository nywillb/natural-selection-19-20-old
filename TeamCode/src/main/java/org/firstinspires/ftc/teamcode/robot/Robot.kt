package org.firstinspires.ftc.teamcode.robot

import com.qualcomm.robotcore.hardware.HardwareMap
import org.firstinspires.ftc.robotcore.external.Telemetry

/**
 * Robot is an interface that implements a robot
 */
internal interface Robot {
    /**
     * Each robot has a name, this function returns the name
     *
     * @return The robot's name
     */
    val name: String

    /**
     * Each robot can introduce itself, this function allows the robot to introduce itself
     *
     * @param telemetry The telemetry object, that allows the robot to interact with it
     */
    fun introduceSelf(telemetry: Telemetry)
}
