/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejerciciospsp.ud2list1ej1;

/**
 *
 * @author mihai
 */
public class Sumador {
    
    
    interface SumadorAnonimo extends Runnable{
        int getSuma();
    }
    
    public static void main (String[] args){
        int [] enteros = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        
        SumadorAnonimo runnable = new SumadorAnonimo(){
            private int suma = 0;
            
            @Override
            public void run(){
                for(int i = 0; i<enteros.length; i++){
                    suma += enteros[i];
                }
            }
            
            @Override
            public int getSuma(){
                return this.suma;
            }
        };
        
        
        Thread myThread = new Thread(runnable);
        myThread.start();
        
        try{
            myThread.join();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        
        System.out.println("Resultado de la suma: "+runnable.getSuma());
    }
}
