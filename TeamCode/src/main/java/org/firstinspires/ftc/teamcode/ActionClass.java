package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.PIDFCoefficients;

public class ActionClass {
    //pdif
    public DcMotorEx shootMotor;
    public static double shooting_velocity = 2000;
    public static double preheat_velocity = 1000;
    public static double f = 17;
    public static double p = 200;

    //intake
    public DcMotorEx intakeMotor;
    public ActionClass(HardwareMap hardwareMap) {
        //pdif
        shootMotor = hardwareMap.get(DcMotorEx.class,"shootMotor");
        shootMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        shootMotor.setDirection(DcMotor.Direction.FORWARD);
        PIDFCoefficients pidfCoefficients = new PIDFCoefficients(p,0,0,f);
        shootMotor.setPIDFCoefficients(DcMotor.RunMode.RUN_USING_ENCODER, pidfCoefficients);

        //intake
        intakeMotor = hardwareMap.get(DcMotorEx.class,"intakeMotor");
        intakeMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        intakeMotor.setDirection(DcMotor.Direction.FORWARD);
    }
    //pdif
    public void shoot() {
        shootMotor.setVelocity(shooting_velocity);
    }
    public void preheat() {
        shootMotor.setVelocity(preheat_velocity);
    }

    //intake
    public void Intake_On(){
        intakeMotor.setPower(1);
    }
    public void Intake_R(){
        intakeMotor.setPower(-1);
    }
    public void Intake_Off(){
        intakeMotor.setPower(0);
    }
}
