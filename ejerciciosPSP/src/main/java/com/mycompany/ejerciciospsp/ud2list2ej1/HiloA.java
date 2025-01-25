/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejerciciospsp.ud2list2ej1;

/**
 *
 * @author mihai
 */
public class HiloA extends Thread {

    private Contador contador;

    public HiloA(String name, Contador contador) {
        super(name);
        this.contador = contador;
    }

    @Override
    public void run() {
        for (int i = 0; i < 300; i++) {
            /*
            Al ser un metodo synchronized, si otro metodo de la
            clase contador, que se usa como monitor, esta siendo accedido por otro hilo, esta
            iteracion no sigue hasta que no termine el otro hilo su metodo.
            */
            contador.incrementa();
            System.out.println("Valor actual contador despues de incremenetar-> "+contador.getValor());
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(getName() + " contador vale "+contador.getValor());

    }
}
