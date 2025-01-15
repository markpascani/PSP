/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejerciciospsp.ud1list2ej3;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mihai
 */
public class Padre {

    public static void main(String[] args) {
        //Creamos lista dinamica donde se almacenaran los procesos
        List<Process> listaProcesos = new ArrayList<>();
        int sumaTotal = 0;
        String[] ficheros = {"rrhh.txt", "informatica.txt","contabilidad.txt", "comercio.txt","gerencia.txt"};
        //Creamos un bucle para iniciar los procesos
        for (int i = 0; i < ficheros.length; i++) {
            ProcessBuilder pb = new ProcessBuilder(
                    "java",
                    "com.mycompany.ejerciciospsp.ud1list2ej3.Contable"
            );

            //Redirigimos los errores al flujo estandar
            pb.redirectErrorStream(true);
            //Lanzamos el proceso y lo guardamos en la lista
            try {
                Process proceso = pb.start();
                listaProcesos.add(proceso);
                System.out.println("Proceso del fichero " + ficheros[i] + " iniciado.");

                try (
                        PrintWriter pw = new PrintWriter(new OutputStreamWriter(proceso.getOutputStream()))) {
                    pw.println(ficheros[i]);
                    pw.flush();
                    System.out.println("Enviado el fichero: "+ficheros[i]);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //Recorremos ahora el estado de los procesos hasta que no haya ninguno corriendo
        while (!listaProcesos.isEmpty()) {
            for (int i = 0; i < listaProcesos.size(); i++) {
                //Recuperamos el primer proceso
                Process proceso = listaProcesos.get(i);

                try {
                    //Comprobamos si el proceso ha terminado, esto lanzara una excepcion que controlaremos mas abajo
                    int exitCode = proceso.exitValue();//De esta manera no bloqueamos la ejecucion.
                    
                    //El 0 determina que el proceso ha terminado con exito
                    if (exitCode == 0) {
                        try (
                                BufferedReader reader = new BufferedReader(new InputStreamReader(proceso.getInputStream())); 
                                BufferedReader lectorErrores = new BufferedReader(new InputStreamReader(proceso.getErrorStream()))) {
                            String linea;                            
                            while ((linea = reader.readLine()) != null) {
                                System.out.println("Esta es la salida del hijo->"+linea);
                                int dato = Integer.parseInt(linea);
                                
                                System.out.println("Salido proceso -> " + dato);
                                sumaTotal += dato;
                            }

                            //Leemos los errores del hijo
                            String error;
                            while ((error = lectorErrores.readLine()) != null) {
                                System.err.println("Salida error-> " + error);
                            }
                        }
                        System.out.println("Proceso terminado con exito.");
                    } else {
                        System.err.println("Proceso terminado con errores.");
                    }

                    listaProcesos.remove(i);
                    i--;
                } catch (IllegalThreadStateException e) {
                    //No hacemos nada, dejamos que siga comprobando los hilos porque no ha finalizado
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
