/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robo.x.controllers;

import org.bbi.linuxjoy.LinuxJoystick;
import org.bbi.linuxjoy.LinuxJoystickEvent;
import org.bbi.linuxjoy.LinuxJoystickEventCallback;

/**
 *
 * @author root
 */
public class EventCallbackHandler implements LinuxJoystickEventCallback {

    public void callback(LinuxJoystick j, LinuxJoystickEvent ev) {

        switch (ev.isAxisChanged()) {
            case 0:
                System.out.print("dsfsd");
                break;
            case 1:
                System.out.print("fafsfs");
                break;
        }

        switch (ev.isButtonDown()) {

            case 0:
                // handle button 0 press here
                System.out.print("0");

                break;
            case 1:
                // handle button 1 press here
                System.out.print("1");

                break;

            case 2:
                // handle button 0 press here
                System.out.print("2");

                break;
            case 3:
                // handle button 1 press here
                System.out.print("3");

                break;

            case 4:
                // handle button 0 press here
                System.out.print("4");

                break;
            case 5:
                // handle button 1 press here
                System.out.print("5");

                break;

            case 6:
                // handle button 0 press here
                System.out.print("6");

                break;
            case 7:
                // handle button 1 press here
                System.out.print("7");

                break;
         
        }

    }
}
