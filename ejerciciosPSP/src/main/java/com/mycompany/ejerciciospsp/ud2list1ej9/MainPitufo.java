/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejerciciospsp.ud2list1ej9;

/**
 *
 * @author mihai
 */
public class MainPitufo {

    public static void main(String[] args) {
        String[] nombres = {"Papá pitufo", "Pitufina", "Filósofo", "Pintor",
            "Gruñón", "Bromista", "Dormilón", "Tímido", "Tontín", "Bonachón", "Romántico"};
        
        
        for(int i = 0; i<nombres.length; i++){
            HiloPitufo runnablePitufo = new HiloPitufo();
            /*
            Aqui creamos un hilo nuevo ocn la asignacion de un nombre a dicho hilo
            */
            Thread hiloPitufo = new Thread(runnablePitufo, nombres[i]);
            
            hiloPitufo.start();
        }
    }
}
