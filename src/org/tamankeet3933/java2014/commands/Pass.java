/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tamankeet3933.java2014.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.tamankeet3933.java2014.commands.raw.MoveCollector;
import org.tamankeet3933.java2014.commands.raw.StartShooter;
import org.tamankeet3933.java2014.commands.raw.StopShooter;
import org.tamankeet3933.java2014.commands.raw.Wait;
import org.tamankeet3933.java2014.subsystems.CollectorSystem;

/**
 *
 * @author Ricardo Delfin
 */
public class Pass extends CommandGroup {
    
    public Pass() {
        
        addSequential(new StartShooter(1));
        //Wait for motor startup
        addSequential(new Wait(1000));
        
        addSequential(new MoveCollector(CollectorSystem.RETRACT));
        //Wait for the ball to completely pass through
        addSequential(new Wait(200));
        
        //Retract all
        addParallel(new StopShooter());
        addSequential(new MoveCollector(CollectorSystem.STORAGE));
    }
}