// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.commands.ArcadeDrive;
import frc.robot.commands.MoveArm;
import frc.robot.commands.MoveClaw;
import frc.robot.commands.MoveForearm;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Chassis;
import frc.robot.subsystems.Claw;
import frc.robot.subsystems.Forearm;

/**
 * This is a demo program showing the use of the DifferentialDrive class. Runs the motors with
 * arcade steering.
 */
public class Robot extends TimedRobot {
  private Joystick driveJoystick = new Joystick(Constants.Joystick.Second_Joystick_Port);
  private Joystick xboxController = new Joystick(Constants.Joystick.Joystick_Port);
  
  private Chassis chassis = new Chassis(driveJoystick);
  private Arm arm = new Arm(xboxController);
  private Claw claw = new Claw(xboxController);
  private Forearm forearm = new Forearm(xboxController);

  private ArcadeDrive arcadeDriveCommand = new ArcadeDrive(chassis);
  private MoveArm moveArmCommand = new MoveArm(arm);
  private MoveClaw moveClawCommand = new MoveClaw(claw);
  private MoveForearm moveForearmCommand = new MoveForearm(forearm);
  

  @Override
  public void robotInit() {
    // We need to invert one side of the drivetrain so that positive voltages
    // result in both sides moving forward. Depending on how your robot's
    // gearbox is constructed, you might have to invert the left side instead.
    chassis.setDefaultCommand(arcadeDriveCommand);
    claw.setDefaultCommand(moveClawCommand);
    arm.setDefaultCommand(moveArmCommand);
    forearm.setDefaultCommand(moveForearmCommand);
  }

  @Override
  public void robotPeriodic() {
    // Runs the Scheduler.  This is responsible for polling buttons, adding newly-scheduled
    // commands, running already-scheduled commands, removing finished or interrupted commands,
    // and running subsystem periodic() methods.  This must be called from the robot's periodic
    // block in order for anything in the Command-based framework to work.
    CommandScheduler.getInstance().run();
  }

  /** This function is called once each time the robot enters Disabled mode. */
  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.

  }

  @Override
  public void teleopPeriodic() {
    // Drive with arcade drive.
    // That means that the Y axis drives forward
    // and backward, and the X turns left and right.
  }

  @Override
  public void testInit() {
    // Cancels all running commands at the start of test mode.
    CommandScheduler.getInstance().cancelAll();
  }

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {}
  
}
