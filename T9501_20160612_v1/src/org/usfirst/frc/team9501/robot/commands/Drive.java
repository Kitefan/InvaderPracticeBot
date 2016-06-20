package org.usfirst.frc.team9501.robot.commands;

import org.usfirst.frc.team9501.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Drive extends Command {

    public Drive() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.driveBase);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.driveBase.drive(Robot.m_oi.getJoystick());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveBase.stopDriving();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.driveBase.stopDriving();
    }
}
