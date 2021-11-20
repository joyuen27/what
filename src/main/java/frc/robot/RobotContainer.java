// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.ArmControl;
import frc.robot.commands.Drive;
import frc.robot.commands.ExampleCommand;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.Command;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();

  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);

  private Joystick leftJoy = new Joystick(0);
  private Joystick rightJoy = new Joystick(1);

  private Drivetrain drivetrain = new Drivetrain();
  private Arm arm = new Arm();
  private ArmControl armControl = new ArmControl(arm, leftJoy, rightJoy);

  //Find the right axes values on either the simulator or driverstation.
  private Drive drive = new Drive(drivetrain, leftJoy, rightJoy); 

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    
    //Remember to do this.
    drivetrain.setDefaultCommand(drive);
    arm.setDefaultCommand(armControl);

    // Configure the button bindings
    configureButtonBindings();
  }

  public boolean leftJoyButton(int index) {
    return leftJoy.getRawButton(index);
  }
  public boolean rightJoyButton(int index) {
    return rightJoy.getRawButton(index);
  }

  private static RobotContainer instance;
  public static RobotContainer getInstance() {
    if (instance == null)
    {
      instance = new RobotContainer();
    }
    return instance;
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {}

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
  public Command getTeleopCommand() {
    // An ExampleCommand will run in autonomous
    return drive;
  }
}
