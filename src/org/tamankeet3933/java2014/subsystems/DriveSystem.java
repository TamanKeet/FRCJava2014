package org.tamankeet3933.java2014.subsystems;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.tamankeet3933.java2014.RobotMap;

/**
 * Subsystem in charge of moving the chassis wheels.
 * @author Ricardo Delfin
 * @version 1.0
 */
public class DriveSystem extends Subsystem {
    
    Jaguar leftWheel = RobotMap.leftWheelMotor;
    Jaguar rightWheel = RobotMap.rightWheelMotor;
    RobotDrive drive = new RobotDrive(leftWheel, rightWheel);
    
    public void initDefaultCommand() {
        
    }
    
    public void drive(int moveVal, int rotateVal)
    {
        drive.arcadeDrive(moveVal, rotateVal);
    }
}