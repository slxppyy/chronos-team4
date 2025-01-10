package frc.robot;

import com.pathplanner.lib.util.PIDConstants;

import edu.wpi.first.math.geometry.Translation2d;
import com.pathplanner.lib.commands.*;

public final class Constants {
    public static final int intakePeakCurrentLimit = 70;
    public static final int intakeContinuousCurrentLimit = 30;
    public static final int frontLeftSteer = 1;
    public static final int frontLeftDrive = 2;

    public static final int backLeftSteer = 3;
    public static final int backLeftDrive = 4;

    public static final int backRightSteer = 5;
    public static final int backRightDrive = 6;

    public static final int frontRightSteer = 7;
    public static final int frontRightDrive = 8;

    public static final int frontLeftCancoder = 9;
    public static final int backLeftCancoder = 10;
    public static final int backRightCancoder = 11;
    public static final int frontRightCancoder = 12;


    public static final int intake = 40;

    public static final int leftIndexer = 21;
    public static final int rightIndexer = 22;

    public static final int leftShooter = 31;
    public static final int rightShooter = 32;
    public static final class HardwarePorts {
        public static final int shooterBottomM = 50;
        public static final int shooterTopM = 51;
        
        public static final int indexerTopM = 31;
        public static final int indexerBottomM = 30;

        public static final int intakeLeaderM = 21;
        public static final int intakeFollower = 20;
        public static final int serialM = 22;

        public static final int climbLeaderMotor = 60;
        public static final int climbFollowerMotor = 61;

        public static final int pivotLeaderM = 40;
        public static final int pivotFollowerM = 41;
        public static final int pivotCANcoderID = 42;

        public static final int ampM = 62;
    }
    public static final class DriveConstants {
        public static final double MaxSpeed = 6;
        public static double MaxAngularRate = 3 * Math.PI;
    }
    public static final class SwerveConstants {
    public static final Translation2d flModuleOffset = new Translation2d(0.546 / 2.0, 0.546 / 2.0);
    public static final Translation2d frModuleOffset = new Translation2d(0.546 / 2.0, -0.546 / 2.0);
    public static final Translation2d blModuleOffset = new Translation2d(-0.546 / 2.0, 0.546 / 2.0);
    public static final Translation2d brModuleOffset = new Translation2d(-0.546 / 2.0, -0.546 / 2.0);
    
    public static final PIDConstants translationConstants = new PIDConstants(5.0, 2.0, 2.0);
    public static final PIDConstants rotationConstants = new PIDConstants(5.0, 2.0, 2.0);
    public static final double maxModuleSpeed = 4.5; // M/S
  }
}
