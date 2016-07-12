package org.usfirst.frc.team9501.robot.subsystems;

import org.usfirst.frc.team9501.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The ThumbWheel class includes both the thumbwheel and tower select switch.
 *
 * @author mattbrown
 *
 */
public class ThumbWheel extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	private DigitalInput m_bit0 = new DigitalInput(RobotMap.kThumbWheelBit0InDIO);
	private DigitalInput m_bit1 = new DigitalInput(RobotMap.kThumbWheelBit1InDIO);
	private DigitalInput m_bit2 = new DigitalInput(RobotMap.kThumbWheelBit2InDIO);
	private DigitalInput m_bit3 = new DigitalInput(RobotMap.kThumbWheelBit3InDIO);
	private DigitalInput m_towerSelect = new DigitalInput(RobotMap.kTowerSelectInDIO);

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    /**
     * GetTowerSelect returns an in based on the position of the switch:
     * 
     * @return 0 for LEFT and 1 for RIGHT
     */
    public int GetTowerSelect(){
    	SmartDashboard.putString("Tower Select", m_towerSelect.get() ? "Left" : "Right");
    	return (m_towerSelect.get() ? 0 : 1);
    }
    
    /**
     * GetThumbWheel returns an int based on the thumbwheel setting. It reads
     * 4 DIO ports and calculates a sum based on binary:
     *   bit 0 * 1
     *   bit 1 * 2
     *   bit 2 * 4
     *   bit 3 * 8
     * @return
     */
    public int GetThumbWheelValue(){
        int thumbwheelValue = 0;
    	thumbwheelValue = (m_bit0.get() ? 0 : 1) +
     		   (m_bit1.get() ? 0 : 2) +
     		   (m_bit2.get() ? 0 : 4) +
     		   (m_bit3.get() ? 0 : 8);
    	SmartDashboard.putInt("ThumbWheel Value", thumbwheelValue);
    	return thumbwheelValue;
    }
}

