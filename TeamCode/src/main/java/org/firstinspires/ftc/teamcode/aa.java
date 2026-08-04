package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name="aa")
public class aa extends LinearOpMode {

    ActionClass act;
    Mecanum_Driving md;


    @Override
    public void runOpMode() {

        act = new ActionClass(hardwareMap);
        md = new Mecanum_Driving(hardwareMap);

        waitForStart();

        if (opModeIsActive()) {
            // Pre-run
            while (opModeIsActive()) {
                md.drive(-gamepad1.left_stick_y, gamepad1.left_stick_x, gamepad1.right_stick_x);
                Intake();
            }
        }
    }
    void Intake(){
        if (gamepad1.a){
            act.Intake_On();
        }
        else if (gamepad1.b) {
            act.Intake_R();
        }
        else {
            act.Intake_Off();
        }
    }
}