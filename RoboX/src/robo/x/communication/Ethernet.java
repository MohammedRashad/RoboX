/*
 * Copyright (C) 2017 root
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
package robo.x.communication;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author root
 */
public class Ethernet {

    static String IPAdress;

    private static DatagramSocket m_clientSocket;

    public Ethernet(String data) {

        this.IPAdress = data;

    }

    public void startUDPClient(String data) {

        try {
            System.out.println(data);

            m_clientSocket = new DatagramSocket();

            byte[] packet = data.getBytes();

            DatagramPacket client_packet;
            client_packet = new DatagramPacket(packet, packet.length, InetAddress.getByName(this.IPAdress), 8888);

            m_clientSocket.send(client_packet);

            System.out.println("Sent!");

            m_clientSocket.close();

            System.out.println("Client socket closed");
        } catch (SocketException ex) {
            Logger.getLogger(Ethernet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Ethernet.class.getName()).log(Level.SEVERE, null, ex);
        }
       

        }

    
}
