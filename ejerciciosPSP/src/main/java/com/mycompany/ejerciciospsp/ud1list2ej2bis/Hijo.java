/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejerciciospsp.ud1list2ej2bis;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author mihai
 */
public class Hijo {

    public static void main(String[] args) {
        char c;
        Scanner sc = new Scanner(System.in);
        int cont = 0, suma = 0;
        String linea;
        try {
            File f = new File("src\\ud1\\II_EjerciciosUD1\\ejer2\\texto.txt");
            BufferedReader br = new BufferedReader(new FileReader(f));
            //System.out.println("Introduce la vocal que quieres buscar");
            c = sc.next().charAt(0);
            //System.out.println("En busca de la vocal: "+c);
            while ((linea = br.readLine()) != null) {
                for (int i = 0; i < linea.length(); i++) {
                    if (linea.charAt(i) == c) {
                        cont++;
                    }
                }
            }
            f = new File(("src\\ud1\\II_EjerciciosUD1\\ejer2\\" + c + ".txt"));
            PrintWriter pw = new PrintWriter(new FileWriter(f));
            pw.println(cont);
            pw.close();
            System.out.println(f.getAbsolutePath());
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
