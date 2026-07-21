package org.firstinspires.ftc.teamcode;

import static org.firstinspires.ftc.teamcode.FlywheelPIDF_test.PREHEAT_VELOCITY;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.PIDFCoefficients;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "pidf")
public class pidf extends LinearOpMode {

    public DcMotorEx Turret_S;
    public static double SHOOTING_VELOCITY = 2000;
    public static double PREHEAT_VELOCITY  = 1000;
    double curTargetVelocity = PREHEAT_VELOCITY;
    public static double F = 17;
    public static double P = 200;

    @Override
    public void runOpMode() {
        waitForStart();
        Turret_S = hardwareMap.get(DcMotorEx.class,"Turret_S");
        Turret_S.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        Turret_S.setDirection(DcMotor.Direction.FORWARD);
        PIDFCoefficients pidfCoefficients = new PIDFCoefficients(P,0,0, F);
        Turret_S.setPIDFCoefficients(DcMotor.RunMode.RUN_USING_ENCODER, pidfCoefficients);


        if (opModeIsActive()) {
            // Pre-run
            while (opModeIsActive()) {
                // OpMode loop
                if(gamepad1.yWasPressed()){
                    if(curTargetVelocity == PREHEAT_VELOCITY){
                        curTargetVelocity = SHOOTING_VELOCITY;
                    }
                    else{
                        curTargetVelocity = PREHEAT_VELOCITY;
                    }
                }
                Turret_S.setVelocity(curTargetVelocity);
            }
        }
    }
}