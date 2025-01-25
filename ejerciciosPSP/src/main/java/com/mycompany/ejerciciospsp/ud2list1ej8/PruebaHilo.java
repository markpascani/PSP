/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejerciciospsp.ud2list1ej8;

import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author mihai
 */
public class PruebaHilo {
    public static void main  (String[] args){
        int[] bases = {1,2,3,4,5,6,7,8,9,10};
        int[] alturas = {1,2,3,4,5,6,7,8,9,10};
        
        
        for(int i = 0; i< 10; i++){

            HiloCalculador hiloCalc = new HiloCalculador(bases[i], alturas[i]);
            
            hiloCalc.start();
        }
    }
}
