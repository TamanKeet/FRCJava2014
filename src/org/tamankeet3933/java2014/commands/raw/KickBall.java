/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tamankeet3933.java2014.commands.raw;

import org.tamankeet3933.java2014.RobotTimer;
import org.tamankeet3933.java2014.commands.CommandBase;

/**
 *
 * @author Mariana
 */
public class KickBall extends CommandBase {
   private RobotTimer timer;
   private long counter;
   private long maxTime;
   public KickBall(long time) {
        requires(collectorSystem);
        this.timer = new RobotTimer();
        this.counter = 0;
        this.maxTime = time;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        timer = new RobotTimer();
        kickerSystem.kick();
}
    
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        timer.Update();
        
        counter += timer.getMillisecondsPerFrame();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return counter >= maxTime;
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
