/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejerciciospsp.ud2list1ej7;

/**
 *
 * @author mihai
 */
public class HilosParesImpares {

    public static void main(String[] args) {
        /*
         Implementacion de un hilo con clase anonima
         */
        Runnable runnablePar = new Runnable() {
            @Override
            public void run() {
                for (int i = 2; i < 11; i += 2) {
                    System.out.println(i);
                }
            }
        };
        
        /*
        Implementacion de un hilo con una lambda.
        */
        Runnable runnableImpar = () -> {
            for (int i = 1; i < 10; i += 2) {
                System.out.println(i);
            }
        };

        Thread hiloPar = new Thread(runnablePar);
        Thread hiloImpar = new Thread(runnableImpar);

        hiloPar.start();
        hiloImpar.start();
    }

}
