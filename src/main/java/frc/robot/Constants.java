// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

public final class Constants {
  
  
  public final static class IDcan {
    public final static class Chassis {
      public final static int m_rear_left = 1;
      public final static int m_bhnd_left = 2;
      public final static int m_rear_right = 3;
      public final static int m_bhnd_right = 4;
    }

    public final static class Forearm {
      public final static int Forearm_Motor = 5;
      public final static int Forearm_Motor_2 = 6;
    }
    
  }
  
  public final static class IoPWM {
    public final static class Claw {
      public final static int CLAW_Motor = 2;
    }
    public final static class Arm {
      public final static int ARM_Motor = 1;
    }
  }

  public final static class Joystick {
    public final static int Joystick_Port = 0;
    public final static int Second_Joystick_Port = 1;
  }

}
