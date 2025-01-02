/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejerciciospsp.ud1list1ej2;

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
        String linea;
        Scanner sc = new Scanner(System.in);
        try {

            while (true) {
                System.out.println("Escribe la siguiente linea");
                linea = sc.nextLine();

                if (linea.equalsIgnoreCase("fin")) {
                    break;
                }

                //Creamos el objeto processbuilder para poder ejecutar el proceso de aleatorios
                ProcessBuilder pb = new ProcessBuilder(
                        "java",
                        "com.mycompany.ejerciciospsp.ud1list1ej2.Aleatorio",
                        linea
                );
                Process proceso = pb.start();
                
                
                //Leemos el numero
                BufferedReader reader = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
                while((linea = reader.readLine()) !=null){
                    System.out.println(linea);
                }
                
                int exitCode = proceso.waitFor();
                System.out.println("Proceso terminado con codigo : "+exitCode);
            }
        } catch (IOException ex) {
            Logger.getLogger(com.mycompany.ejerciciospsp.ud1list1ej2.Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(com.mycompany.ejerciciospsp.ud1list1ej2.Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
