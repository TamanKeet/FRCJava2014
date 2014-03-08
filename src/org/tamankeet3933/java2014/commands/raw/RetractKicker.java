/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tamankeet3933.java2014.commands.raw;
import org.tamankeet3933.java2014.RobotTimer;
import org.tamankeet3933.java2014.commands.CommandBase;

/**
 * Return the kicker to the original position
 * @author Paco Huelsz Prince
 * @version 1.0
 */
public class RetractKicker extends CommandBase {
    
    RobotTimer timer;
    long counter;
    final static long TIME = 500;
    
    public RetractKicker() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(kickerSystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        timer = new RobotTimer();
        counter = 0;
        kickerSystem.reset();
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
        kickerSystem.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}