/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tamankeet3933.java2014.commands.raw;

import org.tamankeet3933.java2014.commands.CommandBase;

/**
 *
 * @author Ricardo Delfin
 */
public class StartRoller extends CommandBase {
    
    private boolean finished;
    
    public StartRoller() {
        requires(collectorSystem);
        finished = false;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        collectorSystem.armPickup(1);
        finished = true;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return finished;
    }

    // Called once after isFinished returns true
    protected void end() {
        finished = false;
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}