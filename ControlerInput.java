package org.firstinspires.ftc.robotcontroller.external.samples;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name="Controller OpMode", group="Controller Opmode")
@Disabled
public class Controller_OpMode extends LinearOpMode {

    // Declare OpMode members
    HardwareTurret robot = new HardwareTurret();
    private ElapsedTime runtime = new ElapsedTime();

    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();
        
        double turretForwardSpeed = 1;
        double turretBackwardSpeed = -1;

        robot.init(HardwareMap, False);

        waitForStart();
        runtime.reset();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {

            //Steering Code
            boolean leftBumper;
            boolean rightBumper;

            double leftPower;
            double rightPower;
            
            double drive = -gamepad1.left_stick_y;
            double turn  =  gamepad1.right_stick_x;

            leftPower = Range.clip(drive + turn, -1.0, 1.0) ;
            rightPower = Range.clip(drive - turn, -1.0, 1.0) ;

            leftDrive.setPower(leftPower);
            rightDrive.setPower(rightPower);

            telemetry.addData("Status", "Run Time: " + runtime.toString());
            telemetry.addData("Motors", "left (%.2f), right (%.2f)", leftPower, rightPower);
            telemetry.update();

            //Turret Code
            boolean leftBumper = gamepad1.left_bumper;
            boolean rightBumper = gamepad1.right_bumper;

            if (leftBumper = true) {
                turretDrive.setPower(turretForwardSpeed);
            }
            else if (right_bumper = true) {
                turretDrive.setPower(turretBackwardSpeed);
            }
            else {
                turretDrive.setPower(0);
            }

            boolean fireButton = gamepad1.a;

            if (fireButton = true) {
                turretDrive.setPower(10);
                diskLaunchServo.setPosition(1.0);
                turretDrive.setPower(0);
                diskLaunchServo.setPosition(0.0);
            }

        }

    }
}