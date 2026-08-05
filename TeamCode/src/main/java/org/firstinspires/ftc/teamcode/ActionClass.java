package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.CRServo;
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

    //슈퍼 스피드 서보
    public CRServo wheel1;
    public CRServo wheel2;

    //이걸 바꿔서 휠 코드 충돌 방지
    //발사할 때 shoot = true
    public boolean shoot = false;
    public boolean intake = false;

    public ActionClass(HardwareMap hardwareMap) {
        //pdif
        shootMotor = hardwareMap.get(DcMotorEx.class,"shootMotor");
        shootMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        shootMotor.setDirection(DcMotor.Direction.FORWARD);
        PIDFCoefficients pidfCoefficients = new PIDFCoefficients(p,0,0,f);
        shootMotor.setPIDFCoefficients(DcMotor.RunMode.RUN_USING_ENCODER, pidfCoefficients);

        //intake
        intakeMotor = hardwareMap.get(DcMotorEx.class,"intakeMotor");
        intakeMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        intakeMotor.setDirection(DcMotor.Direction.FORWARD);

        //슈퍼 스피드 서보
        wheel1 = hardwareMap.get(CRServo.class,"wheel1");
        wheel2 = hardwareMap.get(CRServo.class,"wheel2");
        wheel1.setDirection(CRServo.Direction.FORWARD);
        wheel2.setDirection(CRServo.Direction.REVERSE);
    }
    //pdif
    public void shoot() {
        shootMotor.setVelocity(shooting_velocity);
        wheel1.setPower(-1);
        wheel2.setPower(-1);

    }
    public void preheat() {
        shootMotor.setVelocity(preheat_velocity);
    }
    public void stop(){
        shootMotor.setVelocity(0);
    }

    //intake & 슈퍼 스피드 서보
    public void Intake_On(){
        intakeMotor.setPower(1);
        if(shoot == false){
            wheel1.setPower(1);
            wheel2.setPower(1);
        }
    }
    public void Intake_R(){
        intakeMotor.setPower(-1);
        wheel1.setPower(-1);
        wheel2.setPower(-1);
    }
    public void Intake_Off(){
        intakeMotor.setPower(0);
        wheel1.setPower(0);
        wheel2.setPower(0);

    }

}
