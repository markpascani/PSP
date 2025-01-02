/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejerciciospsp.ud1list1ej3;

/**
 *
 * @author mihai
 */
public class CalcularDoble {
    public static void main (String[] args){
        if(args[0].isEmpty()){
            System.out.println("No has pasado un argumento valido.");
        }
        
        int numero = Integer.parseInt(args[0]);
        System.out.println(numero*2);
    }
}
