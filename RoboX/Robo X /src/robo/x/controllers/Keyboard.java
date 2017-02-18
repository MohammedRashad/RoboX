/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robo.x.controllers;

/**
 *
 * @author root
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener {


    @Override
    public void keyTyped(KeyEvent e) {

        switch (e.getKeyCode()) {
            case KeyEvent.VK_RIGHT:
                System.out.println("Right typed.");

                break;
            case KeyEvent.VK_LEFT:
                System.out.println("Left typed.");
                break;
            case KeyEvent.VK_UP:
                System.out.println("Up typed.");
                break;
            case KeyEvent.VK_DOWN:
                System.out.println("Down typed.");
                break;
            default:
                System.out.println("Key typed: " + e.getKeyChar());
                break;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

        switch (e.getKeyCode()) {
            case KeyEvent.VK_RIGHT:
                System.out.println("Right pressed.");
                break;
            case KeyEvent.VK_LEFT:
                System.out.println("Left pressed.");
                break;
            case KeyEvent.VK_UP:
                System.out.println("Up pressed.");
                break;
            case KeyEvent.VK_DOWN:
                System.out.println("Down pressed.");
                break;
            default:
                System.out.println("Key pressed: " + e.getKeyChar());
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

        switch (e.getKeyCode()) {
            case KeyEvent.VK_RIGHT:
                System.out.println("Right released.");
                break;
            case KeyEvent.VK_LEFT:
                System.out.println("Left released.");
                break;
            case KeyEvent.VK_UP:
                System.out.println("Up released.");
                break;
            case KeyEvent.VK_DOWN:
                System.out.println("Down released.");
                break;
            default:
                System.out.println("Key released: " + e.getKeyChar());
                break;
        }
    }
}
