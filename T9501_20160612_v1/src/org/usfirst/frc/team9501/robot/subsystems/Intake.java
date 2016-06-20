package org.usfirst.frc.team9501.robot.subsystems;

import org.usfirst.frc.team9501.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Intake extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private TalonSRX m_intakeMotor = new TalonSRX(RobotMap.intakeMotorPWM);
	private DigitalInput m_ballSenser = new DigitalInput(RobotMap.ballSensorDIO);

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void runIn() {
    	m_intakeMotor.set(0.1);
    }
    
    public void runOut() {
    	m_intakeMotor.set(-0.1);
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

