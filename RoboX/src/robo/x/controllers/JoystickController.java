/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robo.x.controllers;

import javax.swing.JOptionPane;
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

        while (Home.jToggleButton1.isSelected()) {

            if (!Joystick.joystick.pollController()) {

                System.out.println("Controller disconnected!");
                JOptionPane.showMessageDialog(jMenu1, "Error, Controller disconnected!");
                System.exit(0);

            }

            int xValuePercentageLeftJoystick = Joystick.joystick.getX_LeftJoystick_Percentage();
            int yValuePercentageLeftJoystick = Joystick.joystick.getY_LeftJoystick_Percentage();

            boolean joystickButton_1 = Joystick.joystick.getButtonValue(0);
            boolean joystickButton_2 = Joystick.joystick.getButtonValue(1);
            boolean joystickButton_3 = Joystick.joystick.getButtonValue(2);
            boolean joystickButton_4 = Joystick.joystick.getButtonValue(3);
            boolean joystickButton_5 = Joystick.joystick.getButtonValue(4);
            boolean joystickButton_6 = Joystick.joystick.getButtonValue(5);
            boolean joystickButton_7 = Joystick.joystick.getButtonValue(6);
            boolean joystickButton_8 = Joystick.joystick.getButtonValue(7);

            ////////////////////////////////////////////////////////
            if (xValuePercentageLeftJoystick > 0) {
                Joystick.sendData("l");
            } else if (xValuePercentageLeftJoystick < 0) {
                Joystick.sendData("r");
            } else {

                Joystick.sendData("s");

            }

            ////////////////////////////////////////////////////////
            if (yValuePercentageLeftJoystick > 0) {

                Joystick.sendData("f");

            } else if (yValuePercentageLeftJoystick < 0) {
                Joystick.sendData("b");
            } else {

                Joystick.sendData("s");

            }

            ////////////////////////////////////////////////////////
            if (joystickButton_1) {
                Joystick.sendData("u");

            } else {

                Joystick.sendData("s");
            }

            if (joystickButton_2) {
                Joystick.sendData("d");

            } else {

                Joystick.sendData("s");
            }

            if (joystickButton_3) {
                Joystick.sendData("o");

            } else {

                Joystick.sendData("s");
            }

            if (joystickButton_4) {
                Joystick.sendData("c");

            } else {

                Joystick.sendData("s");
            }

            //////////////////////////////////////////////////////////////////
            if (joystickButton_5) {
                Joystick.sendData("u");

            } else {

                Joystick.sendData("s");
            }

            if (joystickButton_6) {
                Joystick.sendData("u");

            } else {

                Joystick.sendData("s");
            }

            if (joystickButton_7) {
                Joystick.sendData("u");

            } else {

                Joystick.sendData("s");
            }

            if (joystickButton_8) {
                Joystick.sendData("u");

            } else {

                Joystick.sendData("s");
            }

        }
    }

}
