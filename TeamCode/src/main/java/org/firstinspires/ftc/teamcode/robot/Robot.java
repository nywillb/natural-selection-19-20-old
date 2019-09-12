package org.firstinspires.ftc.teamcode.robot;

import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.robotcore.external.Telemetry;

interface Robot {
    public String getName();

    public void introduceSelf(Telemetry telemetry);
}
