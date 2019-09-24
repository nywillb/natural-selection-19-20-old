package org.firstinspires.ftc.teamcode.robot

import com.qualcomm.robotcore.hardware.*
import org.firstinspires.ftc.robotcore.external.Telemetry
import java.lang.Thread.sleep

class PyppynRobot(hardwareMap: HardwareMap, telemetry: Telemetry) : Robot {

    val frontLeft: DcMotor = hardwareMap.get(DcMotor::class.java, "front_left")
    val frontRight: DcMotor = hardwareMap.get(DcMotor::class.java, "front_right")
    val backLeft: DcMotor = hardwareMap.get(DcMotor::class.java, "back_left")
    val backRight: DcMotor = hardwareMap.get(DcMotor::class.java, "back_right")

    val lift: DcMotor = hardwareMap.get(DcMotor::class.java, "lift")

    val claw: Servo = hardwareMap.get(Servo::class.java, "claw")

    val topClaw: Servo = hardwareMap.get(Servo::class.java, "top_claw")

    var topClawIsOpen = false
        set(value) {
            if (value) {
                claw.position = 0.92
                field = value
            } else {
                claw.position = 0.76
                field = value
            }
        }

    var clawIsOpen = false
        set(value) {
            if (value) {
                claw.position = 0.92
                field = value
            } else {
                claw.position = 0.76
                field = value
            }
        }

    init {
        frontLeft.direction = DcMotorSimple.Direction.FORWARD
        backLeft.direction = DcMotorSimple.Direction.FORWARD
        frontRight.direction = DcMotorSimple.Direction.FORWARD
        backRight.direction = DcMotorSimple.Direction.FORWARD

        lift.direction = DcMotorSimple.Direction.FORWARD

        frontLeft.zeroPowerBehavior = DcMotor.ZeroPowerBehavior.BRAKE
        backLeft.zeroPowerBehavior = DcMotor.ZeroPowerBehavior.BRAKE
        frontRight.zeroPowerBehavior = DcMotor.ZeroPowerBehavior.BRAKE
        backRight.zeroPowerBehavior = DcMotor.ZeroPowerBehavior.BRAKE

        lift.zeroPowerBehavior = DcMotor.ZeroPowerBehavior.BRAKE

        claw.position = 0.62

        this.introduceSelf(telemetry)
    }

    fun rotateClockwise(power: Double) {
        frontLeft.power = power
        frontRight.power = power
        backLeft.power = power
        backRight.power = power
    }

    fun rotateCounterclockwise(power: Double) {
        frontLeft.power = -power
        frontRight.power = -power
        backLeft.power = -power
        backRight.power = -power
    }

    fun slowRotateClockwise(power: Double) {
        frontLeft.power = power
        backRight.power = power
    }

    fun slowRotateCounterclockwise(power: Double) {
        frontLeft.power = -power
        backRight.power = -power
    }

    fun strafeRight(power: Double) {
        frontLeft.power = power
        backLeft.power = -power
        frontRight.power = power
        backRight.power = -power
    }

    fun strafeLeft(power: Double) {
        frontLeft.power = -power
        backLeft.power = power
        frontRight.power = -power
        backRight.power = power
    }

    fun straightDrive(leftPower: Double, rightPower: Double) {
        frontLeft.power = leftPower
        backLeft.power = leftPower
        frontRight.power = -rightPower
        backRight.power = -rightPower
    }

    fun lift(power: Double) {
        lift.power = power
    }

    fun stop() {
        frontLeft.power = 0.0
        backLeft.power = 0.0
        frontRight.power = 0.0
        backRight.power = 0.0
    }

    override fun introduceSelf(telemetry: Telemetry) {
        telemetry.addData("Hello!", this.name + " reporting for duty!")
        telemetry.update()
    }

    override val name: String
        get() = "Pyppyn"

}