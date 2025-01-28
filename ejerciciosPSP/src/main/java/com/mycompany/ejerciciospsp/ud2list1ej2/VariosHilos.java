/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejerciciospsp.ud2list1ej2;

/**
 *
 * @author mihai
 */
public class VariosHilos {
    public static void main (String[] args){
        
        /*
        Otro ejemplo de que la ejecucion de los hilos
        es totalmente distinta segun la ejecucion,
        ya que la cpu decidira cuando se ejecuta cada uno
        y durante cuanto tiempo
        */
        for(int i = 0; i<5; i++){
            HiloC hilo = new HiloC(i);
            hilo.start();
        }
        System.out.println("Todos los hilos creados.");
    }
}


