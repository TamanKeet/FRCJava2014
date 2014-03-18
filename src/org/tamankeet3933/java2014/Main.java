/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.tamankeet3933.java2014;


import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import org.tamankeet3933.java2014.commands.CommandBase;

/**
 * Robot class that runs by default through the Virtual Machine. It manages commands, teleop and
 * autonomous. All code runs from here
 * @author Ricardo Delfin Garcia
 * @version 1.0
 */
public class Main extends IterativeRobot {

    //==========================================================================
    //========================= Commands =======================================
    //==========================================================================
    
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialisation code.
     */
    public void robotInit() {
        // Initialize all subsystems
        CommandBase.init();
    }

    public void autonomousInit() {
        // schedule the autonomous command (example)
        CommandList.autonomousCommand.start();
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
        CommandList.autonomousCommand.cancel();
        CommandList.catchShooterCommand.cancel();
        CommandList.fireCommand.cancel();
        CommandList.lowPassCommand.cancel();
        CommandList.passCommand.cancel();
        CommandList.pickUpBallCommand.cancel();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        
        if(CommandBase.oi.abortButton.get())
        {
            if(CommandList.fireCommand.isRunning())
                CommandList.fireCommand.cancel();
            
            if(CommandList.catchShooterCommand.isRunning())
                CommandList.fireCommand.cancel();
            
            if(CommandList.passCommand.isRunning())
                CommandList.passCommand.cancel();
            
            if(CommandList.pickUpBallCommand.isRunning())
                CommandList.pickUpBallCommand.cancel();
            
            if(CommandList.lowPassCommand.isRunning())
                CommandList.lowPassCommand.cancel();
        }
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
