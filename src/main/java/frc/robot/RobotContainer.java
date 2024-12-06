// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

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

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.subsystems.Indexer.IndexerStates;

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

  private final SwerveRequest.FieldCentric drive = new SwerveRequest.FieldCentric()
  .withDeadband(Constants.DriveConstants.MaxSpeed * translationDeadband).withRotationalDeadband(Constants.DriveConstants.MaxAngularRate * rotDeadband)
  .withDriveRequestType(DriveRequestType.OpenLoopVoltage);  

  public static final double translationDeadband = 0.1;
  public static final double rotDeadband = 0.1;
}

  private void configureBindings() {


  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
