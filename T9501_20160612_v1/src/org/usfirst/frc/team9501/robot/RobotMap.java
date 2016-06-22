
package org.usfirst.frc.team9501.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static int leftMotor = 1;
    // public static int rightMotor = 2;
	public static final int leftFrontMotorPWM = 0;
	public static final int leftMiddleMotorPWM = 1;
	public static final int leftRearMotorPWM = 2;
	public static final int rightFrontMotorPWM = 3;
	public static final int rightMiddleMotorPWM = 4;
	public static final int rightRearMotorPWM = 5;
	public static final int intakeMotorPWM = 6;
	public static final int shooterMotorCAN = 4; 
	public static final int turretMotorCAN = 3;
	public static final int frontCameraTilt = 8;
	
	public static final int thumbWheelDIOBit0 = 6; 
	public static final int thumbWheelDIOBit1 = 7; 
	public static final int thumbWheelDIOBit2 = 8; 
	public static final int thumbWheelDIOBit3 = 9; 
	
	public static final int towerSelectDIO = 3;
	
	public static final int ballSensorDIO = 2;
	
	public static final int joystickUSBPort = 0;
	public static final int btnRunIntakeIn = 5;
	public static final int btnRunIntakeOut = 4;
	public static final int joystick1SpeedControl = 11;
	public static final int btnKickBall = 1;
	public static final int btnRunShooter = 3;
	
	public static final int gamePadUSBPort = 1;
	public static final int btnManualAim = 6;
	public static final int btnAutoAim = 2;
	
	public static final int pcm2 = 1;
	public static final int pcmBallKickerPort = 5;
	
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
}
