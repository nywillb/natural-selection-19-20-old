package org.firstinspires.ftc.teamcode.robot

import com.qualcomm.robotcore.hardware.*
import org.firstinspires.ftc.robotcore.external.Telemetry
import org.firstinspires.ftc.teamcode.bert.SpinnerPosition

class BertRobot(hardwareMap: HardwareMap, telemetry: Telemetry) : Robot {

    // Declare OpMode members.
    val frontLeft: DcMotor = hardwareMap.get(DcMotor::class.java, "front_left")
    val frontRight: DcMotor = hardwareMap.get(DcMotor::class.java, "front_right")
    val backLeft: DcMotor = hardwareMap.get(DcMotor::class.java, "back_left")
    val backRight: DcMotor = hardwareMap.get(DcMotor::class.java, "back_right")

    val nomLeft: DcMotor = hardwareMap.get(DcMotor::class.java, "nom_left")
    val nomRight: DcMotor = hardwareMap.get(DcMotor::class.java, "nom_right")

    val lift: DcMotor = hardwareMap.get(DcMotor::class.java, "lift")

    val flicker: Servo = hardwareMap.get(Servo::class.java, "flicker")
    val spinner: Servo = hardwareMap.get(Servo::class.java, "spinner")
    val claw: Servo = hardwareMap.get(Servo::class.java, "claw")

    var flickerIsOut = false
        set(value) {
            if(value) {
                flicker.position = 0.88
            } else flicker.position = 0.53
            field = value
        }

    var clawIsOpen = true
        set(value) {
            if(value) {
                claw.position = 0.55
            } else claw.position = 0.24
            field = value
        }

    var spinnerPosition = SpinnerPosition.IN
        set(value) {
            if(value == SpinnerPosition.IN) {
                spinner.position = 0.12
            } else if (value == SpinnerPosition.HALF) {
                spinner.position = 0.47
            } else if (value == SpinnerPosition.OUT) {
                spinner.position = 0.81
            }
            field = value
        }

//    private val xOdometer: DcMotor = hardwareMap.get(DcMotor::class.java, "x_odometer");
//    private val yOdometer: DcMotor = hardwareMap.get(DcMotor::class.java, "y_odometer")

    init {

        frontLeft.direction = DcMotorSimple.Direction.FORWARD
        frontRight.direction = DcMotorSimple.Direction.REVERSE
        backLeft.direction = DcMotorSimple.Direction.FORWARD
        backRight.direction = DcMotorSimple.Direction.REVERSE

        nomLeft.direction = DcMotorSimple.Direction.FORWARD
        nomRight.direction = DcMotorSimple.Direction.REVERSE

        lift.direction = DcMotorSimple.Direction.FORWARD

        frontLeft.zeroPowerBehavior = DcMotor.ZeroPowerBehavior.BRAKE
        frontRight.zeroPowerBehavior = DcMotor.ZeroPowerBehavior.BRAKE
        backLeft.zeroPowerBehavior = DcMotor.ZeroPowerBehavior.BRAKE
        backRight.zeroPowerBehavior = DcMotor.ZeroPowerBehavior.BRAKE

        nomLeft.zeroPowerBehavior = DcMotor.ZeroPowerBehavior.FLOAT
        nomRight.zeroPowerBehavior = DcMotor.ZeroPowerBehavior.FLOAT

        lift.zeroPowerBehavior = DcMotor.ZeroPowerBehavior.BRAKE

//        xOdometer.zeroPowerBehavior = DcMotor.ZeroPowerBehavior.FLOAT
//        yOdometer.zeroPowerBehavior = DcMotor.ZeroPowerBehavior.FLOAT
//
//        xOdometer.currentPosition
//        yOdometer.currentPosition

        this.introduceSelf(telemetry)
    }

    override val name: String
        get() = "Bert"

    override fun introduceSelf(telemetry: Telemetry) {
        telemetry.addData("Hello!", this.name + " reporting for duty!")
        telemetry.update()
    }

    fun leftMotors(power: Double) {
        frontLeft.power = power
        backLeft.power = power
    }

    fun rightMotors(power: Double) {
        frontRight.power = power
        backRight.power = power
    }

    fun nomNomNom(power: Double) {
        nomLeft.power = power
        nomLeft.power = power
    }

    fun lift(power: Double) {
        lift.power = power
    }

    fun straightDrive(leftPower: Double, rightPower: Double) {
        leftMotors(leftPower)
        rightMotors(rightPower)
    }

    fun strafeLeft(power: Double) {
        frontLeft.power = -power
        frontRight.power = power
        backLeft.power = power
        backRight.power = -power
    }

    fun strafeRight(power: Double) {
        frontLeft.power = power
        frontRight.power = -power
        backLeft.power = -power
        backRight.power = power
    }

}