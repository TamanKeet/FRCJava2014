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
 * Class for the PID controlled right shooter. ONLY used for the ShooterSystem class.
 * @author Ricardo Delfin Garcia
 * @version 1.0
 */
public class RightShooter extends PIDSubsystem
{
    Victor motor = RobotMap.rightShooterMotor;
    Encoder encoder = RobotMap.rightShooterEncoder;
    
    public RightShooter()
    {
        super(2, 1, 1, 1);
        setAbsoluteTolerance(0.2);
        getPIDController().setContinuous(false);
    }
    
    public void initDefaultCommand()
    {
        
    }

    protected double returnPIDInput()
    {
        return encoder.getRate();
    }

    protected void usePIDOutput(double output)
    {
        motor.pidWrite(output);
    }
}