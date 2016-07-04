package org.usfirst.frc.team9501.robot.subsystems;

import org.usfirst.frc.team9501.robot.Robot;
import org.usfirst.frc.team9501.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Shooter extends Subsystem {
	private CANTalon m_shooterMotor = new CANTalon(RobotMap.kShooterMotorCAN);
	private Solenoid m_kicker = new Solenoid(RobotMap.kPCM2,RobotMap.kPCMBallKickerPort);
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
    
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void spinMotor(){
    	m_shooterMotor.set(0.2);
    	
    }
    
    public void kickBall(){
    	System.out.println("Shooter Motor Speed: " + this.getSpeed());
    	SmartDashboard.putNumber("Shooter Speed", this.getSpeed());
       	SmartDashboard.putNumber("Turret Position at shot",Robot.turret.getPosition() );
           	m_kicker.set(true);
    	
    }
    
    public double getSpeed(){
    	return m_shooterMotor.getOutputVoltage();
    }
    
    public void retractKicker(){
    	m_kicker.set(false);
    	
    }
    
    public void stopMotor(){
    	m_shooterMotor.set(0.0);
    }
}

