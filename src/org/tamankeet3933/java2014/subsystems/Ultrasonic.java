/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tamankeet3933.java2014.subsystems;

import edu.wpi.first.wpilibj.AnalogChannel;

/**
 * Ultrasonic for our specific ultrasonic sensor with a voltage to centimeters converter
 * @author Ricardo Delfin Delfin
 * @version 1.0
 */
public class Ultrasonic extends AnalogChannel {
    
    private static double VOLTAGE_TO_DISTANCE = 206.472;
    
    public Ultrasonic(int channel) {
        super(channel);
    }
    
    public Ultrasonic(int moduleNumber, int channel) {
        super(moduleNumber, channel);
    }
    
    /**
     * Gets the distance measured by the voltage of the ultrasonic sensor
     * @return The distance in centimetres
     */
    public double getDistance()
    {
        return getAverageVoltage() * VOLTAGE_TO_DISTANCE;
    }
}
