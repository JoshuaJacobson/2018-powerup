package org.usfirst.frc.team3618.robot.commands;

import org.usfirst.frc.team3618.robot.Robot;
import org.usfirst.frc.team3618.robot.subsystems.LiftSubsystem;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LeftAutonomousCommand extends CommandGroup {

    public LeftAutonomousCommand() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    	String gameData;
		gameData = DriverStation.getInstance().getGameSpecificMessage();
                if(gameData.length() > 0)
                {
		  if(gameData.charAt(0) == 'L')
		  {
			System.out.println("Started Left");
			Robot.kDriveSubsystem.resetRobotAngle();
			addSequential(new AutoDriveCommand(170,0));
			addSequential(new WaitCommand(), 1);
			addSequential(new AutoLiftCommand(LiftSubsystem.LIFT_SWITCH_HEIGHT));
			addSequential(new WaitCommand(), 0.5);
			addSequential(new AutoTurnCommand(90));
			addSequential(new WaitCommand(), 1);
			addSequential(new AutoDriveCommand(15,90));
			addSequential(new AutoPivotCommand(),0.5);
			addSequential(new WaitCommand(), 1);
			addSequential(new AutoOuttakeCommand(), 1);
		  } else if (gameData.charAt(0) == 'R') {
			addSequential(new AutoDriveCommand(220,0));
			addSequential(new WaitCommand(), 1);
			addSequential(new AutoTurnCommand(90));
			addSequential(new WaitCommand(), 1);
			addSequential(new AutoDriveCommand(80, 90));
			addSequential(new WaitCommand(), 1);
			addSequential(new AutoLiftCommand (LiftSubsystem.LIFT_SWITCH_HEIGHT));
			addSequential(new AutoTurnCommand(180));
			addSequential(new WaitCommand(), 1);
			addSequential(new AutoPivotCommand(),0.5);
			addSequential(new WaitCommand(), 1);
			addSequential(new AutoOuttakeCommand(), 1);

			//Put right auto code here
		  }
                }
    }
}
