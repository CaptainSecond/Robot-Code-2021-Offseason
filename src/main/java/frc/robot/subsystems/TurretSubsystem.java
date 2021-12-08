// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.TurretConstants;

public class TurretSubsystem extends SubsystemBase {
  /** Creates a new TurretSubsystem. */
  public PWMVictorSPX TurretMotor = new PWMVictorSPX(TurretConstants.kTurretMotor);
  public boolean isFollowingTarget = false;
  public boolean isAtSetpoint = false;
  public double cpr = 64; //if am-4027
  public double whd = 6; // for 6 inch wheel
  public Encoder TurretEncoder;
  public TurretSubsystem() { 
    TurretMotor.setInverted(TurretConstants.kIsMotorReversed);
    TurretEncoder = new Encoder(TurretConstants.kTurretEncoderA, TurretConstants.kTurretEncoderB, TurretConstants.kIsEncoderReversed);
  }

  public double HeadEncoderGetValue(){
    TurretEncoder.setDistancePerPulse(1.0 / (TurretConstants.kTurretEncoderPPR));
    TurretEncoder.setDistancePerPulse(Math.PI*whd/cpr);
    return TurretEncoder.getDistance();
  }

  public void runTurret(double m_speed){
		TurretMotor.set(m_speed);
  }

  public void resetEncoders() {
    TurretEncoder.reset();
  }

  public void scanToRight() {
    if (HeadEncoderGetValue() <= -5.8) {
        runTurret(-1);
    } else {
        runTurret(0);
    }
  }

  public void scanToLeft() {
    if (HeadEncoderGetValue() >= 5.8) {
      runTurret(1);
    } else {
      runTurret(0);
    }
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Turret Encoder", HeadEncoderGetValue());
    SmartDashboard.putNumber("TurretValue", TurretMotor.get());
  }
}
