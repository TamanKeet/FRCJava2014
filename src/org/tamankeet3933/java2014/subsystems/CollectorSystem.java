/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tamankeet3933.java2014.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.tamankeet3933.java2014.RobotMap;

/**
 *
 * @author PACO
 * @version  2.0
 */
public class CollectorSystem extends Subsystem {
    //External use variables, used to feed the "setBar" method
    public final double RETRACT = 1.0;
    public final double EXTEND  = 1;
    public final double STORAGE = 4.0;
    
    //Internal use variables
    public final double SPEED = 0.4;
    
    
    public boolean setBar(double finalPos, double error){
        double realPos  = getPosition();
        double motionSpeed = SPEED;
        double diff = 0;
        
        if(finalPos<realPos){
            motionSpeed = motionSpeed*-1;
        }
        
        RobotMap.armMovementMotor.set(motionSpeed);
        
        diff = Math.abs(finalPos-getPosition());
        
        if(diff  < error)
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