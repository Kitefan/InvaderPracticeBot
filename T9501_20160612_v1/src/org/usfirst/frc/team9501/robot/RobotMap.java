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
	public static int leftFrontMotorPWM = 0;
	public static int leftMiddleMotorPWM = 1;
	public static int leftRearMotorPWM = 2;
	public static int rightFrontMotorPWM = 3;
	public static int rightMiddleMotorPWM = 4;
	public static int rightRearMotorPWM = 5;
	public static int intakeMotorPWM = 6;
	
	public static int frontCameraTilt = 8;
	
	public static int thumbWheelDIOBit0 = 6; 
	public static int thumbWheelDIOBit1 = 7; 
	public static int thumbWheelDIOBit2 = 8; 
	public static int thumbWheelDIOBit3 = 9; 
	
	public static int joystickUSBPort = 0;
	public static int btnRunIntakeIn = 5;
	public static int btnRunIntakeOut = 4;
	public static int joystick1SpeedControl = 11;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
}
