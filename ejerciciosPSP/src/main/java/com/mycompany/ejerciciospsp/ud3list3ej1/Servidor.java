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
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author mihai
 */
public class Servidor {

    private static final int PUERTO = 1313;
    private static final Socket[] socketsDisponibles = new Socket[5];

    public static void main(String[] args) {
        try (ServerSocket ss = new ServerSocket(PUERTO)) {
            System.out.println("Servidor escuchando en el puerto " + PUERTO);
            while (true) {
                Socket usuario = ss.accept(); //Acepta un cliente y vamos a asignarle un espacio si lo tiene disponible.
                int indiceLibre = obtenerIndiceLibre();
                System.out.println("Usuario conectado al servidor...");

                if (indiceLibre == -1) {
                    System.out.println("Servidor lleno. Conxion rechazada");
                    usuario.close();
                } else {
                    socketsDisponibles[indiceLibre] = usuario;
                    //Continuo la ejecucion de ese cliente socket en un hilo (escuchar sus mensajes)
                    new Thread(new ManejadorCliente(usuario, indiceLibre)).start();
                }

            }

        } catch (IOException e) {

        }
    }

    // Busca un hueco libre en el array para un nuevo cliente
    private static int obtenerIndiceLibre() {
        for (int i = 0; i < socketsDisponibles.length; i++) {
            if (socketsDisponibles[i] == null) {
                return i;
            }
        }
        return -1;
    }

    // Enviar mensaje a todos los clientes
    public static synchronized void trnasmisor(String mensaje) {
        for (Socket s : socketsDisponibles) {
            if (s != null && !s.isClosed()) {
                try {
                    PrintWriter pw = new PrintWriter(s.getOutputStream(), true);
                    pw.println(mensaje);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // Hilo para manejar a cada cliente
    static class ManejadorCliente implements Runnable {

        private final Socket socket;
        private final int indice;
        private String nombre;

        public ManejadorCliente(Socket socket, int indice) {
            this.socket = socket;
            this.indice = indice;
        }

        @Override
        public void run() {
            try (
                    BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream())); 
                    PrintWriter pw = new PrintWriter(socket.getOutputStream(), true)) {
                // Leemos el nombre que envía el cliente
                nombre = br.readLine();
                System.out.println("Se ha conectado: " + nombre);
                trnasmisor("[" + nombre + "] se ha unido al chat.");

                // Esperamos y reenviamos los mensajes a todos
                String mensaje;
                while ((mensaje = br.readLine()) != null) {
                    if (mensaje.equalsIgnoreCase("exit")) {
                        break;
                    }
                    trnasmisor("[" + nombre + "]: " + mensaje);
                }
                trnasmisor("[" + nombre + "] se ha desconectado.");

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {
                }
                socketsDisponibles[indice] = null;
            }
        }
    }
}
