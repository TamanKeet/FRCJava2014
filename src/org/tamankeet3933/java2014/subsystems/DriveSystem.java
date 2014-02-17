package org.tamankeet3933.java2014.subsystems;

import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.tamankeet3933.java2014.RobotMap;

/**
 * Subsystem in charge of moving the chassis wheels.
 * @author Ricardo Delfin
 * @version 1.1
 */
public class DriveSystem extends Subsystem {
    
    Jaguar leftWheel;
    Jaguar rightWheel;
    RobotDrive drive;
    AnalogChannel ultrasonic;
    
    public DriveSystem()
    {
        ultrasonic = RobotMap.ultrasonic;
        leftWheel = RobotMap.leftWheelMotor;
        rightWheel = RobotMap.rightWheelMotor;
        drive = new RobotDrive(leftWheel, rightWheel);
    }
    
    public void initDefaultCommand() {
        
    }
    
    public void drive(int moveVal, int rotateVal)
    {
        drive.arcadeDrive(moveVal, rotateVal);
    }
    
    public double getUltrasonic()
    {
        return ultrasonic.getAverageVoltage() * RobotMap.ULTRASONIC_TO_INCHES;
    }
}