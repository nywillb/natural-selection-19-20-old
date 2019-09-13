package org.firstinspires.ftc.teamcode.potato

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode
import com.qualcomm.robotcore.eventloop.opmode.TeleOp
import com.qualcomm.robotcore.util.ElapsedTime
import com.qualcomm.robotcore.util.Range
import org.firstinspires.ftc.teamcode.robot.PotatoRobot

@TeleOp(name = "\uD83C\uDF60 Potato", group = "Potato")
class Potato : LinearOpMode() {

    // Show running time.
    private val runtime = ElapsedTime()


    /**
     * Runs the opmode!
     */
    override fun runOpMode() {
        // Initialize the potato
        val potato = PotatoRobot(hardwareMap, telemetry)

        // Wait for the game to start (driver presses PLAY)
        waitForStart()
        runtime.reset()

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {

            val drive = (-gamepad1.left_stick_y).toDouble()
            val turn = gamepad1.right_stick_x.toDouble()
            if (gamepad1.left_stick_y < -0.13 || gamepad1.left_stick_y > 0.13) {
                val leftPower = Range.clip(drive + turn, -1.0, 1.0)
                val rightPower = Range.clip(drive - turn, -1.0, 1.0)

                potato.straightDrive(leftPower, rightPower)
            } else if (gamepad1.left_stick_x < -0.13 || gamepad1.left_stick_x > 0.13) {
                potato.strafeRight(gamepad1.left_stick_x.toDouble())
            } else {
                potato.straightDrive(0.0, 0.0)
            }

            telemetry.addData("Status", "Run Time: $runtime")
            telemetry.update()
        }
    }
}
