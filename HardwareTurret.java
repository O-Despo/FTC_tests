package org.firstinspires.ftc.robotcontroller.external.samples;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

public class HardwareTurret
{
    /* Public OpMode members. */
    public DcMotor leftDrive = null;
    public DcMotor rightDrive = null;
    public DcMotor turretDrive = null;
    public DcMotor turretLaunchDrive = null;
    public Servo diskLaunchServo = null;

    public static final double DRIVE_SPEED_FORWARD = 0.5;
    public static final double DRIVE_SPEED_BACKWARD = -0.5;
    public static final double SERVO_POS = 0.5

    HardwareMap hwMap =  null;

    public HardwarePushbot(){
        // This is called when you want to crete a obj instance
    }

    public void init(HardwareMap ahwMap, bool useEncoders) {
        hwMap = ahwMap;

        leftDrive = hwMap.get(DcMotor.class, "left_drive");
        rightDrive = hwMap.get(DcMotor.class, "right_drive");
        turretDrive = hwMap.get(DcMotor.class, "turret_drive");
        turretLaunchDrive = hwMap.get(DcMotor.class, "turret_launch")
        
        turretLaunchDrive.setDirection(DcMotor.Direction.FORWARD);
        leftDrive.setDirection(DcMotor.Direction.FORWARD);
        rightDrive.setDirection(DcMotor.Direction.REVERSE);

        leftDrive.setPower(0);
        rightDrive.setPower(0);
        turretDrive.setPower(0);
        turretLaunchDrive.setPower(0);

        if (useEncoders = true){
            leftDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            rightDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            turretDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            turretLaunchDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

            leftDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            rightDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            turretDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            turretLaunchDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        }
        else {
            leftDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            rightDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            turretDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            turretLaunchDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        }

        // Define and initialize ALL installed servos.
        diskLaunchServo  = hwMap.get(Servo.class, "left_hand");
        diskLaunchServo.setPosition(SERVO_POS);
    }
 }
