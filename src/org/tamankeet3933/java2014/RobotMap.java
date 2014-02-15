package org.tamankeet3933.java2014;

import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    /*===============================================================================================
      ======================================= PORTS =================================================
      ===============================================================================================*/
    
    //MOTORS (PWM)
    
    private static final int LEFT_WHEEL_MOTOR_PORT = 1;
    private static final int RIGHT_WHEEL_MOTOR_PORT = 2;
    private static final int LEFT_SHOOTER_MOTOR_PORT = 3;
    private static final int RIGHT_SHOOTER_MOTOR_PORT = 4;
    private static final int ARM_MOVEMENT_MOTOR_PORT = 5;
    private static final int ARM_PICKUP_MOTOR_PORT = 6;
    private static final int IMPULSER_MOTOR_PORT = 7;
    
    //DIGITAL SENSORS
    
    private static final int[] LEFT_WHEEL_ENCODER_PORTS = {1, 2};
    private static final int[] RIGHT_WHEEL_ENCODER_PORTS = {3, 4};
    private static final int[] LEFT_SHOOTER_ENCODER_PORTS = {5, 6};
    private static final int[] RIGHT_SHOOTER_ENCODER_PORTS = {7, 8};
    
    //ANALOGUE SENSORS
    
    static final int ARM_MOVEMENT_POSITION_SENSOR_PORT = 1;
    static final int ULTRASONIC_PORT = 2;
    
    /*===============================================================================================
      ====================================== OBJECTS ================================================
      ===============================================================================================*/
    
    //MOTORS
    
    public static Jaguar leftWheelMotor = new Jaguar(LEFT_WHEEL_MOTOR_PORT);
    public static Jaguar rightWheelMotor = new Jaguar(RIGHT_WHEEL_MOTOR_PORT);
    public static Victor leftShooterMotor = new Victor(LEFT_SHOOTER_MOTOR_PORT);
    public static Victor rightShooterMotor = new Victor(RIGHT_SHOOTER_MOTOR_PORT);
    public static Victor armMovementMotor = new Victor(ARM_MOVEMENT_MOTOR_PORT);
    public static Talon armPickupMotor = new Talon(ARM_PICKUP_MOTOR_PORT);
    public static Jaguar impulserMotor = new Jaguar(IMPULSER_MOTOR_PORT);
    
    public static Encoder leftWheelEncoder = new Encoder(LEFT_WHEEL_ENCODER_PORTS[0], LEFT_WHEEL_ENCODER_PORTS[1]);
    public static Encoder rightWheelEncoder = new Encoder(RIGHT_WHEEL_ENCODER_PORTS[0], RIGHT_WHEEL_ENCODER_PORTS[1]);
    public static Encoder leftShooterEncoder = new Encoder(LEFT_SHOOTER_ENCODER_PORTS[0], LEFT_SHOOTER_ENCODER_PORTS[1]);
    public static Encoder rightShooterEncoder = new Encoder(RIGHT_SHOOTER_ENCODER_PORTS[0], RIGHT_SHOOTER_ENCODER_PORTS[1]);
    public static Potentiometer armMovementPositionSensor = new AnalogPotentiometer(ARM_MOVEMENT_POSITION_SENSOR_PORT);
    public static AnalogChannel ultrasonic = new AnalogChannel(ULTRASONIC_PORT);
    
}
