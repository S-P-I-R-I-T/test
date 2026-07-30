package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name="aa")
public class aa extends LinearOpMode {

    ActionClass act;


    @Override
    public void runOpMode() {

        act = new ActionClass(hardwareMap);

        waitForStart();

        if (opModeIsActive()) {
            // Pre-run
            while (opModeIsActive()) {
                Intake();
            }
        }
    }
    void Intake(){
        if (gamepad1.a){
            act.Intake_On();
        }
        else if (gamepad1.b) {
            act.Intake_Off();
        }
        else {
            act.Intake_R();
        }
    }
}