/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejerciciospsp.ud3list1ej2;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mihai Stinga
 */
public class Cliente {

    public static void main(String[] args) {
        final String HOST = "localhost";
        final int PUERTO = 12345;
        
        try(Socket socket = new Socket(HOST,PUERTO)){
            InputStream entrada = socket.getInputStream();
            BufferedReader lector = new BufferedReader(new InputStreamReader(entrada));
            
            
            String mensaje;
            mensaje = lector.readLine();
            System.out.println("MEnsaje recibido del servidor: "+mensaje);
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
