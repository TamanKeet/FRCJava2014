/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tamankeet3933.java2014.commands.raw;
import org.tamankeet3933.java2014.commands.CommandBase;

/**
 *
 * @author analauragarciarivera
 */
public class StopShooter extends CommandBase {
   private boolean stopped;
    
    public StopShooter(double speed) {
        requires(shooterSystem);
        this.stopped= true;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        shooterSystem.stop();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        stopped= true;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return stopped; 
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
