// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;


import edu.wpi.first.wpilibj.Joystick;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Forearm extends SubsystemBase {
  private Joystick joystick;
  private CANSparkMax motor = new CANSparkMax(Constants.IDcan.Forearm.Forearm_Motor, MotorType.kBrushed);
  private CANSparkMax motor2 = new CANSparkMax(Constants.IDcan.Forearm.Forearm_Motor_2, MotorType.kBrushed);
  /** Creates a new IntakeWheels. */
  public Forearm(Joystick joystick) {
    this.joystick = joystick;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public Joystick getJoystick(){
    return this.joystick;
  }

  public void ForearmMovement(double yAxis){
    motor.set(yAxis);
    motor2.set(yAxis);
  }

  public void stop(){
    motor.set(0);
    motor2.set(0);
  }
}
