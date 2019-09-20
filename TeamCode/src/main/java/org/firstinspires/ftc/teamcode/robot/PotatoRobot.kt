package org.firstinspires.ftc.teamcode.robot

import com.qualcomm.robotcore.hardware.*
import org.firstinspires.ftc.robotcore.external.Telemetry

class PotatoRobot(hardwareMap: HardwareMap, telemetry: Telemetry) : Robot {

    // Declare OpMode members.
    val frontLeft: DcMotor = hardwareMap.get(DcMotor::class.java, "front_left")
    val frontRight: DcMotor = hardwareMap.get(DcMotor::class.java, "front_right")
    val backLeft: DcMotor = hardwareMap.get(DcMotor::class.java, "back_left")
    val backRight: DcMotor = hardwareMap.get(DcMotor::class.java, "back_right")

    val nomLeft: DcMotor = hardwareMap.get(DcMotor::class.java, "nom_left")
    val nomRight: DcMotor = hardwareMap.get(DcMotor::class.java, "nom_right")

    val lift: DcMotor = hardwareMap.get(DcMotor::class.java, "lift")

    val flicker: CRServo = hardwareMap.get(CRServo::class.java, "flicker")
    val spinner: CRServo = hardwareMap.get(CRServo::class.java, "spinner")
    val claw: Servo = hardwareMap.get(Servo::class.java, "claw")

    var flickerIsOut = false
        set(value) {
            field = value;
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
        get() = "Potato"

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