/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tamankeet3933.java2014.commands.raw;

import org.tamankeet3933.java2014.commands.CommandBase;

/**
 * 
 * This class moves the arm pick up system and the collector arm to three 
 * different positions according to the user input.
 * @author David Dominguez Moises
 * @version 1.0
 */
public class MoveCollector extends CommandBase {
    
    // Used to stop the program.
    boolean stop;
    
    // Range of error for the position of the collector arm.
    public final double ERROR;
    
    public double position;
    
    // Stores the user input in the variable position.
    public MoveCollector(int position) {

        requires(collectorSystem);
        this.position = position;
        stop = false;
        ERROR = 0.01;
    }

    // Sets the speed of the arm pick up system to 0.4 .
    protected void initialize() {
    }

    /*
       Analises the variable position and stores the correspondant position 
       constant to the variable finalPosition and calls the method setBar with the variable finalPosition.
    */
    protected void execute() {
        
         stop = collectorSystem.setBar(position, ERROR);
    }

    // Returns true when the execute method ends.
    protected boolean isFinished() {
        return stop;
    }

    // Stops the arm pick up system.
    protected void end() {
        collectorSystem.armPickup(0.0);
        stop = false;
    }

    // Calls the end method.
    protected void interrupted() {
        end();
    }
}
