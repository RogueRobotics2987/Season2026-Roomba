// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.Subsystem;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

public class TurretSubsystem implements Subsystem  {
  
  final SparkMax m_motor = new SparkMax(26, MotorType.kBrushless);// todo

  public void setTurretAngle(double turretAngle){// todo
    m_motor.set(turretAngle);//todo
  }//todo
  
  /** Creates a new TurretSubsystem. */
  public TurretSubsystem() {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
