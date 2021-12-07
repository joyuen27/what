package frc.robot.commands;

import javax.annotation.OverridingMethodsMustInvokeSuper;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Arm;


public class AutoCommand extends CommandBase {
    Double leftSpeed;
    Double rightSpeed;
    Double time;
   
    Drivetrain drivetrain;
    Arm arm;
    Timer timer;
    public AutoCommand(Drivetrain drivetrain, double leftSpeed, double rightSpeed, double time){
        this.drivetrain = drivetrain;
        this.leftSpeed = leftSpeed;
        this.rightSpeed = rightSpeed;
        this.time = time;
        addRequirements(drivetrain);
        timer = new Timer();
    }

    @Override
    public void initialize(){
        timer.reset();
        timer.start();
    }

    @Override
    public void execute() {
        drivetrain.drive(rightSpeed, leftSpeed);
    }

    @Override
    public void end(boolean interrupted){
    }

    @Override
    public boolean isFinished(){
        return timer.get() > time;
    }
}
