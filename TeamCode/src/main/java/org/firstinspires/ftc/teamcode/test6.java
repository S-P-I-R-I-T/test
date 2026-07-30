package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "test6")
public class test6 extends LinearOpMode {
    ActionClass action;

    @Override
    public void runOpMode() {
        initIntake();
        Init();

        waitForStart();

        if (opModeIsActive()) {
            while (opModeIsActive()) {
                // OpMode loop
                telemetry.update();
            }
        }
    }
    public void Init() {
        action = new ActionClass(hardwareMap);
    }

    public void initIntake() {
        if (gamepad1.a) {
            action.Intake_On();
        } else {
            action.Intake_Off();
        }
    }
}