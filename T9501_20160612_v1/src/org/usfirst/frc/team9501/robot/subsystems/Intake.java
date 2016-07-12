package org.usfirst.frc.team9501.robot.subsystems;

import org.usfirst.frc.team9501.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Intake extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private TalonSRX m_intakeMotor = new TalonSRX(RobotMap.kIntakeMotorPWM);
	private DigitalInput m_ballSenser = new DigitalInput(RobotMap.kBallSensorInDIO);
	private double m_motorSpeed = 0.5; 
	

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	m_ballSenser.get();
    }
    
    public void runIn() {
    	SmartDashboard.getNumber("Intake Speed");
    	m_intakeMotor.set(m_motorSpeed);
    	SmartDashboard.putNumber("Intake Speed", m_motorSpeed);
    }
    
    public void runOut() {
    	SmartDashboard.getNumber("Intake Speed");
    	m_intakeMotor.set(-m_motorSpeed);
    	SmartDashboard.putNumber("Intake Speed", m_motorSpeed);
    }
    
    public void stop(){
    	m_intakeMotor.set(0.0);
    }
    
    public boolean haveBall(){
    	return m_ballSenser.get();
    }
    
    public void runInSlowly(){
    	m_intakeMotor.set(0.1);
    }
}

