package org.firstinspires.ftc.teamcode.bert

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode
import com.qualcomm.robotcore.eventloop.opmode.TeleOp
import com.qualcomm.robotcore.util.ElapsedTime
import com.qualcomm.robotcore.util.Range
import org.firstinspires.ftc.teamcode.robot.BertRobot

@TeleOp(name = "\uD83D\uDC1D Bert", group = "Bert")
class Bert : LinearOpMode() {

    // Show running time.
    private val runtime = ElapsedTime()


    /**
     * Runs the opmode!
     */
    override fun runOpMode() {
        // Initialize bert
        val bert = BertRobot(hardwareMap, telemetry)

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

                bert.straightDrive(leftPower, rightPower)
            } else if (gamepad1.left_stick_x < -0.13 || gamepad1.left_stick_x > 0.13) {
                bert.strafeRight(gamepad1.left_stick_x.toDouble())
            } else {
                bert.straightDrive(0.0, 0.0)
            }

            if (gamepad1.left_trigger > 0.13) {
                bert.nomNomNom(Range.clip(gamepad1.left_trigger.toDouble(), 0.0, 1.0))
            } else {
                bert.nomNomNom(0.0)
            }

            if (gamepad1.dpad_up) {
                bert.lift(0.5)
            } else if (gamepad1.dpad_down) {
                bert.lift(-0.5)
            } else {
                bert.lift(0.0)
            }

            telemetry.addData("Status", "Run Time: $runtime")
            telemetry.update()
        }
    }
}
