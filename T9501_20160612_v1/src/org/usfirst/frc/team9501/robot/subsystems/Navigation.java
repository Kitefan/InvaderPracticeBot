package org.usfirst.frc.team9501.robot.subsystems;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

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
	private static PIDController turnController = null;
	private static AHRS m_ahrs = null;

	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    public void navInit(){
        try {
            /* Communicate w/navX MXP via the MXP SPI Bus.                                     */
            /* Alternatively:  I2C.Port.kMXP, SerialPort.Port.kMXP or SerialPort.Port.kUSB     */
            /* See http://navx-mxp.kauailabs.com/guidance/selecting-an-interface/ for details. */
            m_ahrs = new AHRS(SPI.Port.kMXP); 
        } catch (RuntimeException ex ) {
            DriverStation.reportError("Error instantiating navX MXP:  " + ex.getMessage(), true);
        }
		turnController = new PIDController(kP, kI, kD, kF, m_ahrs, this);
        turnController.setInputRange(-180.0f,  180.0f);
        turnController.setOutputRange(-1.0, 1.0);
        turnController.setAbsoluteTolerance(kToleranceDegrees);
        turnController.setContinuous(true);

        /* Add the PID Controller to the Test-mode dashboard, allowing manual  */
        /* tuning of the Turn Controller's P, I and D coefficients.            */
        /* Typically, only the P value needs to be modified.                   */
        LiveWindow.addActuator("DriveSystem", "RotateController", turnController);

        
        // Put methods for controlling this subsystem
        // here. Call these from Commands.


    }
    
	@Override
	public void pidWrite(double output) {
		// TODO Auto-generated method stub
		
	}
	
	public void getAngel(){
		m_ahrs.getAngle();
	}

}

