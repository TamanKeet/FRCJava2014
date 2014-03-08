/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tamankeet3933.java2014.commands.raw;
import org.tamankeet3933.java2014.commands.CommandBase;

/**
 * Turn on the shooter with a specified speed
 * @author Ana Laura Garcia Rivera
 * @version 1.1
 */
public class StartShooter extends CommandBase {
  
   private double speed;
   private boolean stopped;
    
    public StartShooter(double speed) {
        requires(shooterSystem);
        this.speed = speed;
        this.stopped = false;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        shooterSystem.start(speed);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        stopped = true;
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
