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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mihai
 */
public class Transformador {
    public static void main (String[] args){
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String linea = "";
        try {
            linea = reader.readLine();
        } catch (IOException ex) {
            Logger.getLogger(Transformador.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
        pw.println("->"+linea.toUpperCase());
        pw.flush();
        pw.close();
        
    }
}
