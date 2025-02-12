/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejerciciospsp.ud2list2ej3;

/**
 *
 * @author mihai
 */
public class Cuenta {

    private float saldo;
    private int numero_reintegros;

    public Cuenta(float saldo, int numero_reintegros) {
        this.saldo = saldo;
        this.numero_reintegros = numero_reintegros;
    }

    public float getSaldo() {
        return this.saldo;
    }

    public boolean restarUnaCantidadAlSaldo(float cantidad) {
        synchronized (this) {

            if (comprobarQueSePuedeRestarCantidadAlSaldo(cantidad)) {
                this.saldo -= cantidad;
                System.out.println("Saldo retirado -> " + cantidad);
                System.out.println("En la cuenta quedan -> " + this.saldo);
                this.numero_reintegros++;
                return true;
            };
            System.out.println("No hay suficiente saldo -> " + this.saldo);
            return false;
        }

    }

    private boolean comprobarQueSePuedeRestarCantidadAlSaldo(float cantidad) {
        return cantidad <= this.saldo;
    }

}
