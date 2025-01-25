/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejerciciospsp.ud2list1ej4;

/**
 *
 * @author mihai
 */
public class HiloReloj {
    public static void main(String[] args){
        HiloTic runnableTic = new HiloTic();
        HiloTac hiloTac = new HiloTac();
        
        Thread hiloTic = new Thread(runnableTic);
        
        hiloTac.start();
        hiloTic.start();
    }
}
