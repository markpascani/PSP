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
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Mihai Stinga
 */
public class Cliente {

    public static void main(String[] args) {
        final int PUERTO = 12345;
        final String SERVIDOR = "localhost";
        Scanner sc = new Scanner(System.in);

        try (Socket socket = new Socket(SERVIDOR, PUERTO); OutputStream os = socket.getOutputStream(); PrintWriter pw = new PrintWriter(os, true); InputStream is = socket.getInputStream(); BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            System.out.println("Cliente iniciado.");
            int numero;
            boolean acertado = false;
            while (!acertado) {
                System.out.println("Adivina el numero: ");
                numero = Integer.parseInt(sc.nextLine());

                pw.println(numero);
                System.out.println("Numero enviado al servidor");

                String linea = reader.readLine();
                System.out.println("Linea leida del servidor..." + linea);
                if (linea.equals("0")) {
                    acertado = true;
                } else if (linea.equals("-1")) {
                    System.out.println("El número a acertar es mayor.");
                } else if (linea.equals("1")) {
                    System.out.println("El número a acertar es menor");
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

}
