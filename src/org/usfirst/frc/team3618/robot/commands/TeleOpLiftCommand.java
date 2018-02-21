package org.usfirst.frc.team3618.robot.commands;

import org.usfirst.frc.team3618.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class TeleOpLiftCommand extends Command {
	static final double LIFT_SPEED = 0.3;
    public TeleOpLiftCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.kLiftSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	SmartDashboard.putNumber("Current lift voltage",Robot.kLiftSubsystem.getCurrentLiftHeight());
    	SmartDashboard.putBoolean("Lift limit switch value", Robot.kLiftSubsystem.isLiftDown());
    	SmartDashboard.putNumber("Encoder value", Robot.kLiftSubsystem.getEncoderValue());
    	if (Robot.m_oi.functionController.getRawAxis(1) > 0.1 || Robot.m_oi.functionController.getRawAxis(1) < -0.1) {
    		Robot.kLiftSubsystem.moveLift(Robot.m_oi.functionController.getRawAxis(1) / 2);
    	} else {
    		Robot.kLiftSubsystem.moveLift(0);
    	}
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