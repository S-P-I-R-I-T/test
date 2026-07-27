package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp(name = "test33")
public class test33 extends LinearOpMode {

    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor fl = null;
    private DcMotor rl = null;
    private DcMotor fr = null;
    private DcMotor rr = null;

    @Override
    public void runOpMode() {

        // Initialize the hardware variables. Note that the strings used here must correspond
        // to the names assigned during the robot configuration step on the DS or RC devices.
        fl = hardwareMap.get(DcMotor.class, "fl");
        rl = hardwareMap.get(DcMotor.class, "rl");
        fr = hardwareMap.get(DcMotor.class, "fr");
        rr = hardwareMap.get(DcMotor.class, "rr");

        fl.setDirection(DcMotor.Direction.REVERSE);
        rl.setDirection(DcMotor.Direction.REVERSE);
        fr.setDirection(DcMotor.Direction.FORWARD);
        rr.setDirection(DcMotor.Direction.FORWARD);

        // Wait for the game to start (driver presses START)
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();
        runtime.reset();
        if (opModeIsActive()) {
            // Pre-run
            while (opModeIsActive()) {
                double max;

                double axial   = -gamepad1.left_stick_y;
                double lateral =  gamepad1.left_stick_x;
                double yaw     =  gamepad1.right_stick_x;

                double flPower  = axial + lateral + yaw;
                double frPower = axial - lateral - yaw;
                double rlPower   = axial - lateral + yaw;
                double rrPower  = axial + lateral - yaw;

                max = Math.max(Math.abs(flPower), Math.abs(frPower));
                max = Math.max(max, Math.abs(rlPower));
                max = Math.max(max, Math.abs(rrPower));

                if (max > 1.0) {
                    flPower  /= max;
                    frPower /= max;
                    rlPower   /= max;
                    rrPower  /= max;
                }

                fl.setPower(flPower);
                fr.setPower(frPower);
                rl.setPower(rlPower);
                rr.setPower(rrPower);

                telemetry.addData("Status", "Run Time: " + runtime.toString());
                telemetry.addData("Front left/Right", "%4.2f, %4.2f", flPower, frPower);
                telemetry.addData("Back  left/Right", "%4.2f, %4.2f", rlPower, rrPower);
                telemetry.update();
            }
        }
    }
}