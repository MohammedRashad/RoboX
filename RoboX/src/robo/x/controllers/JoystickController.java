/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robo.x.controllers;

import javax.swing.JOptionPane;
import net.java.games.input.Component;
import net.java.games.input.Event;
import net.java.games.input.EventQueue;
import robo.x.communication.Ethernet;
import static robo.x.controllers.Joystick.ether;
import robo.x.views.Home;
import static robo.x.views.Home.jMenu1;

/**
 *
 * @author root
 *
 */
public class JoystickController extends Thread {

    @Override
    public void run() {

        Event event;
        Component component;
        float value;
        String tempPosition = "";

        while (Home.jToggleButton1.isSelected()) {

            if (!Joystick.joystick.poll()) {

                System.out.println("Controller disconnected!");
                JOptionPane.showMessageDialog(jMenu1, "Error, Controller disconnected!");
                System.exit(0);

            }

            Joystick.joystick.poll();

            EventQueue eq = Joystick.joystick.getEventQueue();
            event = new Event();

            while (eq.getNextEvent(event)) {

                component = event.getComponent();
                value = event.getValue();

                // clear temporarily stored position if analog stick is in neutral position
                if ((value < 0.3) && (value > -0.3) && (tempPosition.equals(component.getIdentifier().getName()))) {
                    tempPosition = "s";
                    Joystick.sendData("s");
                }

                if (component.isAnalog()) {
                    // input from analog-sticks and back triggers
                    if ((value > 0.8) && !(tempPosition.equals(component.getIdentifier().getName()))) {
                        // positive direction
                        switch (component.getIdentifier().getName()) {
                            case "x":
                                // left stick - RIGHT
                                tempPosition = "x";
                                Joystick.sendData("r");

                                break;
                            case "y":
                                // left stick - DOWN
                                tempPosition = "y";
                                Joystick.sendData("b");

                                break;
                            case "rx":
                                // right stick - RIGHT
                                tempPosition = "rx";

                                break;
                            case "ry":
                                // right stick - DOWN
                                tempPosition = "ry";

                                break;
                            case "z":
                                // left trigger (z-axis)
                                tempPosition = "z";

                                break;
                        }
                    }
 
                    
                     if (value < -0.8 && !(tempPosition.equals(component.getIdentifier().getName()))) {
                        // negative direction
                        switch (component.getIdentifier().getName()) {
                            case "x":
                                // left stick - LEFT
                                tempPosition = "x";
                                System.out.println(tempPosition);
                                Joystick.sendData("l");

                                break;
                            case "y":
                                // left stick - UP
                                tempPosition = "y";
                                System.out.println(tempPosition);
                                Joystick.sendData("f");

                                break;
                            case "rx":
                                // right stick - LEFT
                                tempPosition = "rx";
                                System.out.println(tempPosition);

                                break;
                            case "ry":
                                // right stick - UP
                                tempPosition = "ry";
                                System.out.println(tempPosition);

                                break;
                            case "z":
                                // right trigger (z-axis)
                                tempPosition = "z";
                                System.out.println(tempPosition);

                                break;
                        }
                    }
                } else // input from buttons, dpad analog-stick-pushes
                {
                    switch (component.getIdentifier().getName()) {

                        case "0":
                            // A-Button
                            System.out.println(0);
                            Joystick.sendData("u");

                            break;
                        case "1":
                            // B-Button
                            System.out.println(1);
                            Joystick.sendData("d");

                            break;
                        case "2":
                            // X-Button
                            System.out.println(2);
                            Joystick.sendData("o");

                            break;
                        case "3":
                            // Y-Button
                            System.out.println(3);
                            Joystick.sendData("c");

                            break;
                        case "4":
                            // LB-Button
                            Joystick.sendData("m");

                            break;
                        case "6":
                            // RB-Button
                            System.out.println(4);
                            Joystick.sendData("v");

                            break;
                        case "7":
                            // Back-Button
                            System.out.println(5);
                            Joystick.sendData("s");

                            break;
                        case "8":
                            // Start-Button
                            System.out.println(6);
                            Joystick.sendData("s");

                            break;
                            
                        case "Trigger":
                            // A-Button
                            System.out.println(0);
                            Joystick.sendData("u");

                            break;
                        case "Thumb":
                            // B-Button
                            System.out.println(1);
                            Joystick.sendData("d");

                            break;
                        case "Thumb 2":
                            // X-Button
                            System.out.println(2);
                            Joystick.sendData("o");

                            break;
                        case "Top":
                            // Y-Button
                            System.out.println(3);
                            Joystick.sendData("c");

                            break;
                        case "Pinkie":
                            // LB-Button
                            Joystick.sendData("m");

                            break;
                        case "Top 2":
                            // RB-Button
                            System.out.println(4);
                            Joystick.sendData("v");

                            break;
                        case "Base":
                            // Back-Button
                            System.out.println(5);
                            Joystick.sendData("s");

                            break;
                        case "Base 2":
                            // Start-Button
                            System.out.println(6);
                            Joystick.sendData("s");

                            break;

                        default:

                            System.err.println(component.getIdentifier().getName());
                            break;
                    }
                }
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
