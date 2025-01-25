/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejerciciospsp.ud2list2ej2;

/**
 *
 * @author mihai
 */
public class Check {

    /*
    Creamos un buffer de 10 mil enteros
     */
    private int[] buffer = new int[10000];

    public Check() {
    }

    public void escribirBuffer(int numero) {
        /*
        Aqui estamos usando un monitor en zonas criticas de codigo
        para poder realizar las acciones de manera atomica.
         */
        synchronized (this) {
            for (int i = 0; i < buffer.length; i++) {
                buffer[i] = numero;
            }
        }
    }

    public boolean leerBuffer() {
        synchronized (this) {
            int numero = this.buffer[0];
            for (int i = 0; i < buffer.length; i++) {
                if (numero != this.buffer[i]) {
                    System.out.println("Error");
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Check check = new Check();

        Runnable runnableEscritor = () -> {
            for (int i = 0; i < 10; i++) {
                check.escribirBuffer(i);
                System.out.println("Numeros escritos");
            }

        };

        Runnable runnableLector = () -> {
            for (int i = 0; i < 10; i++) {
                if (check.leerBuffer()) {
                    System.out.println("Es correcto.");
                } else {
                    System.out.println("Es incorrecto.");
                }
            }
        };

        Thread hiloLector = new Thread(runnableLector);
        Thread hiloEscritor = new Thread(runnableEscritor);

        hiloEscritor.start();
        hiloLector.start();
    }

}
