package frc.robot;

public final class Constants {
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
}
