/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejerciciospsp.ud1list1ej6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author mihai
 */
public class Main {

    public static void main(String[] args) {
        int numero = 0;
        boolean esArmstrong = false;
        try {
            ProcessBuilder pb = new ProcessBuilder(
                    "java",
                    "com.mycompany.ejerciciospsp.ud1list1ej6.Hijo"
            );
            Process proceso = pb.start();

            try (
                    Scanner sc = new Scanner(System.in); 
                    DataOutputStream dos = new DataOutputStream(proceso.getOutputStream());
                    DataInputStream dis = new DataInputStream(proceso.getInputStream());
                ) {
                
                boolean seguir = true;
                while(seguir){
                    System.out.println("Introduce un numero: ");
                    
                    if(sc.hasNextInt()){
                        numero = sc.nextInt();
                        sc.nextLine();
                        seguir = false;
                    }else{
                        sc.nextLine();
                        System.out.println("No has introducido un numero valido. Intenta de nuevo: ");
                    }
                }
                
                dos.writeInt(numero);
                dos.flush();
                
                
                esArmstrong = dis.readBoolean();
                System.out.println("Respuesta: "+esArmstrong);
                
                int exitCode = proceso.waitFor();
                System.out.println("Proceso terminado con codigo: "+exitCode);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e){
            e.printStackTrace();
        }

    }
}
