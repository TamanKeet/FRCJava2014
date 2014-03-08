/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tamankeet3933.java2014;

import edu.wpi.first.wpilibj.Joystick;

/**
 *
 * @author Ricardo Delfin
 */
public class JoystickAxis {
    int axisIndex;
    private Joystick j;
    private boolean isSpeedAxis;
    private double deadCentre;
    private boolean invert;
    
    public JoystickAxis()
    {
        axisIndex = 1;
        j = null;
        isSpeedAxis = false;
        deadCentre = 0;
        invert = false;
    }
    
    public JoystickAxis(Joystick j, double deadCentre, boolean isSpeedAxis, int axisIndex, boolean invert)
    {
        this.axisIndex = axisIndex;
        this.j = j;
        this.isSpeedAxis = isSpeedAxis;
        this.deadCentre = deadCentre;
        this.invert = invert;
    }
    
    public double get()
    {
        double val = j.getRawAxis(axisIndex);
        
        if(isSpeedAxis)
            val = 1 - ((val + 1) / 2);
        
        val = Util.deadCentre(deadCentre, val, 1);
        
        val *= (invert ? -1 : 1);
        
        return val;
    }
}
