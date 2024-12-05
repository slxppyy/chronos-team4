package frc.robot.subsystems;

<<<<<<< Updated upstream
import com.ctre.phoenix6.controls.Follower;
=======
import com.ctre.phoenix6.configs.CurrentLimitsConfigs;
  import com.ctre.phoenix6.configs.Slot0Configs;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.VelocityVoltage;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;
>>>>>>> Stashed changes

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class Shooter {
    
<<<<<<< Updated upstream
=======
    private static volatile Shooter instance;
//THREAD SAFE INSTANCE GETTER SEARCH ON YT 
    public static Shooter getInstance(){
        if (instance == null) {
            synchronized(Shooter.class) {
                if (instance == null) {
                    instance = new Shooter();
                }
            }
        }
        return instance;
    }
    private TalonFX shooterTopM;
    private TalonFX shooterBottomM;

    private double topVelocitySetpoint = 0;
    private double botVelocitySetpoint = 0;

    final VelocityVoltage topVelocityVoltage = new VelocityVoltage(0);
    final VelocityVoltage 



>>>>>>> Stashed changes
}
