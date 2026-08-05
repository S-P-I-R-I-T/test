package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Intake {
    private final DcMotor intake;
    private static final double INTAKE_POWER = 1.0;
    private static final double OUTTAKE_POWER = -1.0;
    public Intake(HardwareMap hardwareMap) {
        intake = hardwareMap.get(DcMotor.class,"intake");

        intake.setDirection(DcMotorSimple.Direction.REVERSE);
        intake.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }
    public void intake() {
        intake.setPower(INTAKE_POWER);
    }
    public void outtake() {
        intake.setPower(OUTTAKE_POWER);
    }
    public void stop() {
        intake.setPower(0);
    }
    public void setPower(double power) {
        intake.setPower(power);
    }
}
