/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejerciciospsp.ud2list2ej1;

/**
 *
 * @author mihai
 */
public class MainContador {
    public static void main(String[] args){
        Contador con = new Contador(100);
        
        HiloA hiloA = new HiloA("Hilo A", con);
        HiloB hiloB = new HiloB("Hilo B", con);
        
        hiloA.start();
        hiloB.start();
        
    }
}
