package frc.robot.commands;


import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SendableBuilder;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Arm;
import frc.robot.RobotContainer;

public class ArmControl extends CommandBase {
    private Arm arm;
    private Joystick leftJoy, rightJoy;
    public ArmControl(Arm arm, Joystick leftJoy, Joystick rightJoy){
        this.arm = arm;

        this.leftJoy = leftJoy;

        this.rightJoy = rightJoy;

        //Tell the command which subsystem it needs to use.
        addRequirements(arm); 
    }

    @Override
    public void execute() {
        if(leftJoy.getRawButton(1)) {
            arm.moveArm(0.75);
        }
        else if(rightJoy.getRawButton(1)) {
            arm.moveArm(-0.75);
        }
        else {
            arm.moveArm(0);
        }
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
