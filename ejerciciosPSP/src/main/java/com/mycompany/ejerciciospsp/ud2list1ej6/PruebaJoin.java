/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejerciciospsp.ud2list1ej6;



/**
 *
 * @author mihai
 */
public class PruebaJoin {
    public static void main (String[] args){
                for(int i = 0; i<5; i++){
            HiloJoin hilo = new HiloJoin(i);
            hilo.start();
            /*
            Comparado con el ejercicio 2, cuando se imprimia el final antes de imprimir todo lo de 
            lo hilos, si usamos el join, vamos a perder el paralelismo de los hilos ,para 
            imprimir todo de manera concurrente, esperando a que termine un hilo, antes de empezar otro,
            y a que terminen todos antes de llegar al sout final del main.
            */
            try{
                hilo.join();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
                
        System.out.println("Todos los hilos creados.");
    }
}
