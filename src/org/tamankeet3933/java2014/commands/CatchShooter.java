/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tamankeet3933.java2014.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.tamankeet3933.java2014.commands.raw.MoveCollector;
import org.tamankeet3933.java2014.commands.raw.StartRoller;
import org.tamankeet3933.java2014.commands.raw.StartShooter;
import org.tamankeet3933.java2014.commands.raw.StopRoller;
import org.tamankeet3933.java2014.commands.raw.StopShooter;
import org.tamankeet3933.java2014.commands.raw.WaitForClick;
import org.tamankeet3933.java2014.subsystems.CollectorSystem;

/**
 *
 * @author Ricardo Delfin
 * @version 1.0
 */
public class CatchShooter extends CommandGroup {
    
    public CatchShooter() {
        
        addSequential(new StartShooter(-1));
        addSequential(new StartRoller(1));
        addSequential(new MoveCollector(CollectorSystem.EXTEND));
        addSequential(new WaitForClick(CommandBase.oi.catchDoneButton));
        addSequential(new StopShooter());
        addSequential(new MoveCollector(CollectorSystem.STORAGE));
        addSequential(new StopRoller());
    }
}