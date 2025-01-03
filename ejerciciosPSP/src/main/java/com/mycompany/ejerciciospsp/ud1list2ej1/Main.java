/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejerciciospsp.ud1list2ej1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author mihai
 */
public class Main {

    public static void main(String[] args) {
        //Gestionar ficheros
        ProcessBuilder pbFichero = new ProcessBuilder(
                "java",
                "com.mycompany.ejerciciospsp.ud1list2ej1.ManejadorFicheros"
        );
        Process proceso;

        try {
            proceso = pbFichero.start();

            try (
                    BufferedReader reader = new BufferedReader(new InputStreamReader(proceso.getInputStream()))) {
                String linea;
                while ((linea = reader.readLine()) != null) {
                    System.out.println(linea);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

            int exitCode = proceso.waitFor();
            System.out.println("Proceso de fichero terminado con codigo: " + exitCode);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Hablarcon el hijo para sumar
        int numero1 = -1;
        int numero2 = -1;

        ProcessBuilder pbHijo = new ProcessBuilder(
                "java",
                "com.mycompany.ejerciciospsp.ud1list2ej1.Hijo"
        );

        Process procesoHijo;

        try {
            procesoHijo = pbHijo.start();
            try (
                    Scanner sc = new Scanner(System.in); BufferedReader reader = new BufferedReader(new InputStreamReader(procesoHijo.getInputStream())); PrintWriter pw = new PrintWriter(new OutputStreamWriter(procesoHijo.getOutputStream()));) {

                boolean seguir = true;
                while (seguir) {
                    System.out.println("Introduce el primer numero.");
                    if (sc.hasNextInt()) {
                        numero1 = sc.nextInt();
                        sc.nextLine();
                        seguir = false;
                    } else {
                        System.out.println("Te ha equivocado.");
                        sc.nextLine();
                    }
                }
                seguir = true;
                while (seguir) {
                    System.out.println("Introduce el segundo numero.");
                    if (sc.hasNextInt()) {
                        numero2 = sc.nextInt();
                        sc.nextLine();
                        seguir = false;

                    } else {
                        System.out.println("Te ha equivocado.");
                        sc.nextLine();
                    }
                }
                pw.println(numero1);
                pw.flush();
                pw.println(numero2);
                pw.flush();
                String linea;
                while ((linea = reader.readLine()) != null) {
                    System.out.println("Salido hijo-> " + linea);
                }

                int exitCode = procesoHijo.waitFor();
                System.out.println("Proceso hijo terminado con codigo: " + exitCode);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
