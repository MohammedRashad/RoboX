/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robo.x;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import robo.x.communication.Ethernet;
import robo.x.views.Home;

/**
 *
 * @author Rashad
 */
public class Main {

    static int newH, newW;
    static Dimension dim;
    static Home H;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        java.awt.EventQueue.invokeLater(() -> {

            createWindow();
            setLocationToMiddle();

        });

    }

    private static void setLocationToMiddle() {

        dim = Toolkit.getDefaultToolkit().getScreenSize();
        newW = dim.width / 2 - H.getSize().width / 2;
        newH = dim.height / 2 - H.getSize().height / 2;
        H.setLocation(newW, newH);
    }

    private static void createWindow() {

        H = new Home();
        H.setVisible(true);
        H.setTitle("Robo X - Control ALMOST Anything");

    }

}
