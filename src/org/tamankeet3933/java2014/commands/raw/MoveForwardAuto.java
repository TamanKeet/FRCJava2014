/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tamankeet3933.java2014.commands.raw;

import org.tamankeet3933.java2014.RobotTimer;
import org.tamankeet3933.java2014.commands.CommandBase;

/**
 * Command that moves the robot forward for the aditional points. 
 * @author Ricardo Delfin Garcia
 * @Version 1.0
 */
public class MoveForwardAuto extends CommandBase {
    
    RobotTimer timer;
    long counter;
    static final long TIME = 1000;
    
    public MoveForwardAuto() {
        requires(driveSystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        driveSystem.drive(0.75, 0);
        counter = 0;
        timer = new RobotTimer();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        counter += timer.getMillisecondsPerFrame();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return counter >= TIME;
    }

    // Called once after isFinished returns true
    protected void end() {
        driveSystem.drive(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}