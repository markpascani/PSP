/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejerciciospsp.ud2list3ej1;

/**
 *
 * @author mihai
 */
public class Productos {
    private int unidades;

    public Productos(int unidades) {
        this.unidades = unidades;
    }
    
    public void venderProducto(){
        if(productosDisponibles()){
            this.unidades-=1;
        }
    }
    
    public boolean productosDisponibles(){
        return this.unidades >= 1;
    }
    
    
}
