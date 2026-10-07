package org.firstinspires.ftc.teamcode;

/*
 CONTROL HUB PORT SETUP
Motor port 0: frontLeft
Motor port 1: frontRight
Motor port 2: backLeft
Motor port 3: backRight

Servo port 0:
Servo port 1:
Servo port 2:
Servo port 3:
Servo port 5:

EXPANSION HUB PORT SETUP

Motor port 0:
Motor port 1:
Motor port 2:
Motor port 3:

Servo port 0:
Servo port 1:
Servo port 2:
Servo port 3:
Servo port 5:

*/




//  IMPORTS

// Standard DC Motor
import com.qualcomm.robotcore.hardware.DcMotor;

// Connects our Java code to the physical hardware configured in the REV Hardware Client.
import com.qualcomm.robotcore.hardware.HardwareMap;

// Timer utility.  Timing will become useful as we continue building our robot programs.
import com.qualcomm.robotcore.util.ElapsedTime;


public class BlueHardwareMap {

    // DRIVE MOTORS

    public DcMotor frontLeft = null;
    public DcMotor frontRight = null;
    public DcMotor backLeft = null;
    public DcMotor backRight = null;

    //  FTC HARDWARE MAP
    /*
The HardwareMap allows our Java program to find the physical devices that have been configured in the REV Hardware Client.  The names in the HardwareMap must match the names we use when we retrieve the motors.
     */

    private HardwareMap hardwareMap = null;

    //  INITIALIZE HARDWARE
    /*
      init()
     This method connects the Java variables to the physical motors on the robot.
     The hardware names inside quotation marks must match the names configured in the REV Hardware Client.
     */

    public void init(HardwareMap ahwMap) {

        // Connect the HardwareMap
        /*
        The OpMode gives us a HardwareMap.
         We store that HardwareMap in our class so that we can use it to find our motors.
         */

        hardwareMap = ahwMap;

        // Motor Name Declarations

        /* The name inside quotation marks must match the name in the REV Hardware Client.
         */

        frontLeft = hardwareMap.get(DcMotor.class,"frontLeft");
        frontRight = hardwareMap.get(DcMotor.class, "frontRight");
        backLeft =hardwareMap.get(DcMotor.class, "backLeft");
        backRight =hardwareMap.get(DcMotor.class,"backRight");

        // MOTOR DIRECTIONS

        /*
Motor direction tells the robot how each motor interprets positive power.
Because the motors are mounted in different orientations, some motors may need to be reversed.
The goal is for positive power on all four motors to make the robot move forward.
         */

        frontLeft.setDirection(DcMotor.Direction.FORWARD);
        frontRight.setDirection(DcMotor.Direction.REVERSE);
        backLeft.setDirection(DcMotor.Direction.FORWARD);
        backRight.setDirection(DcMotor.Direction.REVERSE);

        // INITIAL MOTOR POWER
        /*
We begin with all motors turned off.
         */

        frontLeft.setPower(0);
        frontRight.setPower(0);
        backLeft.setPower(0);
        backRight.setPower(0);



        // INITIAL MOTOR MODE
        /*
         RUN_WITHOUT_ENCODER
At this point in our programming sequence, we are using motor power to control movement.
We are not yet asking the robot to measure distance using encoders.
Encoders will be introduced in a later lesson.
         */

        frontLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        frontRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

    } // end init()

//Methods

    public void stopMotors(long timeMilliseconds)  throws InterruptedException {
        //stops all motors for a designated amount of time

        frontLeft.setPower(0);
        frontRight.setPower(0);
        backLeft.setPower(0);
        backRight.setPower(0);

        Thread.sleep(timeMilliseconds);

    } // end stopMotors()


    public void driveStraight(double power, long timeMilliseconds)
            throws InterruptedException {

    /*
This method moves the robot forward or backward.
The robot moves for a specified amount of time.
Positive power: Robot moves forward.
Negative power: Robot moves backward.
All four wheels receive the same power.
             */

        frontLeft.setPower(power);
        frontRight.setPower(power);
        backLeft.setPower(power);
        backRight.setPower(power);

        // Continue Moving for the Requested Time

        Thread.sleep(timeMilliseconds);

        stopMotors(100);

    } // end driveStraight()

    public void strafeSideways(double power, long timeMilliseconds)
            throws InterruptedException {

/*
Mecanum wheels allow the robot to move sideways.
Positive power: Robot moves to the right.
Negative power: Robot moves to the left.
*/

        frontLeft.setPower(power);
        frontRight.setPower(-power);
        backLeft.setPower(-power);
        backRight.setPower(power);

        Thread.sleep(timeMilliseconds);
        stopMotors(100);

    } // end strafeSideways()
    public void diagonalQ1and3(double power, long timeMs) throws InterruptedException {
        frontLeft.setPower(power);
        frontRight.setPower(0);
        backLeft.setPower(0);
        backRight.setPower(power);

    }// end diagonalQ1and3

    public void diagonalQ2and4(double power, long timeMs) throws InterruptedException {

        frontLeft.setPower(0);
        frontRight.setPower(power);
        backLeft.setPower(power);
        backRight.setPower(0);

    }// end diagonalQ2and4

} // end BlueHardwareMap