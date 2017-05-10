
package org.usfirst.frc.team68.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;

/**
 *
 */
public class USBCamera extends Subsystem {
    
	// Declare instance variables here

    
    // Declare Class variables here
    private static USBCamera usbCamera;
	private UsbCamera camZero;
	private UsbCamera camOne;


    
    public static USBCamera getCamera() {
    	if (usbCamera == null) {
    		usbCamera = new USBCamera();
    	}
    	return usbCamera;
    }
    
    // Constructor
    private USBCamera() {
    	int camZeroWidth = 0;
    	int camZeroHeight = 0;
    	int camOneWidth = 0;
    	int camOneHeight = 0;
    	
    	SmartDashboard.getNumber("Camera Zero Width", camZeroWidth);
    	SmartDashboard.getNumber("Camera Zero Height", camZeroHeight);
    	SmartDashboard.getNumber("Camera One Width", camOneWidth);
    	SmartDashboard.getNumber("Camera One Height", camOneHeight);
    	
    	SmartDashboard.putNumber("Camera Zero Width", camZeroWidth);
    	SmartDashboard.putNumber("Camera Zero Height", camZeroHeight);
    	SmartDashboard.putNumber("Camera One Width", camOneWidth);
    	SmartDashboard.putNumber("Camera One Height", camOneHeight);
    	
    	camZero = CameraServer.getInstance().startAutomaticCapture(0);
        camZero.setResolution(camZeroWidth,camZeroHeight);
        camZero.setFPS(10);
        camOne = CameraServer.getInstance().startAutomaticCapture(1);
        camOne.setResolution(camOneWidth,camOneHeight);
        camOne.setFPS(10);
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
    	// setDefaultCommand(new Command() );
    }
}

