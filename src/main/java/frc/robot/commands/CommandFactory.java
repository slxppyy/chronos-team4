package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.Indexer.IndexerStates;
import frc.robot.commands.Indexer.SetIndexer;

public class CommandFactory {
    public static Command Diagnostic() {
        return new SequentialCommandGroup(
            //new SetShooterCommand(35),  
            //Commands.waitSeconds(1.0), 
            //new SetShooterCommand(0), 
            //new SetIntake(IntakeStates.ON, 1), 
            new SetIndexer(IndexerStates.ON, false),
            Commands.waitSeconds(1.0),
            new SetIndexer(IndexerStates.OFF, false)
        );
    }    

    public static Command offEverything() {
        return new SequentialCommandGroup(
            new ParallelCommandGroup(
                //new ZeroShooter(),
                //new SetIntake(IntakeStates.OFF),
                //Commands.waitSeconds(0.5),
                new SetIndexer(IndexerStates.OFF)
            )
        );
    }

    public static Command eject() {
        return new SequentialCommandGroup(
            new ParallelCommandGroup(
                new SetIndexer(IndexerStates.REV)
                //new SetIntake(IndexerStates.REV)
            ),
            new WaitCommand(0.005),
            new ParallelCommandGroup(
                new SetIndexer(IndexerStates.OFF)
                //new SetIntake(IntakeStates.OFF)
            )
        );
    }
}
