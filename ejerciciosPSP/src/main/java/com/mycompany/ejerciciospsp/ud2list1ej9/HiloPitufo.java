/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejerciciospsp.ud2list1ej9;

/**
 *
 * @author mihai
 */
public class HiloPitufo implements Runnable{
    
   

    @Override
    public void run() {
        for(int i = 1; i< 4; i++){
            System.out.println(Thread.currentThread().getName() + "come un "+i+"º pan con queso.");
        }
        System.out.println(Thread.currentThread().getName()+" termino.");
    }
    
}
