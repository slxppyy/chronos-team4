package frc.robot.subsystems;

import com.ctre.phoenix6.controls.Follower;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
<<<<<<< Updated upstream
import pabeles.concurrency.ConcurrencyOps.NewInstance;

=======
import frc.robot.*;
import com.ctre.phoenix6.controls.Follower;
import frc.robot.ShooterConstants;
>>>>>>> Stashed changes


public class Indexer extends SubsystemBase{
    private static Indexer instance;
    public static Indexer getIndexer() {
        if (instance == null){
            instance = new Indexer();
        }
        return instance;
    }
    
<<<<<<< Updated upstream
=======
    private Follower follow = new Follower(ShooterConstants.HardwarePorts.indexerTopM, false );
    

>>>>>>> Stashed changes
}
