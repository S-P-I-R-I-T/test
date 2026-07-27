package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "Motorcontrol_exam")
public class Motorcontrol_exam extends LinearOpMode {

    @Override
    public void runOpMode() {

        MotorControl motorControl = new MotorControl(hardwareMap);
        waitForStart();

        if (opModeIsActive()) {
            // Pre-run
            while (opModeIsActive()) {
                motorControl.setPower(gamepad1.left_stick_y);

            }
        }
    }
}