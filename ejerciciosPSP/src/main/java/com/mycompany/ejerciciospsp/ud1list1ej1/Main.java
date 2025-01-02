/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejerciciospsp.ud1list1ej1;

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
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Introduce un número entero: ");
            String numero = sc.nextLine();

            /*A veces para encontrar el class correcto del proceso, se tiene que compilar desde el paquete, de ahi
            lo de poner com.mycompany...
            
            Con el processbuilder se crea un objeto para ejecutar un proceso externo.
            Aquí llamamos a la clase CalculaDivisores (con el nombre completo del paquete) y le pasamos como argumento el número ingresado.
             */
            ProcessBuilder pb = new ProcessBuilder("java", "com.mycompany.ejerciciospsp.ud1list1ej1.CalculaDivisores", numero);

            // Iniciamos el proceso (ejecutamos la clase CalculaDivisores como si fuera un programa independiente).
            Process proceso = pb.start();

            //Con el buffered reader leemos la salida en bytes del proceso que hemos arrancado
            BufferedReader reader = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
            String linea;
            while ((linea = reader.readLine()) != null) {
                System.out.println(linea);
            }

            // Esperamos a que el proceso termine su ejecución.
            // El método waitFor devuelve el código de salida del proceso.
            int exitCode = proceso.waitFor();
            System.out.println("El proceso terminó con codigo " + exitCode);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
