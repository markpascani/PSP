/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejerciciospsp.ud2list1ej10;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mihai
 */
public class HiloSumador extends Thread {

    private int posicion;
    private int suma;

    public HiloSumador(int c, String nombre) {
        super(nombre); //Asigna nombre al hilo
        this.posicion = c;
        this.suma = 0;
    }

    @Override
    public void run() {
        int inicio = this.posicion * 100;
        int fin;
        if (posicion == 9) {
            fin = inicio + 70;
        } else {

            fin = inicio + 99;
        }
        int tamanyoNumero = Integer.BYTES;

        /*
        Para un acceso especifico, y no secuencial, se usa mejor el RandomAccesFile 
        en un fichero binario, y aque es mas eficiente
         */
        try (RandomAccessFile raf = new RandomAccessFile("src/resources/numeros.dat", "r")) {
            raf.seek(inicio * tamanyoNumero);
            for (int i = inicio; i <= fin; i++) {
                int numero = raf.readInt(); //Leemos el numero

                suma += numero; //Sumamos el numero
            }

            System.out.println("La suma del hilo " + Thread.currentThread().getName() + " es -> " + this.suma);

        } catch (EOFException ex) {
            Logger.getLogger(HiloSumador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(HiloSumador.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public int getSuma() {
        return suma;
    }
}
