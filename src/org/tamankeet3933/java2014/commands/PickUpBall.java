/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tamankeet3933.java2014.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.tamankeet3933.java2014.commands.raw.MoveCollector;
import org.tamankeet3933.java2014.commands.raw.PickUpWithRoller;
import org.tamankeet3933.java2014.subsystems.CollectorSystem;

/**
 *
 * @author Ricardo Delfin
 */
public class PickUpBall extends CommandGroup {
    
    public PickUpBall()
    {
        addSequential(new MoveCollector(CollectorSystem.EXTEND));
        addParallel(new MoveCollector(CollectorSystem.STORAGE));
        addSequential(new PickUpWithRoller());
    }
}