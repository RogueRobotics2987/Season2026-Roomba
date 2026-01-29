// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.TurretSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.LimelightHelpers;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class TurretLineupCommand extends Command {
  //missing private final subsystem m_subsystem
  public double goalOffset;
  public double turretAngle;
  public double Tz;
  private final TurretSubsystem m_TurretSubsystem; //added final
 
  //missing @param subsystem

  /** Creates a new TurretLineupCommand. */
  public TurretLineupCommand(TurretSubsystem TurretSubsystem) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_TurretSubsystem = TurretSubsystem;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    goalOffset = 20.85; // inches
    turretAngle = 0;
    Tz = 10; // just for testing.
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double Tx = LimelightHelpers.getTX ("limelight");

    turretAngle = Math.atan(Tz + goalOffset / Tx);
    SmartDashboard.putNumber("Turret Angle: ", turretAngle);

    //m_TurretSubsystem.setTurretAngle(0.1);todo
  
  
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
