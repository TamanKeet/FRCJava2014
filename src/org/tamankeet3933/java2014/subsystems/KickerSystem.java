/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tamankeet3933.java2014.subsystems;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.tamankeet3933.java2014.RobotMap;

/**
 *
 * @author Ricardo Delfin
 */
public class KickerSystem extends Subsystem {
    
    Talon motor;
    
    public KickerSystem()
    {
        motor = RobotMap.impulserMotor;
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void kick()
    {
        motor.set(1);
    }
    
    public void reset()
    {
        motor.set(-1);
    }
    
    public void stop()
    {
        motor.set(0);
    }
}