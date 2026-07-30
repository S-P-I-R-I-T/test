package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Mecanum_Driving;

@TeleOp
public class Drive extends LinearOpMode {



    @Override
    public void runOpMode() {

        Mecanum_Driving drive = new Mecanum_Driving(hardwareMap);

        waitForStart();

        while (opModeIsActive()) {
            drive.drive(-gamepad1.left_stick_y, gamepad1.left_stick_x, gamepad1.right_stick_x);

        }

        drive.stop();
    }

}