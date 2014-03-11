/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tamankeet3933.java2014.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.tamankeet3933.java2014.commands.raw.MoveForwardAuto;

/**
 *
 * @author Ricardo Delfin
 */
public class Autonomous extends CommandGroup {
    
    public Autonomous() {
        addSequential(new MoveForwardAuto());
        addSequential(new Fire());
    }
}