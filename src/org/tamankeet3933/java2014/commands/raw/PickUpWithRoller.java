/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tamankeet3933.java2014.commands.raw;

import org.tamankeet3933.java2014.RobotTimer;
import org.tamankeet3933.java2014.commands.CommandBase;

/**
 * Activates the roller on the robot for a determined amount of time, here 2 seconds
 * @author Mariana
 * @version 1.0
 */
public class PickUpWithRoller extends CommandBase {
    
    RobotTimer timer;
    long counter;
    final static long TIME = 3000;
    
    public PickUpWithRoller() {
        requires(collectorSystem);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        collectorSystem.armPickup(1);
        timer = new RobotTimer();
        counter = 0;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        timer.Update();
        
        counter += timer.getMillisecondsPerFrame();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return counter >= TIME;
    }

    // Called once after isFinished returns true
    protected void end() {
        collectorSystem.armPickup(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
