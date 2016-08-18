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
    
	public Shooter(){
		m_shooterMotor.setInverted(true);
	}
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
    
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void spinMotor(){
    	double intakeSpeed = 0.0;
    	intakeSpeed = Math.abs(Robot.m_oi.getJoystick().getRawAxis(2));
    	SmartDashboard.putNumber("Shooter Speed", intakeSpeed);    	
    	m_shooterMotor.set(intakeSpeed);
    }
    
    public void kickBall(){
    	double shooterSpeed = 0;
    	shooterSpeed = this.getSpeed();
    	if (shooterSpeed > 0) {
    		Robot.numberOfShots += 1;
    		SmartDashboard.putNumber("Number of Shots: ", Robot.numberOfShots);
    	}
    	System.out.println("Shooter Motor Speed at Shot: " + shooterSpeed);
    	SmartDashboard.putNumber("Shooter Speed At shot: ",shooterSpeed);
    	SmartDashboard.putNumber("Turret Position at shot: ",Robot.turret.getPosition() );
           	m_kicker.set(true);
    	
    }
    
    public double getSpeed(){
    	return m_shooterMotor.get();
    }
    
    public void retractKicker(){
    	m_kicker.set(false);
    	
    }
    
    public void stopMotor(){
    	m_shooterMotor.set(0.0);
    	SmartDashboard.putNumber("Shooter Speed", this.getSpeed());
    }
}

