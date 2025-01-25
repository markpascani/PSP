/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejerciciospsp.ud2list2ej1;

/**
 *
 * @author mihai
 */
public class HiloB extends Thread {

    private Contador contador;

    public HiloB(String name, Contador contador) {
        super(name);
        this.contador = contador;
    }

    @Override
    public void run() {
        for (int i = 0; i < 300; i++) {
            contador.decrementa();
            System.out.println("Valor actual contador despues de decrementar-> " + contador.getValor());

        }

        System.out.println(getName() + " contador vale " + contador.getValor());

    }
}
