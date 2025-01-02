/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejerciciospsp.ud1list1ej1;

/**
 *
 * @author mihai
 */
public class CalculaDivisores {
    
    public static void main (String[] args){
        if(args[0].isEmpty()){
            System.out.println("No hay argumentos.");
            System.exit(-1);
        }
        
        int divisores = 0;
        int numero = Integer.parseInt(args[0]);
        for(int i = 1; i <= numero; i++){
            if(numero%i==0){
                divisores++;
            }
        }
        System.out.println("Tiene "+divisores+" divisores.");
    }
    
}
