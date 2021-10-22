package frc.robot.subsystems;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase{
    private VictorSP leftMotor, rightMotor;

    public Drivetrain(){
        //0 and 1 are the PWM numbers these motor controllers are plugged into on the roboRIO.
        //These can technically be initialized either in or out the constructor.
        leftMotor = new VictorSP(0); 
        rightMotor = new VictorSP(1);
        rightMotor.setInverted(true);
    }
    public void drive(double leftSpeed, double rightSpeed){
        leftMotor.setSpeed(leftSpeed);
        rightMotor.setSpeed(rightSpeed);
    }

}
