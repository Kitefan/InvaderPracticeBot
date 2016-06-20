package org.usfirst.frc.team9501.robot.subsystems;

import org.usfirst.frc.team9501.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Turret extends Subsystem {
	
	CANTalon m_turret = new CANTalon(RobotMap.turretMotorCAN);

    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
    	m_turret.changeControlMode(TalonControlMode.Position);
    
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void manualRotate(Joystick m_stick2){
    	m_turret.changeControlMode(TalonControlMode.PercentVbus);
    	m_turret.set(m_stick2.getX() * 0.2);
    	System.out.println("turret counter " + m_turret.getPosition());
    }
    
    public void autoAim(){
    	m_turret.changeControlMode(TalonControlMode.Position);
    	m_turret.set(0);
    	System.out.println("turret counter " + m_turret.getPosition());
    }
    
    public void stop(){
    	m_turret.set(0.0);
    }
}

