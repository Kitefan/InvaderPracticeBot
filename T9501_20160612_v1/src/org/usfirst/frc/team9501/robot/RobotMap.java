
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
	
	//Define PWM ports on the RoboRio
	public static final int kLeftFrontMotorPWM = 0;
	public static final int kLeftMiddleMotorPWM = 1;
	public static final int kLeftRearMotorPWM = 2;
	public static final int kRightFrontMotorPWM = 3;
	public static final int kRightMiddleMotorPWM = 4;
	public static final int kRghtRearMotorPWM = 5;
	public static final int kIntakeMotorPWM = 6;
	public static final int kFrontCameraTiltPWM = 8;
	
	//Define CAN addresses
	public static final int kTurretMotorCAN = 3;
	public static final int kShooterMotorCAN = 4; 

	//Define digital IO ports on the RoboRio
	public static final int kTargetLockOut2LEDDIO = 0;
	public static final int kShooterOut2LEDDIO = 1;
	public static final int kBallSensorInDIO = 2;
	public static final int kTowerSelectInDIO = 3;
	public static final int kBallSensorOut2LEDDIO = 4;
	public static final int kThumbWheelBit0InDIO = 6; 
	public static final int kThumbWheelBit1InDIO = 7; 
	public static final int kThumbWheelBit2InDIO = 8; 
	public static final int kThumbWheelBit3InDIO = 9; 
	
	//Define Joystic and buttons
	public static final int kJoystickUSBPort = 0;
	public static final int kBtnRunIntakeIn = 5;
	public static final int kBtnRunIntakeOut = 4;
	public static final int joystick1SpeedControl = 11;
	public static final int kBtnKickBall = 1;
	public static final int kBtnRunShooter = 3;
	
	//Define Gamepad and buttons
	public static final int kGamePadUSBPort = 1;
	public static final int kBtnManualAim = 6;
	public static final int kBtnAutoAim = 2;
	public static final int kMiddleLEDTest = 3;
	
	//Define Pneumatic Control Modules and ports
	public static final int kPCM2 = 1;
	public static final int kPCMBallKickerPort = 5;
	
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
}
