/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tamankeet3933.java2014.commands.raw;

import org.tamankeet3933.java2014.commands.CommandBase;

/**
 *
 * @author david
 */
public class MoveCollector extends CommandBase {
    
    int position;
    double finalPosition;
    boolean stop = false;
    public final double ERROR = 0.01;
    
    public MoveCollector(int position) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        this.position = position;
        requires(collectorSystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        collectorSystem.armPickup(0.4);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
         switch (position)
         {
            case 1:
                finalPosition = collectorSystem.RETRACT;
                break;
            case 2:
                finalPosition = collectorSystem.STORAGE;
                break;
            case 3:
                finalPosition = collectorSystem.EXTEND;
                break;
         }
        
         collectorSystem.setBar(finalPosition, ERROR);
         stop = true;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return stop;
    }

    // Called once after isFinished returns true
    protected void end() {
        collectorSystem.armPickup(0.0);
        stop = false;
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}