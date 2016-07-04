package org.usfirst.frc.team9501.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import org.usfirst.frc.team9501.robot.commands.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
     private Joystick m_joystick1 = new Joystick(RobotMap.kJoystickUSBPort);
     public JoystickButton b_runIntakeIn;
     public JoystickButton b_runIntakeOut;
     public JoystickButton b_kickBall;
     public JoystickButton b_spinShooter;
     
    // Create a new joystick for the logitech controller
     private Joystick m_gamePad = new Joystick(RobotMap.kGamePadUSBPort);
     public JoystickButton b_manualAim;
     public JoystickButton b_autoAimTurret;
     public JoystickButton b_middleLEDTest;
 
     
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
     
     public OI(){
    	 b_runIntakeIn = new JoystickButton(m_joystick1,RobotMap.kBtnRunIntakeIn);
    	 b_runIntakeOut = new JoystickButton(m_joystick1,RobotMap.kBtnRunIntakeOut);
         b_runIntakeIn.whileHeld(new RunIntakeIn());
         b_runIntakeIn.whenReleased(new stopIntake());
         b_runIntakeOut.whileHeld(new RunIntakeOut());
         b_runIntakeOut.whenReleased(new stopIntake());
         b_kickBall = new JoystickButton(m_joystick1,RobotMap.kBtnKickBall);
         b_kickBall.whileHeld(new kickBall());
         b_kickBall.whenReleased(new retractKicker());
         b_spinShooter = new JoystickButton(m_joystick1, RobotMap.kBtnRunShooter);
         b_spinShooter.whileHeld(new StartShooterMotor());
         b_spinShooter.whenReleased(new StopShooterMotor());
         
         b_manualAim = new JoystickButton(m_gamePad,RobotMap.kBtnManualAim);
         b_manualAim.whileHeld(new manualAimTurret());
         b_autoAimTurret = new JoystickButton(m_gamePad,RobotMap.kBtnAutoAim);
         b_autoAimTurret.whenPressed(new autoAimTurret());
         b_middleLEDTest = new JoystickButton(m_gamePad,RobotMap.kMiddleLEDTest);
         b_middleLEDTest.whileHeld(new TurnOnBottomLEDs());
         b_middleLEDTest.whenReleased(new TurnOffBottomLEDs());
         
         
     }

     public  Joystick getJoystick() {
    	 return m_joystick1;
     }

     public  Joystick getGamePadXStick() {
    	 return m_gamePad;
     }
}

