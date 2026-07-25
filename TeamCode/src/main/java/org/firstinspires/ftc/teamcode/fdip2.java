package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.PIDFCoefficients;

@TeleOp(name = "fdip2")
public class fdip2 extends LinearOpMode {
    public DcMotorEx Turret_S;
    public static double shooting_velocity = 2000;
    public static double preheat_velocity = 1000;
    public static double f = 17;
    public static double p = 200;

    @Override
    public void runOpMode() {
        Turret_S = hardwareMap.get(DcMotorEx.class,"Turret_S");
        Turret_S.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        Turret_S.setDirection(DcMotor.Direction.FORWARD);

        PIDFCoefficients pidfCoefficients = new PIDFCoefficients(p,0,0,f);
        Turret_S.setPIDFCoefficients(DcMotor.RunMode.RUN_USING_ENCODER, pidfCoefficients);
        telemetry.addLine("Init complete");

        if (opModeIsActive()) {
            // Pre-run
            while (opModeIsActive()) {
                Turret_S.setVelocity(shooting_velocity);// OpMode loop

            }
        }
    }
}