/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejerciciospsp.ud2list1ej1;

/**
 *
 * @author mihai
 */
public class SumadorThread extends Thread{
    private int[] numeros;
    private int suma;
    
    public SumadorThread(int[] numeros){
        this.numeros = numeros;
        this.suma = 0;
    }

    public int[] getNumeros() {
        return numeros;
    }

    public void setNumeros(int[] numeros) {
        this.numeros = numeros;
    }

    public int getSuma() {
        return suma;
    }

    public void setSuma(int suma) {
        this.suma = suma;
    }
    
    @Override
    public void run(){
        
        for(int i = 0; i< this.numeros.length; i++){
            System.out.println("Running one add.");
            
            this.suma+=numeros[i];
            
        }
        System.out.println("Finished adding.");
    }
}
