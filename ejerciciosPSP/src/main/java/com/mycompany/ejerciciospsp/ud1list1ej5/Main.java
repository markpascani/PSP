/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejerciciospsp.ud1list1ej5;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author mihai
 */
public class Main {

    public static void main(String[] args) {
        Integer valor;
        List<Integer> lista = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Introduce un numero entero");

            try {
                valor = sc.nextInt();
                sc.nextLine();
            } catch (InputMismatchException e) {
                e.printStackTrace();
                sc.nextLine();
                continue;
            }

            if (valor == 0) {
                break;
            }

            lista.add(valor);
        }

        try {
            ProcessBuilder pb = new ProcessBuilder(
                    "java",
                    "com.mycompany.ejerciciospsp.ud1list1ej5.Hijo"
            );

            Process proceso = pb.start();

            ObjectOutputStream oos = new ObjectOutputStream(proceso.getOutputStream());
            oos.writeObject(lista);
            oos.flush();
            oos.close();

            DataInputStream dis = new DataInputStream(proceso.getInputStream());
            double media = dis.readDouble();
            dis.close();
            System.out.println("La media es : " + media);

            BufferedReader readerErrores = new BufferedReader(new InputStreamReader(proceso.getErrorStream()));
            String lineaError;
            while ((lineaError = readerErrores.readLine()) != null) {
                System.out.println(lineaError);
            }
            readerErrores.close();
            int exitCode = proceso.waitFor();
            System.out.println("Proceso terminado con codigo: " + exitCode);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
