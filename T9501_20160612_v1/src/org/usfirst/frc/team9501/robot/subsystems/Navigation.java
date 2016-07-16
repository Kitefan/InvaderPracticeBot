package org.usfirst.frc.team9501.robot.subsystems;

import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.command.Subsystem;
import com.kauailabs.navx.frc.AHRS;



/**
 *
 */
public class Navigation extends Subsystem implements PIDOutput{
	/* The following PID Controller coefficients will need to be tuned */
	/* to match the dynamics of your drive system.  Note that the      */
	/* SmartDashboard in Test mode has support for helping you tune    */
	/* controllers by displaying a form where you can enter new P, I,  */
	/* and D constants and test the mechanism.                         */

	static final double kP = 0.03;
	static final double kI = 0.00;
	static final double kD = 0.00;
	static final double kF = 0.00;

	static final double kToleranceDegrees = 2.0f;
	private  AHRS m_ahrs = new AHRS(SPI.Port.kMXP); 


	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    public void navInit(){
        
    	this.resetAll();
        this.zeroYaw();
        
        // Put methods for controlling this subsystem
        // here. Call these from Commands.


    }
    
	@Override
	public void pidWrite(double output) {
		// TODO Auto-generated method stub
		
	}
	
	public double getAngel(){
		return m_ahrs.getAngle();
	}
	
	public void zeroYaw(){
		m_ahrs.zeroYaw();
	}
	
	public void resetAll(){
		m_ahrs.reset();
	}
	
	public float getPitch(){
		return m_ahrs.getPitch();
	}

}

