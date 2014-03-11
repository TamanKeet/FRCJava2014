/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tamankeet3933.java2014.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.tamankeet3933.java2014.commands.raw.KickBall;
import org.tamankeet3933.java2014.commands.raw.MoveCollector;
import org.tamankeet3933.java2014.commands.raw.RetractKicker;
import org.tamankeet3933.java2014.commands.raw.StartShooter;
import org.tamankeet3933.java2014.commands.raw.StopShooter;
import org.tamankeet3933.java2014.commands.raw.Wait;
import org.tamankeet3933.java2014.subsystems.CollectorSystem;

/**
 *
 * @author Ricardo Delfin
 */
public class Fire extends CommandGroup {
    
    public Fire() {
        addSequential(new StartShooter(1));
        addSequential(new Wait(1000));
        addParallel(new KickBall());
        addSequential(new MoveCollector(CollectorSystem.RETRACT));
        addSequential(new Wait(300));
        addParallel(new RetractKicker());
        addParallel(new MoveCollector(CollectorSystem.STORAGE));
        addSequential(new StopShooter());
    }
}