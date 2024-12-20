package frc.robot.commands.Shooter;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Shooter;



public class SetShooterCommand extends Command {
    private Shooter s_Shooter;
   

    private double velBot;
    private double velTop;

    public SetShooterCommand(double velocity) {
        s_Shooter = Shooter.getInstance();
        
        addRequirements(s_Shooter);
        velBot = velocity;
        velTop = velocity;

    }

    public SetShooterCommand(double velocityTop, double velocityBot){
        s_Shooter = Shooter.getInstance();
        addRequirements(s_Shooter);

        velTop = velocityTop;
        velBot = velocityBot;

   
    }

    @Override
    public void initialize() {
        System.out.println("SHOOT");
        s_Shooter.setTopVelocity(velTop);
        s_Shooter.setBottomVelocity(velBot);
        
        
    }

    @Override
    public void execute() {

    }

    @Override
	public boolean isFinished() {
        return true;
	}
		
	@Override
	public void end(boolean interrupted) {
        
	}
}
