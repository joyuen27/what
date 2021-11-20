package frc.robot.subsystems;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase{
    private VictorSP leftMotor, rightMotor;
    private DifferentialDrive drive;

    public Drivetrain(){
        //0 and 1 are the PWM numbers these motor controllers are plugged into on the roboRIO.
        //These can technically be initialized either in or out the constructor.
        leftMotor = new VictorSP(0); 
        rightMotor = new VictorSP(1);
        drive = new DifferentialDrive(leftMotor,rightMotor);

    }
    public void drive(double leftSpeed, double rightSpeed){
        System.out.println(leftSpeed);
        System.out.println(rightSpeed);
        drive.tankDrive(leftSpeed,rightSpeed);
    }

}
