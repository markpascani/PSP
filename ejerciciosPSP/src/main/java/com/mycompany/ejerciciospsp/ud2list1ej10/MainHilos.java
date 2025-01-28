/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejerciciospsp.ud2list1ej10;



/**
 *
 * @author mihai
 */
public class MainHilos {

    public static void main(String[] args) {
        HiloSumador[] hilos = new HiloSumador[10];
        int suma = 0;
        for(int i = 0; i< 10; i++){
            HiloSumador hilo = new HiloSumador(i, String.valueOf(i));
            hilos[i] = hilo;
            System.out.println("Hilo "+i+" iniciado.");
            hilo.start();
        }
        
        
        // Esperar a que los hilos terminen
        for (int i = 0; i < 10; i++) {
            try {
                hilos[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        
        
        /*
        Si hacemos la suma total sin el join, 
        la suma no sera correcta porque no habran terminado los hilos. 
        */
        for(int i = 0; i<10; i++){
            suma += hilos[i].getSuma();
        }
        
        System.out.println("La suma total es "+suma);
    }
}
