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
//import frc.robot.Constants;

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


private void configMotor() {}


public enum IntakeStates {}

public double getIntakeVoltage() {

}

public void setIntakeSpeed() {
    
}


