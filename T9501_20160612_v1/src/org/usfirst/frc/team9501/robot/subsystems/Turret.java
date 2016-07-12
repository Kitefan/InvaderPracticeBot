package org.usfirst.frc.team9501.robot.subsystems;

import org.usfirst.frc.team9501.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Turret extends Subsystem {
	
	CANTalon m_turret = new CANTalon(RobotMap.kTurretMotorCAN);
	private static DigitalOutput m_bottomLEDs = new DigitalOutput(RobotMap.kBallSensorOut2LEDDIO);
	private static DigitalOutput m_middleLEDs = new DigitalOutput(RobotMap.kShooterOut2LEDDIO);
	private static DigitalOutput m_topLEDs = new DigitalOutput(RobotMap.kTargetLockOut2LEDDIO);
	private static boolean m_midLEDStatus = false;
	private static boolean m_botLEDStatus = false;
    private static boolean m_topLEDStatus = false;
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
    	m_turret.changeControlMode(TalonControlMode.Position);
    	m_topLEDs.set(false);
    	m_middleLEDs.set(false);
    	m_bottomLEDs.set(false);
    
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void manualRotate(Joystick m_stick2){
    	m_turret.changeControlMode(TalonControlMode.PercentVbus);
    	m_turret.set(m_stick2.getX() * 0.2);
       	SmartDashboard.putNumber("Turret Position",this.getPosition() );
    	//System.out.println("turret counter " + m_turret.getPosition());
    }
    
    public void autoAim(){
    	m_turret.changeControlMode(TalonControlMode.Position);
    	m_turret.set(0);
       	SmartDashboard.putNumber("Turret Position",this.getPosition() );
    	//System.out.println("turret counter " + m_turret.getPosition());
    }
    
    public void stop(){
    	m_turret.set(0.0);
    }
    
    public double getPosition(){
    	return m_turret.getPosition();
    }
    
    public void setTopLEDs(boolean onOff){
    	m_topLEDs.set(onOff);
    	m_topLEDStatus = onOff;
    }
    
    public void setMiddleLEDs(boolean onOff){
    	m_middleLEDs.set(onOff);
    	m_midLEDStatus = onOff;
    }
    
    public void setBottomLEDs(boolean onOff){
    	m_bottomLEDs.set(onOff);
    	m_botLEDStatus = onOff;
    	//System.out.println("bottom LEDs " + (onOff ? "true": "false"));
    }
    
    public boolean getTopLEDs(){
    	return m_topLEDStatus;
    }

    public boolean getBottomLEDs(){
    	return m_botLEDStatus;
    }

    public boolean getMiddleLEDs(){
    	return m_midLEDStatus;
    }


}

