package com.ex09;
/*
 * MulticastClient.java
 *
 * Created on January 6, 2018, 12:08 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

/**
 *
 * @author vanting
 */
import java.io.*;
import java.net.*;


public class MulticastClient {
    
    public static void main(String[] args) throws IOException {
        
        //System.setProperty("java.net.preferIPv4Stack", "true");
        
        MulticastSocket socket = new MulticastSocket(4446);
        InetAddress address = InetAddress.getByName("230.0.0.1");
        socket.joinGroup(address);
        
        DatagramPacket packet;
        
        // get a few quotes
        for (int i = 0; i < 10; i++) {
            
            byte[] buf = new byte[256];
            packet = new DatagramPacket(buf, buf.length);
            socket.receive(packet);
            
            String received = new String(packet.getData(), 0, packet.getLength());
            System.out.println("Quote of the Moment: " + received);
        }
        
        socket.leaveGroup(address);
        socket.close();
    }
    
}