package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "test7")
public class test7 extends LinearOpMode {
    Mecanum_Driving drive;
    ActionClass action;

    @Override
    public void runOpMode() {
        Init();

        waitForStart();

        if (opModeIsActive()) {
            // Pre-run
            while (opModeIsActive()) {
                // OpMode loop
                drive.drive(-gamepad1.left_stick_y, gamepad1.left_stick_x, gamepad1.right_stick_x);

                initIntake();

                telemetry.update();

            }
        }
    }
    public void Init() {
        drive = new Mecanum_Driving(hardwareMap);
        action = new ActionClass(hardwareMap);
    }
    public void initIntake() {
        if (gamepad1.a) {
            action.Intake_On();
        } else {
            action.Intake_Off();
        }
        if (gamepad1.b) {
            action.Intake_R();
        }
    }
}