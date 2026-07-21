package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name="wasd")
public class wasd extends LinearOpMode {
    Servo servo;
    double pos = 0;

    boolean dpadupPressed = false;
    boolean dpaddownPressed = false;

    @Override
    public void runOpMode() {
        servo = hardwareMap.get(Servo.class, "servo");
        waitForStart();
        if (opModeIsActive()) {
            // Pre-run
            while (opModeIsActive()) {
                // OpMode loop
                boolean dpadup = gamepad1.dpad_up;
                boolean dpaddown = gamepad1.dpad_down;

                if (gamepad1.a){
                    servo.setPosition(pos);
                }
                else{
                    servo.setPosition(0);
                }
                if(dpadup && !dpadupPressed){
                    pos = pos + 0.01;
                }
                if(dpaddown && !dpaddownPressed){
                    pos = pos - 0.01;

                }
                telemetry.addData("지금 pos의 값", pos);
                dpadupPressed = dpadup;
                dpaddownPressed = dpaddown;
                telemetry.update();
            }
        }
    }
}