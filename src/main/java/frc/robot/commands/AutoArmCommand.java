package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Arm;

public class AutoArmCommand extends CommandBase {
  
    double time;
    double armSpeed;
    double motorSpeed;
    Arm arm;
    Timer timer;
    public AutoArmCommand(Arm arm, double motorSpeed, double time){
        this.arm = arm;
        this.motorSpeed = motorSpeed;
        this.time = time;
        addRequirements(arm);
        timer = new Timer();
    }

    @Override
    public void initialize(){
        timer.reset();
        timer.start();
    }

    @Override
    public void execute() {
        arm.moveArm(motorSpeed);
    }

    @Override
    public void end(boolean interrupted){
    }

    @Override
    public boolean isFinished(){
        return timer.get() > time;
    }
}
