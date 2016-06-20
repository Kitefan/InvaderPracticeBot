
package org.usfirst.frc.team9501.robot;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team9501.robot.commands.Drive;
import org.usfirst.frc.team9501.robot.commands.RunIntakeIn;
//import org.usfirst.frc.team9501.robot.commands.Drive;
import org.usfirst.frc.team9501.robot.subsystems.DriveBase;
import org.usfirst.frc.team9501.robot.subsystems.Intake;
import org.usfirst.frc.team9501.robot.subsystems.Shooter;
import org.usfirst.frc.team9501.robot.subsystems.ThumbWheel;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static final DriveBase driveBase = new DriveBase();
	public static final ThumbWheel twheel = new ThumbWheel();
	public static final Intake intake = new Intake();
	public static final Shooter shooter = new Shooter();
	public static final Compressor compressor = new Compressor();
	public static OI m_oi = new OI();

    Command autonomousCommand;
    SendableChooser chooser;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	compressor.start();
        chooser = new SendableChooser();
        chooser.addDefault("Default Auto", new Drive());
        chooser.addObject("Run Intake", new RunIntakeIn());
        SmartDashboard.putData("Auto mode", chooser);
    }
	
	/**
     * This function is called once each time the robot enters Disabled mode.
     * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
     */
    public void disabledInit(){

    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select between different autonomous modes
	 * using the dashboard. The sendable chooser code works with the Java SmartDashboard. If you prefer the LabVIEW
	 * Dashboard, remove all of the chooser code and uncomment the getString code to get the auto name from the text box
	 * below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the chooser code above (like the commented example)
	 * or additional comparisons to the switch structure below with additional strings & commands.
	 */
    public void autonomousInit() {
    	twheel.GetTowerSelect();
    	twheel.GetThumbWheelValue();
    	System.out.println("TowerSelect Value: " + (twheel.GetTowerSelect()==0?"Left":"Right"));
    	System.out.println("Thumb Wheel Value: " + twheel.GetThumbWheelValue());
        autonomousCommand = (Command) chooser.getSelected();
        
		String autoSelected = SmartDashboard.getString("Auto Selector", "Default");
		switch(autoSelected) {
		case "Run Intake":
			autonomousCommand = new RunIntakeIn();
			break;
		case "Default Auto":
		default:
			autonomousCommand = new Drive();
			break;
		} 
    	
    	// schedule the autonomous command (example)
//        if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
//        if (autonomousCommand != null) autonomousCommand.cancel();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
