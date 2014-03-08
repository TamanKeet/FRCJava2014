/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tamankeet3933.java2014.commands;

/**
 * Default command of the drive system. Uses joystick for movement.
 * @author Paco Huelsz Prince
 * @version  1.0
 */
public class Drive extends CommandBase {
    
    public Drive() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(driveSystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        driveSystem.drive(oi.driveX.get(), oi.driveY.get());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
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