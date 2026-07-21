
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name = "Test")
public class Test extends LinearOpMode {

    DcMotor fl,fr,rl,rr;

    @Override
    public void runOpMode() {
        waitForStart();
        fl = hardwareMap.get(DcMotor.class,"fl");
        fr = hardwareMap.get(DcMotor.class,"fr");
        rl = hardwareMap.get(DcMotor.class,"rl");
        rr = hardwareMap.get(DcMotor.class,"rr");

        if (opModeIsActive()) {
            // Pre-run
            fl.setDirection(DcMotorSimple.Direction.REVERSE);
            rl.setDirection(DcMotorSimple.Direction.REVERSE);
            while (opModeIsActive()) {
                if (gamepad1.a){
                    fl.setPower(1);
                    fr.setPower(1);
                    rl.setPower(1);
                    rr.setPower(1);
                }
                else if (gamepad1.b){
                    fl.setPower(-1);
                    fr.setPower(-1);
                    rl.setPower(-1);
                    rr.setPower(-1);
                }
                else if (gamepad1.x){
                    fl.setPower(-1);
                    fr.setPower(1);
                    rl.setPower(1);
                    rr.setPower(-1);
                }
                else{
                    fl.setPower(0);
                    fr.setPower(0);
                    rl.setPower(0);
                    rr.setPower(0);
                }
            }
        }
    }
}