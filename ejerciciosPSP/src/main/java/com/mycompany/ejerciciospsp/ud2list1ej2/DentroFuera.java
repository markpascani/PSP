/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejerciciospsp.ud2list1ej2;

/**
 *
 * @author mihai
 */
public class DentroFuera {
    public static void main (String[] args){
        HiloFor hiloFor = new HiloFor();
        
        
        /*
        Al no utilizar ningun metodo para esperar la ejecucion del hilo
        el hilo Main y el hiloFor, se ejecutan a la vez, sacando siempre un resultado diferente
        de los prints. 
        */
        hiloFor.start();
        for(int i = 0; i<10; i++){
            System.out.println("Estoy fuera del hilo.");
        }
    }
}
