// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Chassis;

public class ArcadeDrive extends CommandBase {
  /** Creates a new ArcadeDrive. */
  private final Chassis chassisSubsystem;
  private double movement;
  private double rotation;

  public ArcadeDrive(Chassis chassisSubsystem) {
    this.chassisSubsystem = chassisSubsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(chassisSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    movement = chassisSubsystem.getJoystick().getRawAxis(4);
    rotation = chassisSubsystem.getJoystick().getRawAxis(1);
    
    chassisSubsystem.drive(movement, rotation);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    chassisSubsystem.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
