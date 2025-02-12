/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejerciciospsp.ud3list3ej1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mihai
 */
public class Cliente {

    static volatile boolean activo = true;
    private static final String SERVIDOR = "localhost";
    private static final int PUERTO = 1313;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce tu nombre: ");
        String nombre = sc.nextLine();

        try (Socket socket = new Socket(SERVIDOR, PUERTO);
             PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()))) 
        {
            System.out.println("Conectado al servidor...");

            // Enviamos el nombre
            pw.println(nombre);

            // Hilo para escuchar mensajes del servidor
            new Thread(() -> {
                try {
                    String respuesta;
                    while ((respuesta = br.readLine()) != null) {
                        System.out.println(respuesta);
                    }
                } catch (IOException e) {
                    System.out.println("Conexión cerrada por el servidor.");
                } finally {
                    activo = false;
                }
            }).start();

            // Enviamos mensajes al servidor
            while (activo) {
                String mensaje = sc.nextLine();
                pw.println(mensaje);
                if (mensaje.equalsIgnoreCase("exit")) {
                    activo = false;
                }
            }
            System.out.println("Desconectando...");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}