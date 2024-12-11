package frc.robot.subsystems;


import com.ctre.phoenix6.configs.CurrentLimitsConfigs;
import com.ctre.phoenix6.configs.Slot0Configs;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.VelocityVoltage;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;

import frc.robot.Constants;

public class Shooter {
    
    private static volatile Shooter instance;
    // search for thread safe instance getter on yt
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

    private double velocityCap = 65;

    final VelocityVoltage topVelocityVoltage = new VelocityVoltage(0);
    final VelocityVoltage bottomVelocityVoltage = new VelocityVoltage(0);

    final VelocityVoltage leftVelocityVoltage = new VelocityVoltage(0);
    final VelocityVoltage rightVelocityVoltage = new VelocityVoltage(0);


    public Shooter(){
        shooterLeftM = new TalonFX(Constants.rightShooter);
        shooterRightM = new TalonFX(Constants.leftShooter);

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
    //currentLimitsConfigs.SupplyCurrentLimit = Constants.shooterContinuousCurrentLimit;
    currentLimitsConfigs.SupplyCurrentLimitEnable = true;
    //currentLimitsConfigs.SupplyCurrentThreshold = Constants.shooterPeakCurrentLimit;

    Slot0Configs slot0Configs = new Slot0Configs();
    slot0Configs.kS = kS;
    slot0Configs.kV = kV;

    config.CurrentLimits = currentLimitsConfigs;
    motor.getConfigurator().apply(config) ;
    motor.getConfigurator().apply(slot0Configs);
}
public double[] getBothSetpoints() {
    return new double[] { rightVelocitySetpoint, leftVelocitySetpoint };
}

public double getTopSetpoint() {
    return rightVelocitySetpoint;
}
public double getBottomSetpoint() {
    return leftVelocitySetpoint;
}
public double[] getBothVelocities() {
    return new double[] { (shooterRightM.getVelocity().getValueAsDouble()),
            (shooterLeftM.getVelocity().getValueAsDouble()) };
}

/**
     * Get the velocity of the top shooter motor in Rotations Per Second.
      * @return Velocity of the top shooter motor in Rotations Per Second.
     */
    public double getTopVelocity() {
        return shooterRightM.getVelocity().getValueAsDouble();
    }

    /**
     * Get the velocity of the bottom shooter motor in Rotations Per Second.
     * @return Velocity of the bottom shooter motor in Rotations Per Second.
     */
    public double getBottomVelocity() {
        return shooterLeftM.getVelocity().getValueAsDouble();
    }
    /**
     * Get both motor voltages.
     * @return Double Array where the first element is the top motor voltage and the second element is the bottom motor voltage.
     */
    public double[] getBothVoltages() {
        return new double[] { (shooterRightM.getMotorVoltage().getValueAsDouble()),
                (shooterLeftM.getMotorVoltage().getValueAsDouble()) };
    }
    public double getTopMotorVoltage() {
        return shooterRightM.getMotorVoltage().getValueAsDouble();
    }

    public double getBottomMotorVoltage() {
        return shooterLeftM.getMotorVoltage().getValueAsDouble();
    }

// Setters for the shooter motors

    /**
     * Set the velocity of both the shooter motors.
     * @param velocity Velocity in Rotations Per Second to set shooter motors to.
     */
    public void setVelocity(double velocity) { // rotations per second
        velocity = Math.min(velocity, velocityCap); // Make sure that the inputted velocity is not greater than the velocity cap
        rightVelocitySetpoint = velocity;
        leftVelocitySetpoint = velocity;

        shooterRightM.setControl(rightVelocityVoltage.withVelocity(velocity));
        shooterLeftM.setControl(leftVelocityVoltage.withVelocity(velocity));
    }

    /**
     * Set the velocity of the top shooter motor.
     * @param velocity Velocity in Rotations Per Second to set top shooter motor to.
     */
    public void setTopVelocity(double velocity) {
        rightVelocitySetpoint = velocity;

        shooterRightM.setControl(rightVelocityVoltage.withVelocity(velocity));
    }

    /**
     * Set the velocity of the bottom shooter motor.
     * @param velocity Velocity in Rotations Per Second to set bottom shooter motor to.
     */
    public void setBottomVelocity(double velocity) {
        leftVelocitySetpoint = velocity;

        shooterLeftM.setControl(leftVelocityVoltage.withVelocity(velocity));
    }

    /**
     * Set the voltage of both the shooter motors.
     * @param volts Voltage to set shooter motors to.
     */
    public void setVoltage(double volts) {
        shooterRightM.setVoltage(volts);
        shooterLeftM.setVoltage(volts);
    }

    public void setTopVoltage(double voltage) {
        shooterRightM.setVoltage(voltage);
    }

    public void setBottomVoltage(double voltage) {
        shooterLeftM.setVoltage(voltage);
    }


    /**
     * Set the speed of both the shooter motors.
     * @param volts Percent output to set shooter motors to. From -1 to 1.
     */
    public void setPercentage(double volts) {
        shooterRightM.setVoltage(volts);
        shooterLeftM.setVoltage(volts);
    }

    /**
     * Set the speed of the top shooter motor.
     * @param percent Percent output to set top shooter motor to. From -1 to 1.
     */
    public void setTopPercent(double percent) {
        shooterRightM.set(percent);
    }

    /**
     * Set the speed of the bottom shooter motor.
     * @param percent Percent output to set bottom shooter motor to. From -1 to 1.
     */
    public void setBottomPercent(double percent) {
        shooterLeftM.set(percent);
    }


    /**
     * Are the velocities of the shooter motors within an acceptable error?
     * @param acceptableError The acceptable error in rotations per second.
     * @return
     */
    public boolean velocitiesWithinError(double acceptableError) {
        double[] shooterSpeeds = getBothVelocities();
        double averageError = ((shooterSpeeds[0] - rightVelocitySetpoint) + (shooterSpeeds[1] - leftVelocitySetpoint)) / 2;
        return Math.abs(averageError) < acceptableError;
    }


}


