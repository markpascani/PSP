/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejerciciospsp.ud1list1ej4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mihai
 */
public class Mayusculas {

    public static void main(String[] args) {
        String linea;
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Escribe texto: ");
            linea = sc.nextLine();

            try {
                ProcessBuilder pb = new ProcessBuilder(
                        "java",
                        "com.mycompany.ejerciciospsp.ud1list1ej4.Transformador"
                );
                Process proceso = pb.start();
                
                //Escribimos la linea al proceso hijo
                PrintWriter pw = new PrintWriter(new OutputStreamWriter(proceso.getOutputStream()));
                pw.println(linea);
                pw.flush();
                pw.close();
                
                //leemos la respuesta del hijo
                BufferedReader reader = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
                while((linea = reader.readLine())!=null){
                    System.out.println(linea);
                }
                
                reader.close();
                int exitCode = proceso.waitFor();
                System.out.println("El proceso ha terminado con codigo: "+exitCode);
                
                
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException ex) {
                Logger.getLogger(Mayusculas.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }
    }
}
