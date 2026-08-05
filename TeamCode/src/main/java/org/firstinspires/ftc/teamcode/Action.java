package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "Action")
public class Action extends LinearOpMode {
    ActionClass action;

    @Override
    public void runOpMode() {
        Init();
        waitForStart();

        while (opModeIsActive()) {
            initAction();
            telemetry.update();
        }
    }

    public void Init() {
        action = new ActionClass(hardwareMap);
    }

    public void initAction() {
        if (gamepad2.right_trigger > 0.1) {
            action.shoot();
        } else if (gamepad2.left_trigger > 0.1) {
            action.preheat();
        } else {
            action.shootMotor.setVelocity(0);
        }

        if (gamepad2.a) {
            action.Intake_On();
        } else if (gamepad2.b) {
            action.Intake_R();
        } else {
            action.Intake_Off();
        }
    }
}