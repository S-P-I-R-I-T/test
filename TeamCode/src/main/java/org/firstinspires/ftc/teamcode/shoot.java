package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.PIDFCoefficients;

@TeleOp(name = "shoot")
public class shoot extends LinearOpMode {

    public DcMotorEx Turret_S;
    public double Target;
    public double P;
    public double F;

    @Override
    public void runOpMode() {
        waitForStart();
        Turret_S = hardwareMap.get(DcMotorEx.class,"Turret_s");
        if (opModeIsActive()) {
            Turret_S.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            while (opModeIsActive()) {
                PIDFCoefficients pidfCoefficients = new PIDFCoefficients(P,0,0, F);
                Turret_S.setPIDFCoefficients(DcMotor.RunMode.RUN_USING_ENCODER, pidfCoefficients);
                if (gamepad1.a) {
                    if (Target == 1000){
                        Target = 2000;
                    }
                    else {
                        Target = 1000;
                    }
                    Turret_S.setVelocity(Target);
                }

            }
        }
    }
}