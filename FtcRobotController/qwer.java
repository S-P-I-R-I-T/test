package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp(name = "_20260716 (Blocks to Java)")
public class _20260716 extends LinearOpMode {

    private DcMotor fl;

    /**
     * This sample contains the bare minimum Blocks for any regular OpMode. The 3 blue Comment
     * Blocks show where to place Initialization code (runs once, after touching the DS INIT
     * button, and before touching the DS Start arrow), Run code (runs once, after touching
     * Start), and Loop code (runs repeatedly while the OpMode is active, namely not Stopped).
     */
    @Override
    public void runOpMode() {
        ElapsedTime time2;

        fl = hardwareMap.get(DcMotor.class, "fl");

        // Put initialization blocks here.
        waitForStart();
        if (opModeIsActive()) {
            // Put run blocks here.
            time2 = new ElapsedTime();
            while (opModeIsActive()) {
                // Put loop blocks here.
                if (gamepad1.a) {
                    time2.reset();
                }
                if (3 <= time2.seconds()) {
                    fl.setPower(1);
                }
                telemetry.update();
            }
        }
    }
}