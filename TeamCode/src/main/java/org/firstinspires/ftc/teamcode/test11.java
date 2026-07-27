package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class test11 {
    DcMotor motor1;

    public void init(HardwareMap hardwareMap){

        motor1 = hardwareMap.get(DcMotor.class,"motor1");
        motor1.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motor1.setDirection(DcMotorSimple.Direction.FORWARD);
        motor1.setPower(0.5);
    }
}
