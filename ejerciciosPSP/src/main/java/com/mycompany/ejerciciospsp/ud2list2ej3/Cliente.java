/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejerciciospsp.ud2list2ej3;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mihai
 */
public class Cliente extends Thread {

    private Cuenta cuenta;
    private String nombre;
    private float cantidad;
    private float total;

    public Cliente(Cuenta cuenta, String nombre, float cantidad) {
        this.cuenta = cuenta;
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    private void retirarDinero() throws InterruptedException {
        boolean retirando = true;
        while (retirando) {
            retirando = this.cuenta.restarUnaCantidadAlSaldo(this.cantidad);
            if (retirando) {
                this.total += cantidad;
            }
            Thread.sleep(500);
        }

    }

    @Override
    public void run() {
        System.out.println("Cliente operativo ->" + this.nombre);
        try {
            retirarDinero();
        } catch (InterruptedException ex) {
            System.out.println("No se ha podido terminar el proceso" + ex);
        }
        System.out.println("Cliente ha terminado sus operaciones -> " + this.nombre);
        System.out.println("Total retirado por " + this.nombre + " -> " + this.total);
    }
}
