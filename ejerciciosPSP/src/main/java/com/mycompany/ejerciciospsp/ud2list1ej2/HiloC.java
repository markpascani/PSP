/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejerciciospsp.ud2list1ej2;

/**
 *
 * @author mihai
 */
public class HiloC extends Thread{
    private int c;

    public HiloC(int c) {
        this.c = c;
        System.out.println("Creando hilo "+c+".");
    }
    
    @Override
    public void run(){
        for(int i = 0; i< 5; i++){
            System.out.println("Hilo "+this.c+" linea "+i+".");
        }
    }
}
