/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejerciciospsp.ud1list2ej2bis;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author mihai
 */
public class Padre {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ProcessBuilder pb = new ProcessBuilder(args);
        Process proceso;
        int inicio, fin;
        String linea;
        int totalVocales = 0;

        File f;

        char[] vocales = {'a', 'e', 'i', 'o', 'u'};
        try {
            for (int i = 0; i < vocales.length; i++) {
                proceso = pb.start();
                BufferedReader br = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
                PrintWriter pw = new PrintWriter(new OutputStreamWriter(proceso.getOutputStream()));
                pw.println(vocales[i]);
                pw.close();

                //leemos la ruta del fichero que nos pasa el hijo
                linea = br.readLine();

                f = new File(linea);
                br = new BufferedReader(new FileReader(f));
                while ((linea = br.readLine()) != null) {
                    System.out.println("Hay " + linea + " vocales " + vocales[i]);
                    totalVocales += Integer.parseInt(linea);
                }

                br.close();
            }
            System.out.println("En total hay " + totalVocales + " vocales en el texto.");

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
