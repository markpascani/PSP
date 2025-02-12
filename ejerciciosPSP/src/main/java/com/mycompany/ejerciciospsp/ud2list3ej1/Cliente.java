/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejerciciospsp.ud2list3ej1;

/**
 *
 * @author mihai
 */
public class Cliente extends Thread{
    private int intentos;
    private String nombre;

    public Cliente(int intentos, String nombre) {
        this.intentos = intentos;
        this.nombre = nombre;
    }
    
    public void intentarEntrar(boolean puertaAbierta){
        if(puertaAbierta){
            
        }
    }
    
    
}
