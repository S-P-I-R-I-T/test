package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "Motorcontrol_example")
public class Motorcontrol_example extends LinearOpMode {

    @Override
    public void runOpMode() {

        MotorControl1 motorControl = new MotorControl1(hardwareMap);
        waitForStart();

        if (opModeIsActive()) {
            // Pre-run
            while (opModeIsActive()) {
                motorControl.setPower(gamepad1.left_stick_y);

            }
        }
    }
}