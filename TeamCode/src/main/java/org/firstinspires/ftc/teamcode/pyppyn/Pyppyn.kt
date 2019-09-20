package org.firstinspires.ftc.teamcode.pyppyn

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode
import com.qualcomm.robotcore.eventloop.opmode.TeleOp
import com.qualcomm.robotcore.util.ElapsedTime
import com.qualcomm.robotcore.util.Range
import org.firstinspires.ftc.teamcode.robot.PyppynRobot

@TeleOp(name = "\uD83D\uDD04 Pyppyn", group = "Pyppyn")
class Pyppyn : LinearOpMode() {

    // Show running time.
    private val runtime = ElapsedTime()

    private val MAX_LIFT_SPEED = 0.5
    private val MAX_DRIVE_SPEED = 0.8
    private val MIN_DRIVE_SPEED = -0.8
    private val SLOW_MODE_SPEED = 0.3
    private val SPIN_SPEED = 0.5
    private val SLOW_MODE_SPIN_SPEED = 0.3

    private var debounceA = false


    /**
     * Runs the opmode!
     */
    override fun runOpMode() {
        // Initialize Pyppyn
        val pyppyn = PyppynRobot(hardwareMap, telemetry)

        // Wait for the game to start (driver presses PLAY)
        waitForStart()
        runtime.reset()

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {

            val drive = (-gamepad1.left_stick_y).toDouble()
            val turn = gamepad1.right_stick_x.toDouble()
            if (gamepad1.left_stick_y < -0.13 || gamepad1.left_stick_y > 0.13) {
                val leftPower = Range.clip(drive + turn, MIN_DRIVE_SPEED, MAX_DRIVE_SPEED)
                val rightPower = Range.clip(drive - turn, MIN_DRIVE_SPEED, MAX_DRIVE_SPEED)

                pyppyn.straightDrive(leftPower, rightPower)
            } else if (gamepad1.left_bumper) {
                if (gamepad1.b) {
                    pyppyn.slowRotateCounterclockwise(SLOW_MODE_SPIN_SPEED)
                } else pyppyn.rotateCounterclockwise(SPIN_SPEED)
            } else if (gamepad1.right_bumper) {
                if (gamepad1.b) {
                    pyppyn.slowRotateClockwise(SLOW_MODE_SPIN_SPEED)
                } else pyppyn.rotateClockwise(SPIN_SPEED)
            } else if (gamepad1.left_stick_x < -0.13 || gamepad1.left_stick_x > 0.13) {
                pyppyn.strafeRight(gamepad1.left_stick_x.toDouble())
            } else if (gamepad1.dpad_up) {
                pyppyn.straightDrive(SLOW_MODE_SPEED, SLOW_MODE_SPEED)
            } else if (gamepad1.dpad_down) {
                pyppyn.straightDrive(-SLOW_MODE_SPEED, -SLOW_MODE_SPEED)
            } else if (gamepad1.dpad_left) {
                pyppyn.strafeLeft(SLOW_MODE_SPEED)
            } else if (gamepad1.dpad_right) {
                pyppyn.strafeRight(SLOW_MODE_SPEED)
            } else {
                pyppyn.stop()
            }

            if (gamepad1.left_trigger > 0.13) {
                pyppyn.lift(Range.clip(gamepad1.left_trigger.toDouble(), 0.0, MAX_LIFT_SPEED))
            } else if (gamepad1.right_trigger > 0.13) {
                pyppyn.lift(-Range.clip(gamepad1.right_trigger.toDouble(), 0.0, MAX_LIFT_SPEED))
            } else {
                pyppyn.lift(0.0)
            }

            if (gamepad1.a && !debounceA) {
                pyppyn.clawIsOpen = !pyppyn.clawIsOpen
            }

            debounceA = gamepad1.a

            telemetry.addData("Status", "Run Time: $runtime")
            telemetry.update()
        }

        telemetry.addData("Status", "stopped")
        telemetry.update()
    }
}
