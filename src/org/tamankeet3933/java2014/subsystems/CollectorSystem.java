/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tamankeet3933.java2014.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.tamankeet3933.java2014.RobotMap;

/**
 * Collector system. Uses a potentiometer to measure the position of the arm
 * @author Paco Huelsz Prince
 * @version  2.1
 */
public class CollectorSystem extends Subsystem {
    //External use variables, used to feed the "setBar" method
    public static final double RETRACT = 2.47;
    public static final double EXTEND  = 4.35;
    public static final double STORAGE = 3.0;
    
    //Internal use variables
    private final double pK = 0.5;
    private final double LINE_SEPARATION = 0.08;
    private final double ERROR = 0.15;
    
    public boolean setBar(double finalPos){
        double realPos  = getPosition();
        double motionSpeed = pK;
        double diff = 0;
        
        if(finalPos<realPos){
            motionSpeed = motionSpeed*-1;
        }
        
        diff = finalPos-getPosition();
        
        if(diff > 0)
                RobotMap.armMovementMotor.set(pK*diff + 0.08);
            else
                RobotMap.armMovementMotor.set(pK*diff - 0.08);
        
        
        if(diff  < ERROR)
        {
            RobotMap.armMovementMotor.set(0);
            return true;
        }
        
        return false;
    }
    
    public void armPickup(double speed)
    {
        RobotMap.armPickupMotor.set(speed);
    }
    
    private double getPosition(){
        return RobotMap.armMovementPositionSensor.get();
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}