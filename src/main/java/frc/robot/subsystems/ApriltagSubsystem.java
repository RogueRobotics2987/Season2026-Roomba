package frc.robot.subsystems;

import edu.wpi.first.math.VecBuilder;
import edu.wpi.first.wpilibj2.command.Subsystem;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.LimelightHelpers;

public class ApriltagSubsystem extends SubsystemBase {
 
// Components (e.g., motor controllers and sensors) should generally be
  // declared private and exposed only through public methods.
  // Example private motor controller:
  // private final PWMVictorSPX m_motor = new PWMVictorSPX(4);

  private CommandSwerveDrivetrain AT_driveTrain;
  private boolean rejectUpdate = false;

  /** Creates a new ExampleSubsystem. */
  public ApriltagSubsystem(CommandSwerveDrivetrain AT_driveTrain) {
    this.AT_driveTrain = AT_driveTrain;
    // Constructor for the subsystem, used for initial setup and instantiation of components.
  }

  /**
   * Called periodically whenever the CommandScheduler runs.
   * This is useful for "background" actions or logging data to the dashboard.
   */
  @Override
  public void periodic() {

    System.out.println("Nope");

    // This method will be called once per scheduler run.
    LimelightHelpers.PoseEstimate mt2 = LimelightHelpers.getBotPoseEstimate_wpiBlue_MegaTag2("limelight");
    LimelightHelpers.SetRobotOrientation("limelight", AT_driveTrain.getPigeon2().getRotation2d().getDegrees(), 0, 0, 0, 0, 0);

    // if (Math.abs(AT_driveTrain.get()) > 360) {
    //   rejectUpdate = true;
    // }

    if (mt2.tagCount == 0) {
      rejectUpdate = true;
      System.out.println("Nuh uh");
    }

    else {
      rejectUpdate = false;
    }

    if (!rejectUpdate) {
      AT_driveTrain.setVisionMeasurementStdDevs(VecBuilder.fill(.5,.5,9999999));
      AT_driveTrain.addVisionMeasurement(mt2.pose, mt2.timestampSeconds);
      System.out.println("Yippee");
    }  

  }

  // Public methods to control the subsystem's components (e.g., setting motor speeds, reading sensor data)
  // Example public method:
  // public void runMotor(double speed) {
  //   m_motor.set(speed);
  // }
}


