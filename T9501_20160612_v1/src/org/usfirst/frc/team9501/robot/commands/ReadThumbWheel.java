package org.usfirst.frc.team9501.robot.commands;

import org.usfirst.frc.team9501.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ReadThumbWheel extends Command {

    public ReadThumbWheel() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.twheel);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.twheel.GetThumbWheelValue();
    	System.out.println("Thumb Wheel Value: " + Robot.twheel.GetThumbWheelValue());
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.twheel.GetThumbWheelValue();
    	System.out.println("Thumb Wheel Value: " + Robot.twheel.GetThumbWheelValue());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
