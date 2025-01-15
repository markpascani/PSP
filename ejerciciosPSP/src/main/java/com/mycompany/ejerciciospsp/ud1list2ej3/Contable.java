/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejerciciospsp.ud1list2ej3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
public class Contable {

    /*
    Este proceso se encarga de escribir en binario cantidades 
    aleatorias de dinero para la contabilidad de un departamento
    que reciba por argumento
     */
    public static void main(String[] args) {
        String nombreFichero="";
        try(
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            nombreFichero = reader.readLine();
        } catch (IOException ex) {
            Logger.getLogger(Contable.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //variable para sumar lo que hay en el fichero
        int suma = 0;

        //Abrimos el buffer de comunicacion
        try (
                BufferedReader reader = new BufferedReader(new FileReader(nombreFichero));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            
            String linea;
            while((linea = reader.readLine())!= null){
                int dato = Integer.parseInt(linea);
                suma += dato;
            }
            
            //Enviamos la suma al padre
            writer.write(String.valueOf(suma));
            writer.newLine(); //Para que el padre lo pueda leer con readLine
            writer.flush();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Contable.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println(ex.getMessage());
        } catch (IOException ex) {
            Logger.getLogger(Contable.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println(ex.getMessage());
        }

    }
}
