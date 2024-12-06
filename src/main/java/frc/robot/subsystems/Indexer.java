package frc.robot.subsystems;

import com.revrobotics.ColorSensorV3;

import com.ctre.phoenix6.controls.Follower;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.ShooterConstants;


public class Indexer extends SubsystemBase{
    private static Indexer instance;
    public static Indexer getInstance() {
        if (instance == null) {
            instance = new Indexer();
        }
        return instance;
    }

    private TalonFX indexerLeaderM;
    private TalonFX indexerFollowerM;
    
    private Follower follow = new Follower(ShooterConstants.HardwarePorts.indexerBottomM, false);
    
    private ColorSensorV3 colorSensor;
    private DigitalInput limitSwitch = new DigitalInput(0);
    private static final I2C.Port onboardI2C = I2C.Port.kOnboard;

    public Indexer() {
        indexerLeaderM = new TalonFX(ShooterConstants.HardwarePorts.indexerTopM);
        indexerFollowerM = new TalonFX(ShooterConstants.HardwarePorts.indexerBottomM);
        indexerLeaderM.setInverted(true);
        indexerFollowerM.setControl(follow);
    }
    
    
    public enum IndexerStates {
        ON(.6),
        SHOOTING(.8),
        AMP(.7),
        ONAUTO(.32),
        OFF(0),
        REV(-8);

        private double speed;

        public double getValue() {
            return speed;
        }

        IndexerStates(double speed) {
            this.speed = speed;
        }
    }

    public void setSpeed(double percentageOutput) {
        indexerLeaderM.set(percentageOutput);
    }

    public void setState(IndexerStates state) {
        indexerLeaderM.set(state.speed);
        indexerFollowerM.setControl(follow);
    }

    public int getColorSensorResult() {
        return colorSensor.getProximity();
    }

    public double getMotorVoltage() {
        return indexerLeaderM.getMotorVoltage().getValueAsDouble();
    }

    public double getMotorCurrent() {
        return indexerLeaderM.getTorqueCurrent().getValueAsDouble();
    }

    @Override
    public void periodic(){
        SmartDashboard.putNumber("Indexer/Color Sensor Proximity", getColorSensorResult());
        SmartDashboard.putNumber("Indexer/Indexer Motor Current", getMotorCurrent());
    }

    @Override
    public void simulationPeriodic() {}
}
