package frc.robot.commands.Intake;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Intake.IntakeStates;

public class SetIntake extends Command {
    private final Intake s_Intake;
    Intake.IntakeStates state;

   
    // Overloaded constructor
    public SetIntake(Intake.IntakeStates state) {
        s_Intake = Intake.getInstance();
        addRequirements(s_Intake);
        this.state = state; // Check later 
    }

    @Override
    public void initialize() {
        System.out.println("INTAKE");
        s_Intake.setSpeed(state.getSpeed());
    }
    
    @Override
    public void execute() {

    
    }

    @Override
    public void end(boolean interrupted) {

    }

    @Override
    public boolean isFinished() { 
        return true;
    }
}
