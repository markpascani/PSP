/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejerciciospsp.ud1list1ej6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 *
 * @author mihai
 */
public class Hijo {
    public static void main (String[] args){
        
        int numero;
        try(
                DataInputStream dis = new DataInputStream(System.in);
                DataOutputStream dos = new DataOutputStream(System.out);
                ){
                    numero = dis.readInt();
                    
                    if(esArmstrong(numero)){
                        dos.writeBoolean(true);
                    }else{
                        dos.writeBoolean(false);
                    }
                } catch (IOException e){
                    e.printStackTrace();
                }
    }

    private static boolean esArmstrong(int numero) {
        int suma = 0;
        int numeroTemporal = numero;
        int digitos = String.valueOf(numero).length();
        
        while(numeroTemporal > 0){
            int digito = numeroTemporal % 10;
            suma += Math.pow(digito, digitos);
            numeroTemporal /= 10;
        }
        
        return suma == numero;
    }
}
