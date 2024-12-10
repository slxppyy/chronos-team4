package frc.robot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;

public class CommandFactory {
    public static Command offEverything(){
        return new SequentialCommandGroup(
            new ParallelCommandGroup(

            )
        );
    }
    public static Command eject(){
        return new SequentialCommandGroup(
            new ParallelCommandGroup(

            ),
            new WaitCommand(0),
            new ParallelCommandGroup(
                
            )
        );
    }
}
