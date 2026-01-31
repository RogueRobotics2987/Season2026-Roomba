// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.Subsystem;
import edu.wpi.first.math.controller.PIDController;

import com.ctre.phoenix6.configs.Slot0Configs;
import com.ctre.phoenix6.controls.PositionVoltage;
import com.ctre.phoenix6.hardware.TalonFX;

public class TurretSubsystem implements Subsystem  {
  
  private final TalonFX motor = new TalonFX(20, "rio"); //change rio?
  
  /** Creates a new TurretSubsystem. */
  public TurretSubsystem() {
    var slot0Configs = new Slot0Configs();
    slot0Configs.kP = 0.1; // An error of 1 rotation results in 2.4 V output
    slot0Configs.kI = 0; // no output for integrated error
    slot0Configs.kD = 0.1; // A velocity of 1 rps results in 0.1 V output

    motor.getConfigurator().apply(slot0Configs);
  }

  public void setTurretAngle(double position){

  final PositionVoltage m_request = new PositionVoltage(0).withSlot(0); //leave pos blank
  motor.setControl(m_request.withPosition(position));

  }



  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
