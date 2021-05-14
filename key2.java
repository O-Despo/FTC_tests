package org.firstinspires.ftc.robotcontroller.external.samples;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "Concept: Ramp Motor Speed", group = "Concept")
public class ConceptRampMotorSpeed extends OpMode {

    
    public void init() {
        private DcMotor turret = null;

        turretDrive = hardwareNap.get(DcMotor.class, "turret_drive");
        turretDrive.setDirection(DcMotor.Direction.FORWARD);

        telemetry.addData("Status", "Initialized");
    }
    @Override
    public void init_loop() {
    }

    @Override
    public void start() {
        runtime.reset();
    }

    @Override
    public void loop() {
        // Setup a variable for each drive wheel to save power level for telemetry
        double power;
        double stickInput = -gamepad1.left_stick_y;
        double power = Range.clip(power + stickInput, -1.0, 1.0) ;
        turretDrive.setPower(power);
    }

    public void stop(){}
    }
}
