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
    
    public PickUpBall() {
        
        addSequential(new MoveCollector(CollectorSystem.EXTEND));
        addParallel(new MoveCollector(CollectorSystem.STORAGE));
        addSequential(new PickUpWithRoller());
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}