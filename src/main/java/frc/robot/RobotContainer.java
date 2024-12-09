// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;


// import frc.robot.commands.SetLightz;
import frc.robot.subsystems.*;

import com.ctre.phoenix6.Utils;
import com.ctre.phoenix6.mechanisms.swerve.SwerveRequest;
import com.ctre.phoenix6.mechanisms.swerve.SwerveModule.DriveRequestType;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.subsystems.Indexer.IndexerStates;

public class RobotContainer {
  public RobotContainer() {
    configureBindings();
  }


  private void configureBindings() {}

  private final SwerveRequest.FieldCentric drive = new SwerveRequest.FieldCentric()
  .withDeadband(Constants.DriveConstants.MaxSpeed * translationDeadband).withRotationalDeadband(Constants.DriveConstants.MaxAngularRate * rotDeadband)
  .withDriveRequestType(DriveRequestType.OpenLoopVoltage);  

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.*;
import frc.robot.subsystems.Indexer.IndexerStates;
import frc.robot.commands.SetIndexer;
import frc.robot.commands.CommandFactory;

public class RobotContainer {
  private static volatile RobotContainer container;

  public static RobotContainer getInstance() {
    if(container == null) {
      synchronized(RobotContainer.class) {
        if(container == null){
          container = new RobotContainer();
        }
      }
    }
      return container;
  }
  public final CommandXboxController driver = new CommandXboxController(0);
  
  private final Indexer s_Indexer = Indexer.getInstance();
  
  //private final SwerveRequest.FieldCentric drive = new SwerveRequest.FieldCentric()
  //.withDeadband(Constants.DriveConstants.MaxSpeed * translationDeadband).withRotationalDeadband(Constants.DriveConstants.MaxAngularRate * rotDeadband)
  //.withDriveRequestType(DriveRequestType.OpenLoopVoltage);  

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


  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
  private void configureBindings() {
    driver.a().onTrue(CommandFactory.offEverything());
    driver.b().onTrue(CommandFactory.eject());
    driver.y().whileTrue(new SetIndexer(IndexerStates.SHOOTING));

  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }

  public RobotContainer() {
    configureBindings();
  }
}
