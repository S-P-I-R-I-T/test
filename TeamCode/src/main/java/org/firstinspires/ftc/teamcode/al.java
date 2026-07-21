package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "al")
public class al extends LinearOpMode {
    DcMotor fl,fr,rl,rr;
    Servo servo;

    @Override
    public void runOpMode() {
        waitForStart();

        if (opModeIsActive()) {
            // Pre-run
            servo = hardwareMap.get(Servo.class,"servo");
            fl = hardwareMap.get(DcMotor.class,"fl");
            fr = hardwareMap.get(DcMotor.class,"fr");
            rl = hardwareMap.get(DcMotor.class,"rl");
            rr = hardwareMap.get(DcMotor.class,"rr");
            while (opModeIsActive()) {
                // OpMode loop
                servo();
            }

        }
    }

    void servo() {
        if (gamepad1.a){
            servo.setPosition(1);
        }else {
            servo.setPosition(0);
        }
    }
}