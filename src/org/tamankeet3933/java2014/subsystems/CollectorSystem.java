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
 */
public class CollectorSystem extends Subsystem {
    //External use variables, used to feed the "setBar" method
    public final double RETRACT = 1.0;
    public final double EXTEND  = 1;
    public final double STORAGE = 4.0;
    
    //Internal use variables
    public final double SPEED = 0.4;
    
    
    public boolean setBar(int finalPos){
        double realPos  = getPosition();
        double motionSpeed = SPEED;
        double diff = 0;
        
        if(finalPos<realPos){
            motionSpeed = motionSpeed*-1;
        }
        
        RobotMap.armMovementMotor.set(motionSpeed);
        do{
            diff = Math.abs(finalPos-getPosition());
        }while(diff>0.03);
        
        RobotMap.armMovementMotor.set(0);
        
        return true;
    }
    
    private double getPosition(){
        return RobotMap.armMovementPositionSensor.get();
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}