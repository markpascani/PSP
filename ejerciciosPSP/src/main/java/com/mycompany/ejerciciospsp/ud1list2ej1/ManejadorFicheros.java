/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejerciciospsp.ud1list2ej1;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mihai
 */
public class ManejadorFicheros {

    public static void main(String[] args) {
        System.out.println("Iniciando proceso");
        File ficheroTexto = new File("numeros.txt");
        File ficheroBinario = new File("numeros.bin");
        List<Integer> listaNumeros = new ArrayList<>();
        if (ficheroBinario.exists()) {
            System.out.println("Fichero existe: " + ficheroBinario.getAbsolutePath());
            System.exit(1);
        } else {
            try {
                ficheroBinario.createNewFile();
                System.out.println("Fichero creado.");
            } catch (IOException ex) {
                Logger.getLogger(ManejadorFicheros.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        try (
                BufferedReader br = new BufferedReader(new FileReader(ficheroTexto)); DataOutputStream bos = new DataOutputStream(new FileOutputStream(ficheroBinario));) {

            //Leemos ficheros de numeros de texto
            String linea;
            while ((linea = br.readLine()) != null) {
                int numeroTemp;
                if (linea.matches("-?\\d+")) {
                    numeroTemp = Integer.parseInt(linea);
                    listaNumeros.add(numeroTemp);
                    System.out.println("Numero añadido" + numeroTemp);
                }
            }

            //Escribimos los numeros en el fichero binario
            Iterator<Integer> iterator = listaNumeros.iterator();
            while (iterator.hasNext()) {
                bos.writeInt(iterator.next());
            }

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error" + e.getMessage());
        }
    }
}
