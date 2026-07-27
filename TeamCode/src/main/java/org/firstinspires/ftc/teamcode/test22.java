package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "test22")
public class test22 extends LinearOpMode {

    DcMotor motor1;

    @Override
    public void runOpMode() {

        motor1 = hardwareMap.get(DcMotor.class,"motor1");
        telemetry.addData("Hardware", "initialized");
        waitForStart();

        if (opModeIsActive()) {
            // Pre-run
            while (opModeIsActive()) {
                float x = gamepad1.left_stick_x;
                if (gamepad1.a) {
                    motor1.setPower(0.5);
                }
                if (gamepad1.left_stick_x > 0)
                motor1.setPower(0);
            }
        }
    }
}