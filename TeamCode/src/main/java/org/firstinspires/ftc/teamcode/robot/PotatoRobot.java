package org.firstinspires.ftc.teamcode.robot;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.robotcore.external.Telemetry;

public class PotatoRobot implements Robot {

    // Declare OpMode members.
    private DcMotor frontLeft;
    private DcMotor frontRight;
    private DcMotor backLeft;
    private DcMotor backRight;

    public PotatoRobot(HardwareMap hardwareMap, Telemetry telemetry) {
        frontLeft = hardwareMap.get(DcMotor.class, "front_left");
        frontRight = hardwareMap.get(DcMotor.class, "front_right");
        backLeft = hardwareMap.get(DcMotor.class, "back_left");
        backRight = hardwareMap.get(DcMotor.class, "back_right");

        frontLeft.setDirection(DcMotorSimple.Direction.FORWARD);
        frontRight.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeft.setDirection(DcMotorSimple.Direction.FORWARD);
        backRight.setDirection(DcMotorSimple.Direction.REVERSE);

        frontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        this.introduceSelf(telemetry);
    }


    @Override
    public String getName() {
        return "Potato";
    }

    @Override
    public void introduceSelf(Telemetry telemetry) {
        telemetry.addData("Hello!", this.getName() + " reporting for duty!");
        telemetry.update();
    }

    public void leftMotors(double power) {
        frontLeft.setPower(power);
        backLeft.setPower(power);
    }

    public void rightMotors(double power) {
        frontRight.setPower(power);
        frontRight.setPower(power);
    }

    public void straightDrive(double leftPower, double rightPower) {
        leftMotors(leftPower);
        rightMotors(rightPower);
    }

    public void strafeLeft(double power) {
        frontLeft.setPower(-power);
        frontRight.setPower(power);
        backLeft.setPower(power);
        backRight.setPower(-power);
    }

    public void strafeRight(double power) {
        frontLeft.setPower(power);
        frontRight.setPower(-power);
        backLeft.setPower(-power);
        backRight.setPower(power);
    }

}