/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejerciciospsp.ud2list2ej3;

/**
 *
 * @author mihai
 */
public class Banco {
    public static void main(String[] args){
        Cuenta cuenta = new Cuenta(1000, 0);
        Cliente cliente1 = new Cliente(cuenta, "Cliente 1", 25);
        Cliente cliente2 = new Cliente(cuenta, "Cliente 2", 50);
        
        
        System.out.println("Operaciones iniciadas...");
        cliente1.start();
        
        try{
            Thread.sleep(100);
        }catch(InterruptedException e){
            System.out.println("No se ha podido realizar el proceso.");
        }
        cliente2.start();

        System.out.println("Operaciones terminadas...");
    }
}
