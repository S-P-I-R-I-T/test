package org.firstinspires.ftc.teamcode;

import static android.os.Build.VERSION_CODES.P;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.PIDFCoefficients;

@TeleOp(name = "fdip")
public class fdip extends OpMode {
    public DcMotorEx Turret_S;
    public static double shooting_velocity = 2000;
    public static double preheat_velocity = 1000;

    public static double f = 20;
    public static double p = 200;

    @Override
    public void init() {
        Turret_S = hardwareMap.get(DcMotorEx.class,"Turret_S");
        Turret_S.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        Turret_S.setDirection(DcMotor.Direction.FORWARD);

        PIDFCoefficients pidfCoefficients = new PIDFCoefficients(p,0,0,f);
        Turret_S.setPIDFCoefficients(DcMotor.RunMode.RUN_USING_ENCODER, pidfCoefficients);
        telemetry.addLine("Init complete");
    }

    @Override
    public void loop() {
        PIDFCoefficients pidfCoefficients = new PIDFCoefficients(p,0,0,f);
        Turret_S.setPIDFCoefficients(DcMotor.RunMode.RUN_USING_ENCODER,pidfCoefficients);
        double curTargetVelocity = 1;
        Turret_S.setVelocity(curTargetVelocity);
    }
}
