/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejerciciospsp.ud1list1ej7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author mihai
 */
public class Main {

    public static void main(String[] args) {
        int[] numeros = new int[2];

        try {
            ProcessBuilder pb = new ProcessBuilder(
                    "java",
                    "com.mycompany.ejerciciospsp.ud1list1ej7.Hijo"
            );
            Process proceso = pb.start();

            try (
                    Scanner sc = new Scanner(System.in); 
                    PrintWriter pw = new PrintWriter(new OutputStreamWriter(proceso.getOutputStream())); 
                    BufferedReader reader = new BufferedReader(new InputStreamReader(proceso.getInputStream()));) {
                
                boolean seguir = true;
                for (int i = 0; i < 2; i++) {
                    while (seguir) {
                        System.out.println("Introduce el numero "+i+": ");
                        if (sc.hasNextInt()) {
                            numeros[i] = sc.nextInt();
                            sc.nextLine();
                            seguir = false;
                        } else {
                            System.out.println("Numero introducido incorrecto.");
                            sc.nextLine();
                        }
                    }
                    seguir = true;
                }
                
                pw.println(String.valueOf(numeros[0]));
                pw.flush();
                pw.println(String.valueOf(numeros[1]));
                pw.flush();
                
                String valor;
                while((valor = reader.readLine())!= null){
                    System.out.println("La suma es : "+valor);
                }
                
            } catch (IOException e) {
                e.printStackTrace();
            }

            int exitCode = proceso.waitFor();
            System.out.println("Proceso terminado con codigo : " + exitCode);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
