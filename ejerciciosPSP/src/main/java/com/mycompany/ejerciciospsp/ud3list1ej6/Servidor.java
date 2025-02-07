/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejerciciospsp.ud3list1ej6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Mihai Stinga
 */
public class Servidor {

    public static void main(String[] args) {
        final int PUERTO = 12345;
        int numero = ThreadLocalRandom.current().nextInt(1, 10);
        boolean acertado = false;
        System.out.println("Iniciado servidor...");
        System.out.println("Numero a adivinar ->" + numero);
        try (ServerSocket serverSocket = new ServerSocket(PUERTO); 
                Socket clienteSocket = serverSocket.accept(); 
                OutputStream os = clienteSocket.getOutputStream(); 
                InputStream is = clienteSocket.getInputStream(); 
                BufferedReader br = new BufferedReader(new InputStreamReader(is)); 
                PrintWriter pw = new PrintWriter(os, true)) {
            System.out.println("Cliente conectado...");
            while (!acertado) {
                System.out.println("Esperando número del cliente...");
                int numeroLeido = Integer.parseInt(br.readLine());
                System.out.println("Recibido número del cliente..."+numeroLeido);
                if (numeroLeido < numero) {
                    pw.println("-1");
                    System.out.println("No ha adivinado el número." + numeroLeido);
                } else if (numeroLeido > numero) {
                    pw.println("1");
                    System.out.println("No ha adivinado el número." + numeroLeido);
                } else {
                    pw.println("0");
                    acertado = true;
                }
            }
            System.out.println("Cliente desconectado...");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

    }
}
