/*
 * Copyright (C) 2016 root
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package robo.x.controllers;

import java.util.logging.Level;
import java.util.logging.Logger;
import jssc.SerialPort;
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import jssc.SerialPortException;
import jssc.SerialPortList;
import robo.x.views.Home;

/**
 *
 * @author mohamed rashad
 *
 */
public class SerialCommunication {

    SerialPort serialPort;

    static public String[] ports() {

        return SerialPortList.getPortNames();
    }

    public void SerialCommunicationInitializer(String portNum) {

        try {

            serialPort = new SerialPort(portNum);
            serialPort.openPort();
            serialPort.setParams(SerialPort.BAUDRATE_115200, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
            serialPort.setFlowControlMode(SerialPort.FLOWCONTROL_RTSCTS_IN | SerialPort.FLOWCONTROL_RTSCTS_OUT);

        } catch (SerialPortException ex) {

            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

    public void writeData(String data) throws SerialPortException {

        serialPort.writeString(data);

    }

    public void writeData(int data) throws SerialPortException {

        serialPort.writeInt(data);

    }

    public void readData(String order) throws SerialPortException {

        serialPort.writeString(order);

        switch (order) {

            case "1":

                serialPort.addEventListener(new PortReader(), SerialPort.MASK_RXCHAR);

                break;

            case "2":

                serialPort.addEventListener(new PortReader(), SerialPort.MASK_RXCHAR);

                break;

            case "3":

                serialPort.addEventListener(new PortReader(), SerialPort.MASK_RXCHAR);

                break;

            case "4":

                serialPort.addEventListener(new PortReader(), SerialPort.MASK_RXCHAR);

                break;

            case "5":

                serialPort.addEventListener(new PortReader(), SerialPort.MASK_RXCHAR);

                break;

        }

    }
    ////////////////////////////////////////////////////////////////////////////

    public class PortReader implements SerialPortEventListener {

        @Override
        public void serialEvent(SerialPortEvent event) {

            if (event.isRXCHAR() && event.getEventValue() > 0) {

                try {

                    System.out.println("" + serialPort.readString(event.getEventValue()));

                } catch (SerialPortException ex) {

                    System.out.println("Error in receiving string from COM-port: " + ex);
                }
            }
        }

    }

}
