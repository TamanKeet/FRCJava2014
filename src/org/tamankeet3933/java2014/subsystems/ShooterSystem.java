/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tamankeet3933.java2014.subsystems;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.tamankeet3933.java2014.RobotMap;
/*import org.tamankeet3933.java2014.subsystems.pid.LeftShooter;
import org.tamankeet3933.java2014.subsystems.pid.RightShooter;*/

/**
 * Subsystem for the Shooter. Only uses the two shooter motors and their respective encoders.
 * It uses PID to regulate the speed of the motors respectively
 * @author Ricardo Delfin Garcia
 * @version 1.0
 */
public class ShooterSystem extends Subsystem {
    
    
    /*LeftShooter leftShooter;
    RightShooter rightShooter;*/
    Victor leftMotor;
    Victor rightMotor;
    
    /**
     * Default constructor
     */
    ShooterSystem()
    {
        leftMotor = RobotMap.leftShooterMotor;
        rightMotor = RobotMap.rightShooterMotor;
        /*leftShooter = new LeftShooter();
        rightShooter = new RightShooter();*/
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    /**
     * Start the shooter with a specific speed output
     * @param speed The speed at which it goes (from -1 to 1)
     */
    public void start(double speed)
    {
        /*leftShooter.setSetpoint(speed);
        rightShooter.setSetpoint(-speed);*/
        
        //Needs to be inverted so both go in the same direction
        leftMotor.set(-speed);
        rightMotor.set(speed);
    }
    
    /**
     * Stops both motors using a speed of 0
     */
    public void stop()
    {
        start(0);
        /*leftShooter.setSetpoint(0);
        rightShooter.setSetpoint(0);*/
    }
}