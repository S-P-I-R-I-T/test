package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "test5") //움직임
public class test5 extends LinearOpMode {
    Mecanum_Driving drive;

    @Override
    public void runOpMode() {
        Init();

        waitForStart();

        if (opModeIsActive()) {
            // Pre-run
            while (opModeIsActive()) {
                // OpMode loop
                drive.drive(-gamepad1.left_stick_y, gamepad1.left_stick_x, gamepad1.right_stick_x);

                telemetry.update();
            }
        }
    }

    public void Init() {
        drive = new Mecanum_Driving(hardwareMap);
    }
}