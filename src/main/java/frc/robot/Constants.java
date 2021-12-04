// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide
 * numerical or boolean constants. This class should not be used for any other
 * purpose. All constants should be declared globally (i.e. public static). Do
 * not put anything functional in this class.
 *
 * <p>
 * It is advised to statically import this class (or one of its inner classes)
 * wherever the constants are needed, to reduce verbosity.
 */
public final class Constants {
    
    // Joystick
    public static final class JoystickConstants {
        public static final int F310 = 0;
        public static final int Panel = 1;
    }

    // Drive
    public static final class DriveConstants {
        
        public static final int kLeftRearMotor = 0;
        public static final int kLeftFrontMotor = 2;
        public static final int kRightRearMotor = 1;
        public static final int kRightFrontMotor = 3;
        
        public static final boolean kLeftRearMotorInverted = true;
        public static final boolean kLeftFrontMotorInverted = true;
        public static final boolean kRightRearMotorInverted = true;
        public static final boolean kRightFrontMotorInverted = true;

        public static final boolean kGyroReversed = false;

        public static final double kStraightDriveTurnP = 1;
        public static final double kStraightDriveTurnI = 0;
        public static final double kStraightDriveTurnD = 0;
    }    

    public static final class IntakeConstants {
        public static final int kArmIntakeMotor = 2;
    }

    // Push
    public static final class PushConstants {
        public static final int kPushMotor = 3;
    }
    // Trigger
    public static final class TriggerConstants {
        public static final int kTriggerMotor =4 ;
    }

    // Turret
    public static final class TurretConstants {
        
        public static final byte kTurretMotor = 6;
        public static final byte kTurretEncoderA = 0;
        public static final byte kTurretEncoderB = 1;
        public static final int kTurretEncoderPPR = 2048; // AMT-103
        public static final byte kToleranceInDegrees = 0;

        public static final boolean kIsEncoderReversed = false;
        public static final boolean kIsMotorReversed = false;

        public static final double kP = 0.2;
        public static final double kI = 0.000;
        public static final double kD = 0.000;
        public static final double kS = 0.000;
        public static final double kV = 0.000;
        public static final double kA = 0.000;

    }
    
    // Shooter
    public static final class ShooterConstants {
        public static final int kShooterMotor = 5;
        public static final boolean kShooterInvertedMode1 = true;
        public static final boolean kShooterInvertedMode2 = true;

        public static final double kShootP = 0.005;
        public static final double kShootI = 0.000;
        public static final double kShootD = 0.000;

        public static final double kS = 0.656;
        public static final double kV = 0.00202;
        public static final double kA = 0.000494;
    }

    //Climb
    public static final class ClimbConstants{
        public static final int kClimbMotor=7;
    }
}
