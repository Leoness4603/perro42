// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;


import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Arm extends SubsystemBase {
  private Joystick xboxController;
  private Spark motor = new Spark(Constants.IoPWM.Arm.ARM_Motor);


  /** Creates a new IntakeWheels. */
  public Arm(Joystick xboxController) {
    this.xboxController = xboxController;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public Joystick getJoystick(){
    return xboxController;
  }

  public void ArmMovement(double turn){
    this.motor.set(turn);
  }

  public void stop(){
    motor.set(0);
  }

}