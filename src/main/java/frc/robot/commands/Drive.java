package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj.Joystick;


public class Drive extends CommandBase{
    private Drivetrain drivetrain;
    private Joystick leftJoy, rightJoy;
    public Drive(Drivetrain drivetrain, Joystick leftJoy, Joystick rightJoy){
        this.drivetrain = drivetrain;

        this.leftJoy = leftJoy;

        this.rightJoy = rightJoy;

        //Tell the command which subsystem it needs to use.
        addRequirements(drivetrain); 
    }

    @Override
    public void execute() {
        drivetrain.drive(-leftJoy.getRawAxis(1),-rightJoy.getRawAxis(1)); 
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
