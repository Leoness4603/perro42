// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.motorcontrol.Spark;

import frc.robot.Constants;

public class Claw extends SubsystemBase {
  /** Creates a new Claw. */
  private Spark motor = new Spark(Constants.IoPWM.Claw.CLAW_Motor);
  private double motorSpeed = 1;
  private Joystick joystick;

  public Claw(Joystick joystick) {
    this.joystick = joystick;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  
  public Joystick getJoystick(){
    return this.joystick;
  }

  public void intake(boolean invert){
    if (invert){
      motor.set(-this.motorSpeed);
    }else{
      motor.set(this.motorSpeed);
    }
  }

  public void stop(){
    motor.set(0);
  }
}
