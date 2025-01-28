/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejerciciospsp.ud2list2ej1;

/**
 *
 * @author mihai
 */
public class Contador {

    private int c = 0; //atributo contador

    Contador(int c) {
        this.c = c;
    }
    
    /*
    El synchronized nos asegura que las operaciones sean atomicas 
    para incrementos y decrementos. De esta manera,
    solo un hilo puede ejecutar uno de los metodos de esta clase a la vez. 
    O sea, cuando un hilo incremento, el otro no puede acceder hasta que no acabe. 
    */
    public synchronized void incrementa() {
        c = c + 1;
    }

    public synchronized void decrementa() {
        c = c - 1;
    }

    public synchronized int getValor() {
        return c;
    }
}
