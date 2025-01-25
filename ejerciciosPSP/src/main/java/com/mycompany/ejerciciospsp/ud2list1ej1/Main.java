/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejerciciospsp.ud2list1ej1;

/**
 *
 * @author mihai
 */
public class Main {
    public static void main (String [] args){
       int[] numeros = {1,2,3,4,5,6,7,8,9,10};
       /*
       Una manera de instanciar el hilo, al extender la clase Thread, 
       directamente se puede iniciar ocn start() despues.
       */
        SumadorThread sumThread = new SumadorThread(numeros);
        
        /*
        Iniciamos el hilo una vez le hemos asignado los numeros. 
        */
        sumThread.start();
        
        /*
        Al no haber terminado el hilo la suma, ya que acaba de empezar, la suma sera 0.
        */
        System.out.println(sumThread.getSuma());
        
        try{
            Thread.sleep(0,05);
            /*
            Aqui la suma deberia ser diferente de 0, pero no se asegura que sea la final,
            ya que no sabemos si el hilo tardara mas del tiempo estipulado. 
            */
            System.out.println(sumThread.getSuma());
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        
        try{
            /*
            Aqui ya nos aseguramos que el hilo que se esta ejecutando 
            termine de realizar su trabajo, antes de seguir con el codigo, entonces
            se imprimira la suma correcta. 
            */
            sumThread.join();
            System.out.println(sumThread.getSuma());
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        
    }
}
