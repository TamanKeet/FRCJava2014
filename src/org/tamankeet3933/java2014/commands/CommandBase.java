package org.tamankeet3933.java2014.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.tamankeet3933.java2014.OI;
import org.tamankeet3933.java2014.subsystems.CollectorSystem;
import org.tamankeet3933.java2014.subsystems.DriveSystem;
import org.tamankeet3933.java2014.subsystems.ShooterSystem;

/**
 * The base for all commands. All atomic commands should subclass CommandBase.
 * CommandBase stores creates and stores each control system. To access a
 * subsystem elsewhere in your code in your code use CommandBase.exampleSubsystem
 * @author Ricardo Delfin Garcia
 * @version 1.2
 */
public abstract class CommandBase extends Command {

    public static OI oi;
    // Create a single static instance of all of your subsystems
    public ShooterSystem shooterSystem = new ShooterSystem();
    public DriveSystem driveSystem = new DriveSystem();
    public CollectorSystem collectorSystem = new CollectorSystem();

    public static void init() {
        // This MUST be here. If the OI creates Commands (which it very likely
        // will), constructing it during the construction of CommandBase (from
        // which commands extend), subsystems are not guaranteed to be
        // yet. Thus, their requires() statements may grab null pointers. Bad
        // news. Don't move it.
        oi = new OI();

        // Show what command your subsystem is running on the SmartDashboard
        //SmartDashboard.putData(exampleSubsystem);
    }

    public CommandBase(String name) {
        super(name);
    }

    public CommandBase() {
        super();
    }
}
