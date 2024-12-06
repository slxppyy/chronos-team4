package frc.robot.subsystems;

import com.ctre.phoenix6.configs.CurrentLimitsConfigs;
  import com.ctre.phoenix6.configs.Slot0Configs;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.VelocityVoltage;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Shooter {
    
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
    private TalonFX shooterLeftM;
    private TalonFX shooterRightM;

    private double leftVelocitySetpoint = 0;
    private double rightVelocitySetpoint = 0;

    final VelocityVoltage leftVelocityVoltage = new VelocityVoltage(0);
    final VelocityVoltage rightVelocityVoltage = new VelocityVoltage(0);


    public Shooter(){
        shooterLeftM = new TalonFX(Constants.HardwarePorts.shooterTopM);
        shooterRightM = new TalonFX(Constants.HardwarePorts.shooterBottomM);

        shooterLeftM.setInverted(false);
        shooterRightM.setInverted(false);

        configMotor(shooterLeftM, 0.21, 0.122);
        configMotor(shooterRightM, 0.362, 0.1225);

    }
private void configMotor(TalonFX motor, double kS, double kV){
    TalonFXConfiguration config = new TalonFXConfiguration();
    config.MotorOutput.Inverted = InvertedValue.CounterClockwise_Positive;
    config.MotorOutput.NeutralMode = NeutralModeValue.Coast; // Break or coast. When powered should the motor keep itself in place (brake) or allow itself to move freely (coast)

    CurrentLimitsConfigs currentLimitsConfigs = new CurrentLimitsConfigs();
    currentLimitsConfigs.SupplyCurrentLimit = Constants.shooterContinuousCurrentLimit;
    currentLimitsConfigs.SupplyCurrentLimitEnable = true;
    currentLimitsConfigs.SupplyCurrentThreshold = Constants.shooterPeakCurrentLimit;

    Slot0Configs slot0Configs = new Slot0Configs();
    slot0Configs.kS = kS;
    slot0Configs.kV = kV;

    config.CurrentLimits = currentLimitsConfigs;
    motor.getConfigurator().apply(config) ;
    motor.getConfigurator().apply(slot0Configs);
}


}
