/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejerciciospsp.ud1list2ej1;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author mihai
 */
public class Hijo {

    public static void main(String[] args) {
        int numero1, numero2, suma = 0, cont = 0, posicion1 = -1, posicion2 = -1;
        try (
                Scanner sc = new Scanner(System.in); PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));) {

            DataInputStream bis = new DataInputStream(new BufferedInputStream(new FileInputStream("numeros.bin")));

            numero1 = Integer.parseInt(sc.nextLine());
            numero2 = Integer.parseInt(sc.nextLine());
            pw.println("numero1: " + numero1 + "y numero2: " + numero2);
            pw.flush();

            //Buscamos la posicion del primer numero y del segundo
            int dato;
            try {
                while (true) {
                    dato = bis.readInt();

                    // Si aún no tenemos posicion1 y el dato es numero1, la guardamos
                    if (posicion1 == -1 && dato == numero1) {
                        posicion1 = cont;
                        pw.println("Encontrada la posicion del numero " + numero1 + ", posicion " + posicion1);
                        pw.flush();
                    } // Si aún no tenemos posicion2 y el dato es numero2, la guardamos
                    else if (posicion2 == -1 && dato == numero2) {
                        posicion2 = cont;
                        pw.println("Encontrada la posicion del numero " + numero2 + ", posicion " + posicion2);
                        pw.flush();
                    }

                    cont++;

                    // Si ya tenemos ambas posiciones, terminamos de buscar
                    if (posicion1 != -1 && posicion2 != -1) {
                        break;
                    }
                }
            } catch (EOFException e) {
                //fin del archivo
            }

            // Aquí comprobamos si al menos uno sigue en -1
            if (posicion1 == -1 || posicion2 == -1) {
                System.out.println("No se encontró la posición de al menos uno de los números.");
                // Maneja el caso como quieras (throw, return, etc.)
                return;
            }
            cont = 0;
            bis.close(); // Cerramos el flujo actual
            bis = new DataInputStream(new BufferedInputStream(new FileInputStream("numeros.bin"))); // Lo reabrimos

            // Validamos que las posiciones sean correctas
            if (posicion1 == -1 || posicion2 == -1) {
                throw new IllegalStateException("No se encontraron ambas posiciones.");
            }

            //Sumamos los numeros entre essas posiciones
            try {
                while (true) {
                    dato = bis.readInt();
                    if (cont >= posicion1 && cont <= posicion2) {
                        pw.println("Sumando número: " + dato);
                        pw.flush();
                        suma += dato;
                    }
                    cont++;
                }
            } catch (EOFException e) {
                // EOFException esperada al final del archivo
            }

            pw.println(suma);
            pw.flush();
            bis.close(); // Cerramos el flujo actual

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
