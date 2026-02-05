// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.Subsystem;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.subsystems.ApriltagSubsystem;
import edu.wpi.first.math.geometry.Pose2d;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class TurretSubsystem extends SubsystemBase  {
  
  private CommandSwerveDrivetrain T_driveTrain;
  //final Spark m_motor = new Spark(26); todo

  //public void setTurretAngle(double turretAngle){ todo
   // m_motor.set(0.1);todo
 // }todo
  
  /** Creates a new TurretSubsystem. */
  public TurretSubsystem(CommandSwerveDrivetrain T_driveTrain) {
    this.T_driveTrain = T_driveTrain;
  }

  @Override
  public void periodic() {

    double RobotX = T_driveTrain.getState().Pose.getX();
    double RobotY = T_driveTrain.getState().Pose.getY();
    double RobotYawRad = T_driveTrain.getState().Pose.getRotation().getRadians();

    double TurretXGlobal = Math.cos(RobotYawRad) * Constants.turretOffsetY + RobotX;
    double TurretYGlobal = Math.sin(RobotYawRad) * Constants.turretOffsetX + RobotY;

    double xHubDifference = Constants.blueHubX - TurretXGlobal;
    double yHubDifference = Constants.blueHubY - TurretYGlobal;

    double xPassLeftDifference = Constants.bluePassLeftX - TurretXGlobal;
    double yPassLeftDifference = Constants.bluePassLeftY - TurretXGlobal;

    double xPassRightDifference = Constants.bluePassRightX - TurretXGlobal;
    double yPassRightDifference = Constants.bluePassRightY - TurretXGlobal;

    double turretAngleGlobal = Math.atan(yHubDifference / xHubDifference); // calculates the turret angle for the hub in degrees
    SmartDashboard.putNumber("Turret Angle Hub", turretAngleGlobal);

    double turretAnglePassLeft = Math.atan(yPassLeftDifference / xPassLeftDifference); // calculates the turret angle for passing left in degrees
    SmartDashboard.putNumber("Turret Angle Pass Left", turretAnglePassLeft);

    double turretAnglePassRight = Math.atan(yPassRightDifference / xPassRightDifference); // calculates the turret angle for passing Right in degrees
    SmartDashboard.putNumber("Turret Angle Pass Right", turretAnglePassRight);

  }
}
