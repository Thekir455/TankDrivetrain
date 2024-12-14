
package frc.robot;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class Robot extends TimedRobot {
  private final CANSparkMax leftMotor = new CANSparkMax(11,MotorType.kBrushed);
  private final CANSparkMax rightMotor = new CANSparkMax(12,MotorType.kBrushed);
  private final DifferentialDrive driveRobot =
      new DifferentialDrive(leftMotor::set, rightMotor::set);
  private final XboxController Controller = new XboxController(0);

  @Override
  public void robotInit() {

    rightMotor.setInverted(true);
  }

  @Override
  public void teleopPeriodic() {
    driveRobot.tankDrive(-Controller.getRawAxis(1), -Controller.getRawAxis(5));
  }
}
