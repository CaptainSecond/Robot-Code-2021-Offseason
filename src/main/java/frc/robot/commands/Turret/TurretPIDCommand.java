// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Turret;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.TurretConstants;
import frc.robot.subsystems.TurretSubsystem;
import frc.robot.subsystems.VisionSubsystem;

public class TurretPIDCommand extends CommandBase {
    /** Creates a new TurretPIDCommand. */
    private TurretSubsystem m_turret;
    private VisionSubsystem m_vision;
    double error;
    double output;
    double outputSum;
    char shouldTurnSide = 'o';
    char lookingSide;

    public TurretPIDCommand(TurretSubsystem turret, VisionSubsystem vision) {
        // Use addRequirements() here to declare subsystem dependencies.
        m_turret = turret;
        m_vision = vision;
        addRequirements(m_turret, m_vision);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        output = 0;
        m_turret.isFollowingTarget = true;
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        output = 0;
        error = 0;
        if (m_vision.hasTarget()) {
            error = m_vision.getYaw();
            output = error * TurretConstants.kP;
            shouldTurnSide = error > 0 ? 'r' : 'l';

            if (output > 6) {
                output = 6;
            } else if (output < -6) {
                output = -6;
            }
            if (m_turret.HeadEncoderGetValue() >= 4.1 && shouldTurnSide == 'r') {
                output = 0;
            }

            if (m_turret.HeadEncoderGetValue() <= -4.1 && shouldTurnSide == 'l') {
                output = 0;
            }

            if (error >= -2 && error <= 2) {
                m_turret.isAtSetpoint = true;
                shouldTurnSide = 'o';
                // m_turret.isFollowingTarget = false; // might have to remove this
                output = 0;
            } else {
                m_turret.isAtSetpoint = false;
            }
            if (shouldTurnSide == 'o') {
                output = 0;
            }
            outputSum += output;
            if (outputSum > 0) {
                lookingSide = 'r';
            } else {
                lookingSide = 'l';
            }
            // System.out.println("Should turn side : " + shouldTurnSide);
            // System.out.println("Error : " + error);

        } else {
            output = 0;
        }
        if (0 < output && 2 > output) {
            output += 1;
        } else if (0 > output && -2 < output) {
            output -= 1;
        }
        m_turret.setTurretVolts(output);
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        m_turret.setTurretVolts(0);
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
    }
}
