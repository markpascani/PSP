/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejerciciospsp.ud2list1ej2;

/**
 *
 * @author mihai
 */
public class HiloFor extends Thread{
    
    @Override 
    public void run(){
        for(int i = 0; i<10; i++){
            System.out.println("Estoy dentro del hilo.");
        }
    }
}
