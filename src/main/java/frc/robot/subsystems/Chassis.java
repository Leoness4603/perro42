// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;

public class Chassis extends SubsystemBase {
  /** Creates a new Chassis. */

  WPI_VictorSPX m_rear_left = new WPI_VictorSPX(Constants.IDcan.Chassis.m_rear_left);
  WPI_VictorSPX m_bhnd_left = new WPI_VictorSPX(Constants.IDcan.Chassis.m_bhnd_left);
  WPI_VictorSPX m_rear_right = new WPI_VictorSPX(Constants.IDcan.Chassis.m_rear_right);
  WPI_VictorSPX m_bhnd_right = new WPI_VictorSPX(Constants.IDcan.Chassis.m_bhnd_right);
  
  private Joystick drivejoystick;

  private DifferentialDrive drive;

  public Chassis(Joystick driveJoystick) {
    m_bhnd_left.follow(m_rear_left);
    m_bhnd_right.follow(m_rear_right);
    MotorControllerGroup leftMotors = new MotorControllerGroup(m_rear_left, m_bhnd_left);
    MotorControllerGroup rightMotors = new MotorControllerGroup(m_rear_right, m_bhnd_right);
    drive = new DifferentialDrive(leftMotors, rightMotors);
    this.drivejoystick = driveJoystick;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void drive(double movement, double rotation) {
    this.drive.arcadeDrive(movement, rotation);
  }

  public void stop() {
    this.drive.arcadeDrive(0, 0);
  }

  public Joystick getJoystick() {
    return drivejoystick;
  }
}
