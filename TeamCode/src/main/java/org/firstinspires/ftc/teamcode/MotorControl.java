package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import java.lang.annotation.Target;

public class MotorControl {
    private DcMotor motor;
    private static final String Motor_Name = "motor";

    public MotorControl(HardwareMap hardwareMap) {
        motor = hardwareMap.get(DcMotor.class,"Motor_Name");
        motor.setDirection(DcMotorSimple.Direction.FORWARD);
        motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }
    public void setPower(double power) {
        motor.setPower(power);
    }
    public void stop() {
        motor.setPower(0);
    }
    public int getCurrentPosition() {
        return motor.getCurrentPosition();
    }
    public void moveToPosition(int targetPosition, double power) {
        motor.setTargetPosition(targetPosition);
        motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motor.setPower(power);
    }
    public void resetToRunMode() {
        motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }
}
