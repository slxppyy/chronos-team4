package frc.robot.commands.Intake;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Indexer;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Intake.IntakeStates;

public class SetIntake extends Command {
    private int counter = 0;
    private final Intake s_Intake;
    Intake.IntakeStates state;

    private final Indexer s_Indexer;


    // Overloaded Constructor
    public SetIntake(Intake.IntakeStates state, double time) {
        s_Intake = Intake.getInstance();
        s_Indexer = Indexer.getInstance();



        addRequirements(s_Intake);
    }

    // Overloaded constructor
    public SetIntake(Intake.IntakeStates state) {
        this(state, 4); // Check later 
    }

    @Override
    public void execute() {

    }

    @Override
    public void end(boolean interrupted) {
        s_Intake.setSpeed(IntakeStates.OFF);
    }

    @Override
    public boolean isFinished() { 
        counter++;
        return counter % 200 == 0;
    }
}