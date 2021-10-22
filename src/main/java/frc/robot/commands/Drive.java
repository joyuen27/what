package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class Drive extends CommandBase{
    private Drivetrain drivetrain;
    private double leftSpeed, rightSpeed;
    public Drive(Drivetrain drivetrain, double leftSpeed, double rightSpeed){
        this.drivetrain = drivetrain;

        this.leftSpeed = leftSpeed;

        this.rightSpeed = rightSpeed;

        //Tell the command which subsystem it needs to use.
        addRequirements(drivetrain); 
    }

    @Override
    public void execute() {
        drivetrain.drive(leftSpeed,rightSpeed); 
    }


    //These four functions are overwritten quite frequently for commands. No need to worry about them for now.
    @Override
    public void initialize() {
        
    }
    @Override
    public boolean isFinished() {
        // TODO Auto-generated method stub
        return super.isFinished();
    }
    @Override
    public void end(boolean interrupted) {
        // TODO Auto-generated method stub
        super.end(interrupted);
    }
}
