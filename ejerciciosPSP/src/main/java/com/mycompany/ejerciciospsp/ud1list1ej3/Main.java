/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejerciciospsp.ud1list1ej3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mihai
 */
public class Main {

    public static void main(String[] args) {
       
        Scanner sc = new Scanner(System.in);
        String numero;
        while (true) {
            System.out.println("Escribe un numero entero para calcular su doble:");
            numero = sc.nextLine();

            if (numero.isEmpty()) {
                System.out.println("No se ha introducido ningun valor, finalizando programa.");
                break;
            }

            try {
                int comprobacion = Integer.parseInt(numero);
            } catch (NumberFormatException e) {
                e.printStackTrace();
                continue;
            }

            try {
                ProcessBuilder pb = new ProcessBuilder(
                        "java",
                        "com.mycompany.ejerciciospsp.ud1list1ej3.CalcularDoble",
                        numero
                );

                Process proceso = pb.start();

                BufferedReader reader = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
                String linea;

                while ((linea = reader.readLine()) != null) {
                    System.out.println("El doble es : " + linea);
                }

                int exitCode = proceso.waitFor();
                System.out.println("Se ha finalizado el proceso con codigo: " + exitCode);

            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
