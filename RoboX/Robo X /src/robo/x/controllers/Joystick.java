/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robo.x.controllers;

import javax.swing.JOptionPane;
import org.bbi.linuxjoy.JoyFactory;
import org.bbi.linuxjoy.LinuxJoystick;
import static robo.x.views.Home.jMenu1;

/**
 *
 * @author root
 *
 */
public class Joystick {

    static LinuxJoystick j = JoyFactory.getFirstUsableDevice();

    public static void start() {

        if (j != null) {

            j.setCallback(new EventCallbackHandler());
            j.startPollingThread(5); // sleep for 5 ms between polls

        } else {

            JOptionPane.showMessageDialog(jMenu1, "Error, No JoySticks Connected");

        }

    }

}
