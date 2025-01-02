/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejerciciospsp.ud1list1ej7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mihai
 */
public class Hijo {

    public static void main(String[] args) {
        int[] numeros = new int[2];
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));) {

            String linea;
            for (int i = 0; i < 2; i++) {
                if ((linea = reader.readLine()) != null) {
                    numeros[i] = Integer.parseInt(linea);
                } else {
                    throw new IOException("Error: No se recibieron suficientes datos.");
                }
            }

            
            
            int a = numeros[0];
            int b = numeros[1];
            int suma;
            if (a < b) {
                suma = sumador(a, b);
            } else {
                suma = sumador(b, a);
            }

            pw.println(suma);
            pw.flush();
        } catch (IOException ex) {
            Logger.getLogger(Hijo.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    //suma de una serie
    private static int sumador(int a, int b) {
        return (b * (b+1)) / 2- ((a-1)*a)/2;
    }
}
