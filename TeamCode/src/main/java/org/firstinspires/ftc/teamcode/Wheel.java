package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.opencv.core.Mat;

public class Wheel {
    private final DcMotor fl;
    private final DcMotor fr;
    private final DcMotor rl;
    private final DcMotor rr;
    private static final double NORMAL_SPEED = 0.7;
    private static final double Slow_MULTIPLIER = 0.5;
    public Wheel(HardwareMap hardwareMap) {
        fl = hardwareMap.get(DcMotor.class,"fl");
        rl = hardwareMap.get(DcMotor.class,"rl");
        fr = hardwareMap.get(DcMotor.class,"fr");
        rr = hardwareMap.get(DcMotor.class,"rr");

        fl.setDirection(DcMotorSimple.Direction.REVERSE);
        rl.setDirection(DcMotorSimple.Direction.REVERSE);

        fr.setDirection(DcMotorSimple.Direction.FORWARD);
        rr.setDirection(DcMotorSimple.Direction.FORWARD);

        DcMotor[] motors = {fl, fr, rl, rr};
        for (DcMotor motor : motors) {
            motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        }
    }

    public void drive(double axial,double lateral,double yaw,boolean slow) {

        double speed = slow ? NORMAL_SPEED * Slow_MULTIPLIER : NORMAL_SPEED;
        double flpower = axial + lateral + yaw;
        double frpower = axial - lateral - yaw;
        double rlpower = axial - lateral + yaw;
        double rrpower = axial + lateral - yaw;

        double max = Math.max(
                Math.max(Math.abs(flpower), Math.abs(frpower)),
                Math.max(Math.abs(rlpower), Math.abs(rrpower))
        );
        if (max > 1.0) {
            flpower /= max;
            frpower /= max;
            rlpower /= max;
            rrpower /= max;

        }

        fl.setPower(flpower * speed);
        fr.setPower(frpower * speed);
        rl.setPower(rlpower * speed);
        rr.setPower(rrpower * speed);
    }
    public void stop() {
        fl.setPower(0);
        fr.setPower(0);
        rl.setPower(0);
        rr.setPower(0);
    }
}
