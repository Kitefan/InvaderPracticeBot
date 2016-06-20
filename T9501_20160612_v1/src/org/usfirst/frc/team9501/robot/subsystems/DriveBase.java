package org.usfirst.frc.team9501.robot.subsystems;

import org.usfirst.frc.team9501.robot.RobotMap;
import org.usfirst.frc.team9501.robot.commands.Drive;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveBase extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private Victor m_leftFrontMotor = new Victor(RobotMap.leftFrontMotorPWM);
	private Victor m_rightFrontMotor = new Victor(RobotMap.rightFrontMotorPWM);
	private Victor m_leftRearMotor = new Victor(RobotMap.leftRearMotorPWM);
	private Victor m_rightRearMotor = new Victor(RobotMap.rightRearMotorPWM);
	//private RobotDrive m_driveBase = new RobotDrive(RobotMap.leftRearMotorPWM,RobotMap.rightRearMotorPWM);
    private RobotDrive m_driveBase = new RobotDrive(m_leftFrontMotor,m_leftRearMotor, m_rightFrontMotor,m_rightRearMotor);


    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	m_rightFrontMotor.setInverted(true);
    	m_leftFrontMotor.setInverted(true);
    	m_rightRearMotor.setInverted(true);
    	m_leftRearMotor.setInverted(true);
    	setDefaultCommand(new Drive());
    }
    
    public void drive(Joystick stick){
    	m_driveBase.arcadeDrive(stick);
    }
    
    public void stopDriving(){
    	m_driveBase.arcadeDrive(0.0,0.0);
    }
    
    public void driveStraight() {
    	
    }
}

