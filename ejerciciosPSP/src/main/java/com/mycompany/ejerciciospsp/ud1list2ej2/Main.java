/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejerciciospsp.ud1list2ej2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mihai
 */
public class Main {

    public static void main(String[] args) {
        List<Process> procesos = new ArrayList<>();
        int suma = 0;
        String[] vocales = {"A", "E", "I", "O", "U"};

        for (int i = 0; i < 5; i++) {
            ProcessBuilder pb = new ProcessBuilder(
                    "java",
                    "com.mycompany.ejerciciospsp.ud1list2ej2.Hijo",
                    vocales[i]
            );
            try {
                procesos.add(pb.start());
                System.out.println("Proceso para vocal " + vocales[i] + " iniciado.");
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

// Procesar los procesos según terminan
        while (!procesos.isEmpty()) {
            for (int i = 0; i < procesos.size(); i++) {
                Process proceso = procesos.get(i);

                // Verificar si el proceso ha terminado
                try {
                    int exitCode = proceso.exitValue(); // Lanza excepción si el proceso no ha terminado
                    if (exitCode == 0) {
                        // Leer la salida del proceso terminado
                        try (BufferedReader br = new BufferedReader(new InputStreamReader(proceso.getInputStream()))) {
                            String linea;
                            while ((linea = br.readLine()) != null) {
                                System.out.println("Salida del proceso para vocal " + vocales[i] + ": " + linea);
                                String vocal = br.readLine();
                                String conteo = br.readLine();
                                suma += Integer.parseInt(conteo); // Sumar el conteo de vocales

                            }
                        }

                        System.out.println("Proceso para vocal " + vocales[i] + " terminó correctamente.");
                    } else {
                        System.err.println("Proceso para vocal " + vocales[i] + " terminó con errores.");
                    }

                    // Eliminar el proceso terminado de la lista
                    procesos.remove(i);
                    i--; // Ajustar índice después de eliminar
                } catch (IllegalThreadStateException e) {
                    // El proceso sigue en ejecución; no hacemos nada
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println("Vocales totales: " + suma);
    }
}
