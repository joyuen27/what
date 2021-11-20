package frc.robot.subsystems;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Arm extends SubsystemBase {
    
    //Refer back to the drivetrain subsystem. When the arm speed is set, 
    //going at max speed is not the greatest idea, so use conservative values.
    private VictorSP armMotor;

    public Arm(){
        armMotor = new VictorSP(2);
    }

    public void moveArm(double armSpeed){
        armMotor.set(armSpeed);
    }
}