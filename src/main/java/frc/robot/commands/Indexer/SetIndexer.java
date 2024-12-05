package frc.robot.commands.Indexer;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Indexer;
import frc.robot.subsystems.Indexer.IndexerStates;
public class SetIndexer extends Command{
    private final Indexer s_Indexer;
    IndexerStates state;
    private final boolean intaking;
    private double time;
    private Timer timer;

    public SetIndexer(IndexerStates state, boolean intaking, double time) {
        this.intaking = intaking;
        s_Indexer = Indexer.getInstance();
        this.state = state;
        timer = new Timer();
        addRequirements(s_Indexer);
        this.time = time;
    }
    
    
}
