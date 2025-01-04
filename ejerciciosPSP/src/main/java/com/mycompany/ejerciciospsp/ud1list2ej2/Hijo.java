/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejerciciospsp.ud1list2ej2;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author mihai
 */
public class Hijo {
    public static void main (String[] args){
        String vocal;
        int numeroVocales = 0;
        File ficheroVocales = new File("vocales.txt");

        try(
                PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
                FileReader fr = new FileReader(ficheroVocales)){
            vocal = args[0];
            
            int dato;
            while((dato = fr.read()) != -1){
                String caracter = String.valueOf((char) dato);
                if(caracter.equalsIgnoreCase(vocal)){
                    numeroVocales++;
                }
            }
            
            pw.println("Hay "+numeroVocales+" "+vocal+".");
            pw.flush();
            
            pw.println(vocal);
            pw.flush();
            pw.println(numeroVocales);
            pw.flush();
            
            
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
