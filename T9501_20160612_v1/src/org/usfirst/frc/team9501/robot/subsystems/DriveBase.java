package org.usfirst.frc.team9501.robot.subsystems;

import org.usfirst.frc.team9501.robot.RobotMap;
import org.usfirst.frc.team9501.robot.commands.Drive;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * This is the 4 motor drivebase for Invader.
 * @author mattbrown
 * 
 */
public class DriveBase extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	/**
	 * 
	 *  set the motor member variables using values from the RobotMap.
	 */
	private Victor m_leftFrontMotor = new Victor(RobotMap.kLeftFrontMotorPWM);
	private Victor m_rightFrontMotor = new Victor(RobotMap.kRightFrontMotorPWM);
	private Victor m_leftRearMotor = new Victor(RobotMap.kLeftRearMotorPWM);
	private Victor m_rightRearMotor = new Victor(RobotMap.kRghtRearMotorPWM);
	//private RobotDrive m_driveBase = new RobotDrive(RobotMap.kLeftRearMotorPWM,RobotMap.rightRearMotorPWM);
    private RobotDrive m_driveBase = new RobotDrive(m_leftFrontMotor,m_leftRearMotor, m_rightFrontMotor,m_rightRearMotor);

    /**
     *  For some reason all these motors ran backward.  We double checked
     *  the PWM ports and they are correct. We double check right and left and
     *  they are also correct. Instead of changing the order of motors
     *  in the variable we decided to invert all the motors.
     */
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	m_rightFrontMotor.setInverted(true);
    	m_leftFrontMotor.setInverted(true);
    	m_rightRearMotor.setInverted(true);
    	m_leftRearMotor.setInverted(true);
    	setDefaultCommand(new Drive());
    }
    
    /**
     * drive is the basic arcade drive command for the robot. It gets the
     * input from our joystick defined in the Robot.OI class
     * @param stick
     */
    public void drive(Joystick stick){
    	m_driveBase.arcadeDrive(stick);
    }
    
    /**
     * stopDriving sends the all stop to all 4 motors.
     */
    public void stopDriving(){
    	m_driveBase.arcadeDrive(0.0,0.0);
    }
    
    /**
     * TODO
     * driveStraight will utilize the navX board to keep the robot going
     * in a straight line.
     */
    public void driveStraight() {
    	
    }
}

