/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robo.x.controllers;

import robo.x.communication.Ethernet;
import robo.x.communication.SerialCommunication;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import jssc.SerialPortException;
import net.java.games.input.Controller;
import net.java.games.input.ControllerEnvironment;
import static robo.x.views.Home.jMenu1;

/**
 *
 * @author root
 *
 */
public class Joystick {

    static Ethernet ether;
    static SerialCommunication serial;
    static int connectionType;
    static String connectionParameter;

    static Thread control_thread = new Thread(new JoystickController(), "JoyStick");

    static Controller[] controllers = ControllerEnvironment.getDefaultEnvironment().getControllers();

    static Controller joystick; // only working with one gamepad

    public static void start(int type, String par) {

        for (int i = 0; i < controllers.length && joystick == null; i++) {
            if (controllers[i].getType() == Controller.Type.GAMEPAD
                    || controllers[i].getType() == Controller.Type.STICK) {
                joystick = controllers[i];
                break;
            }
        }

        connectionType = type;
        connectionParameter = par;

        if (connectionType == 0) {

            ether = new Ethernet(connectionParameter);

        } else if (connectionType == 1) {

            serial = new SerialCommunication();

            serial.SerialCommunicationInitializer(connectionParameter);

        }

        ////////////////////////////////////////////////////////////////////////
        if (!joystick.poll()) {

            JOptionPane.showMessageDialog(jMenu1, "Error, No JoySticks Connected");
            System.exit(0);

        }

        control_thread.start();

    }

    public static void stop() {

        control_thread.interrupt();

    }

    public static void sendData(String data) {

        if (connectionType == 0) {

            ether.startUDPClient(data);

        } else if (connectionType == 1) {

            try {
                serial.writeData(data);
            } catch (SerialPortException ex) {
                Logger.getLogger(Joystick.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
