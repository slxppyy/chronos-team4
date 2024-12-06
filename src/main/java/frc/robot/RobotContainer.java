// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;

public class RobotContainer {
  public RobotContainer() {
    configureBindings();
  }

<<<<<<< Updated upstream
  private void configureBindings() {}
=======
  private final SwerveRequest.FieldCentric drive = new SwerveRequest.FieldCentric()
  .withDeadband(Constants.DriveConstants.MaxSpeed * translationDeadband).withRotationalDeadband(Constants.DriveConstants.MaxAngularRate * rotDeadband)
  .withDriveRequestType(DriveRequestType.OpenLoopVoltage);  

  public static final double translationDeadband = 0.1;
  public static final double rotDeadband = 0.1;
  
  private final Trigger driverBack = driver.back();
  private final Trigger driverStart = driver.start();
  private final Trigger driverA = driver.a();
  private final Trigger driverB = driver.b();
  private final Trigger driverX = driver.x();
  private final Trigger driverY = driver.y();
  private final Trigger driverRightBumper = driver.rightBumper();
  private final Trigger driverLeftBumper = driver.rightBumper();
  private final Trigger driverLeftTrigger = driver.leftTrigger();
  private final Trigger driverRightTrigger = driver.rightTrigger();
  private final Trigger driverDpadUp = driver.povUp();
  private final Trigger driverDpadDown = driver.povDown();
  private final Trigger driverDpadLeft = driver.povLeft();
  private final Trigger driverDpadRight = driver.povRight();
  
  public CommandXboxController getDriverController(){
    return driver;
  }

  private void configureBindings() {


  }
>>>>>>> Stashed changes

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
