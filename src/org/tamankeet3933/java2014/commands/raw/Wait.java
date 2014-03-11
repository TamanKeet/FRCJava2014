/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tamankeet3933.java2014.commands.raw;

import org.tamankeet3933.java2014.RobotTimer;
import org.tamankeet3933.java2014.commands.CommandBase;

/**
 * Command to pause for a given amount of milliseconds (for timing between commands)
 * @author Ricardo Delfin
 */
public class Wait extends CommandBase {
    
    RobotTimer timer;
    final long TIME;
    long counter;
    public Wait(long time) {
        TIME = time;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        counter = 0;
        timer = new RobotTimer();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        counter += timer.getMillisecondsPerFrame();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return counter > TIME;
    }

    // Called once after isFinished returns true
    protected void end() {
        
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        
    }
}