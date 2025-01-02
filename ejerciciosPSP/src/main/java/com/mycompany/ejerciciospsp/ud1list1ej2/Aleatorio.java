/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejerciciospsp.ud1list1ej2;

import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author mihai
 */
public class Aleatorio {
    public static void main (String[] args){
        int numeroAleatorio = ThreadLocalRandom.current().nextInt(0,11);
        System.out.println(numeroAleatorio);
    }  
}
