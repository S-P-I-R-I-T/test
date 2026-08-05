package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "Wheel")
public class Wheel extends LinearOpMode {
    WheelClass wheel;

    @Override
    public void runOpMode() {
        Init();
        waitForStart();

        while (opModeIsActive()) {
            initWheel();
            telemetry.update();
        }
    }

    public void Init() {
        wheel = new WheelClass(hardwareMap);
    }

    public void initWheel() {
        double axial = -gamepad1.left_stick_y;
        double lateral = gamepad1.left_stick_x;
        double yaw = gamepad1.right_stick_x;
        boolean slow = gamepad1.right_bumper;

        wheel.drive(axial, lateral, yaw, slow);
    }
}