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
    
    // Stores the user input.
    int position;
    
    // Stores the desired position for the collector arm.
    double finalPosition;
    
    // Used to stop the program.
    boolean stop = false;
    
    // Range of error for the position of the collector arm.
    public final double ERROR = 0.01;
    
    // Stores the user input in the variable position.
    public MoveCollector(int position) {

        this.position = position;
        requires(collectorSystem);
    }

    // Sets the speed of the arm pick up system to 0.4 .
    protected void initialize() {
        collectorSystem.armPickup(0.4);
    }

    /*
       Analises the variable position and stores the correspondant position 
       constant to the variable finalPosition and calls the method setBar with the variable finalPosition.
    */
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
