/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tamankeet3933.java2014;

import edu.wpi.first.wpilibj.command.Command;
import org.tamankeet3933.java2014.commands.Autonomous;
import org.tamankeet3933.java2014.commands.CatchShooter;
import org.tamankeet3933.java2014.commands.Fire;
import org.tamankeet3933.java2014.commands.LowPass;
import org.tamankeet3933.java2014.commands.Pass;
import org.tamankeet3933.java2014.commands.PickUpBall;

/**
 * Class with all the static commands, so they may be initialised when needed.
 * @author Ricardo Delfin
 */
public class CommandList {
    public static Command autonomousCommand;
    public static Command fireCommand;
    public static Command catchShooterCommand;
    public static Command passCommand;
    public static Command pickUpBallCommand;
    public static Command lowPassCommand;
    
    public static void init()
    {
        autonomousCommand = new Autonomous();
        fireCommand = new Fire();
        catchShooterCommand = new CatchShooter();
        passCommand = new Pass();
        pickUpBallCommand = new PickUpBall();
        lowPassCommand = new LowPass();
    }
}
