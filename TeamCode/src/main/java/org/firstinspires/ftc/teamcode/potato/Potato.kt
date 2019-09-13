package org.firstinspires.ftc.teamcode.potato

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode
import com.qualcomm.robotcore.eventloop.opmode.TeleOp
import com.qualcomm.robotcore.util.ElapsedTime
import com.qualcomm.robotcore.util.Range
import org.firstinspires.ftc.teamcode.robot.PotatoRobot

@TeleOp(name = "\uD83E\uDD54 Potato", group = "Potato")
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

            // Setup a variable for each drive wheel to save power level for telemetry
            val leftPower: Double
            val rightPower: Double

            // Choose to drive using either Tank Mode, or POV Mode
            // Comment out the method that's not used.  The default below is POV.

            // POV Mode uses left stick to go forward, and right stick to turn.
            // - This uses basic math to combine motions and is easier to drive straight.
            val drive = (-gamepad1.left_stick_y).toDouble()
            val turn = gamepad1.right_stick_x.toDouble()
            if (gamepad1.left_stick_y < -0.13 || gamepad1.left_stick_y > 0.13) {
                leftPower = Range.clip(drive + turn, -1.0, 1.0)
                rightPower = Range.clip(drive - turn, -1.0, 1.0)

                potato.straightDrive(leftPower, rightPower)
            } else if (gamepad1.left_stick_x < -0.13 || gamepad1.left_stick_x > 0.13) {
                potato.strafeRight(gamepad1.left_stick_x.toDouble())
            } else {
                potato.straightDrive(0.0, 0.0)
            }

            telemetry.addData("Status", "Run Time: $runtime")
            //            telemetry.addData("Motors", "left (%.2f), right (%.2f), strafe (%.2f)", leftPower, rightPower, strafePower);
            telemetry.update()
        }
    }
}
