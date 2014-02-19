/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tamankeet3933.java2014.commands.raw;

import org.tamankeet3933.java2014.commands.CommandBase;

/**
 * 
 * This class drives the robot to the optimal fire position
 * based on the distance obtained from the ultrasonic sensor.
 * @author David Dominguez Moises
 * @version 1.0
 */
public class MoveToFirePos extends CommandBase {
    
    // Constant that defines the optimal fire position.
    public static final double DISTANCE_TO_FIRE  = 20;
    
    // Used to stop this program.
    boolean stopDriving = false;
    
    public MoveToFirePos() {
        requires(driveSystem);
    }

    // Sets the speed of the chasis wheels to 0.5 .
    protected void initialize() {
        driveSystem.drive(.5, 0);
    }

    /* Ends the program when the robot is in the desired position,
       with an error range of 1.  */
    protected void execute() {
        if (driveSystem.getUltrasonic() <= DISTANCE_TO_FIRE + 1 || driveSystem.getUltrasonic() >= DISTANCE_TO_FIRE - 1)
	{
            stopDriving = true;
	}
    }

    protected boolean isFinished() {
        return stopDriving;
    }

    // Stops the robot.
    protected void end() {
        driveSystem.drive(0, 0);
        stopDriving = false;
    }

    // Calls the end method.
    protected void interrupted() {
        end();
    }
}
