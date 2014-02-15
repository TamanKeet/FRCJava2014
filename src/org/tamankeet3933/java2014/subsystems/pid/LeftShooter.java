/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tamankeet3933.java2014.subsystems.pid;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import org.tamankeet3933.java2014.RobotMap;

/**
 *
 * @author Ricardo Delfin
 */
public class LeftShooter extends PIDSubsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    Victor motor = RobotMap.leftShooterMotor;
    Encoder encoder = RobotMap.leftShooterEncoder;
    
    public LeftShooter()
    {
        super("Left Shooter", 2, 1, 1, 1);
        setAbsoluteTolerance(0.2);
        getPIDController().setContinuous(false);
    }
    

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    protected double returnPIDInput() {
        return encoder.getRate();
    }

    protected void usePIDOutput(double output) {
        motor.pidWrite(output);
    }
}