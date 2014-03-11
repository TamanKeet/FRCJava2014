package org.tamankeet3933.java2014.subsystems;

import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.tamankeet3933.java2014.RobotMap;
import org.tamankeet3933.java2014.commands.Drive;

/**
 * Subsystem in charge of moving the chassis wheels.
 * @author Ricardo Delfin
 * @version 1.2
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
        setDefaultCommand(new Drive());
    }
    
    /**
     * Method to drive the robot with a move and rotate value. Currently, only passes de arguments
     * to an arcadeDrive
     * @param moveVal Magnitude of the movement vector
     * @param rotateVal Angle (rotation) of the movement vector
     */
    public void drive(double moveVal, double rotateVal)
    {
        drive.arcadeDrive(moveVal, rotateVal);
    }
    
    /**
     * Gets the value of the distance with the ultrasonic
     * @return The scaled value of the ultrasonic in metres (because no one likes imperial system)
     */
    public double getUltrasonic()
    {
        return ultrasonic.getAverageVoltage() * RobotMap.ULTRASONIC_TO_INCHES;
    }
}