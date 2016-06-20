package org.usfirst.frc.team9501.robot.subsystems;

import org.usfirst.frc.team9501.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Shooter extends Subsystem {
	private CANTalon m_shooterMotor = new CANTalon(RobotMap.shooterMotorCAN);
	private Solenoid m_kicker = new Solenoid(RobotMap.pcm2,RobotMap.pcmBallKickerPort);
    
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
    	System.out.println("Shooter Motor Speed: " + m_shooterMotor.getSpeed());
    	m_kicker.set(true);
    	
    }
    
    public void retractKicker(){
    	m_kicker.set(false);
    	
    }
    
    public void stopMotor(){
    	m_shooterMotor.set(0.0);
    }
}

