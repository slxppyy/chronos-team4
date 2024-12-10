package frc.robot.subsystems;

import com.ctre.phoenix6.configs.CurrentLimitsConfigs;
import com.ctre.phoenix6.configs.Slot0Configs;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.DutyCycleOut;
import com.ctre.phoenix6.controls.Follower;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Intake {
    private static Intake instance;
    public static Intake getInstance() {
        if (instance == null) {
            synchronized (Intake.class) {
                instance = new Intake();               
            }
        }
        return instance;
    }
    
}
    
    

private TalonFX intakeMotor;

private void configMotor(TalonFX motor) {


    TalonFXConfiguration config = new TalonFXConfiguration();
    CurrentLimitsConfigs currentLimitsConfigs = new CurrentLimitsConfigs();

    currentLimitsConfigs.SupplyCurrentLimit = Constants.intakeContinuousCurrentLimit;
    currentLimitsConfigs.SupplyCurrentLimitEnable = true;
    currentLimitsConfigs.SupplyCurrentThreshold = Constants.intakePeakCurrentLimit;
    config.MotorOutput.NeutralMode = NeutralModeValue.Coast;
    config.OpenLoopRamps.DutyCycleOpenLoopRampPeriod = 0.5;
    //config.OpenLoopRamps.

    //Slot0Configs slot0Configs = new Slot0Configs();
    //slot0Configs.kP = Constants.SwerveConstants.driveKP;
    //slot0Configs.kI = Constants.SwerveConstants.driveKI;
    //slot0Configs.kD = Constants.SwerveConstants.driveKD;
    config.CurrentLimits = currentLimitsConfigs;
    motor.getConfigurator().apply(config);
    }


    public enum IntakeStates {
    ON(0.45, 0.85),
    OFF(0, 0),
    REV(-0.4, -0.8);

    private double speed;
    private double serialSpeed;

    public double getValue() {
        return speed;
    }

    IntakeStates(double speed, double serialSpeed) {
        this.speed = speed;
        this.serialSpeed = serialSpeed;
    }
    }
    public void setSpeed(IntakeStates state) {
    intakeMotor.setControl(dutyCycleRequest.withOutput(state.speed));
    serialM.set(state.serialSpeed);
    currentState = state;
    }
    private double currentIntakePercentage = Integer.MAX_VALUE;

    public void incPower() {
        if (currentIntakePercentage == Integer.MAX_VALUE) {
            if (currentState != null) {
                currentIntakePercentage = currentState.speed;
            }
        }
        currentIntakePercentage += 0.05;
        intakeMotor.set(currentIntakePercentage);
    }

    public void decPower() {
        if (currentIntakePercentage == Integer.MAX_VALUE) {
            if (currentState != null) {
                currentIntakePercentage = currentState.speed;
            }
        }
        currentIntakePercentage -= 0.05;
        intakeMotor.set(currentIntakePercentage);
    }


    
    public void periodic() {
        
        SmartDashboard.putBoolean("Intake/Intake On", intakeMotor.getMotorVoltage().getValueAsDouble() > 2);
    }

    
    public void simulationPeriodic() {

    }
