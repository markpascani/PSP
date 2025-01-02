/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejerciciospsp.ud1list1ej5;

import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mihai
 */
public class Hijo {

    /*
    Este ejemplo sirve para controlar las unchecked operations a la hora de compilar la clase, 
    ya que no deja hasta controlarlo con el instanceof, porque el compilador no puede verificar si la lista contiene solo 
    objetos de tipo integer. 
     */
    public static void main(String[] args) {
        // Se declara e inicializa una lista vacía para almacenar los números enteros.
        List<Integer> lista = new ArrayList<>();

        // Se utiliza un bloque `try-with-resources` para gestionar automáticamente el cierre de recursos.
        try (ObjectInputStream ois = new ObjectInputStream(System.in)) {
            // Se lee un objeto desde la entrada estándar.
            Object obj = ois.readObject();
            
            // Se verifica que el objeto recibido sea una instancia de `List`.
            if (obj instanceof List<?>) {
                // Se realiza un cast a una lista genérica (sin especificar tipo).
                List<?> listaTemporal = (List<?>) obj;

                // Se itera sobre los elementos de la lista temporal para verificar que todos sean enteros.
                for (Object item : listaTemporal) {
                    if (item instanceof Integer) {
                        // Si el elemento es un entero, se agrega a la lista principal.
                        lista.add((Integer) item);
                    } else {
                        // Si algún elemento no es un entero, se lanza una excepción.
                        throw new ClassNotFoundException("La lista tiene elementos incompatibles.");
                    }
                }
            } else {
                // Si el objeto leído no es una lista, se lanza una excepción.
                throw new ClassNotFoundException("El objeto no es una lista.");
            }
        } catch (EOFException ex) {
            // Maneja excepciones relacionadas con el fin del flujo de datos.
            Logger.getLogger(Hijo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            // Maneja excepciones relacionadas con clases no encontradas o tipos incompatibles.
            Logger.getLogger(Hijo.class.getName()).log(Level.SEVERE, "Clase no encontrada o tipo inválido.", ex);
        } catch (IOException ex) {
            // Maneja excepciones de entrada/salida.
            Logger.getLogger(Hijo.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Si la lista está vacía, se termina el programa con un código de error (-1).
        if (lista.isEmpty()) {
            System.exit(-1);
        } else {
            // Si la lista no está vacía, se calcula la media de los números.
            double media = lista.stream()
                    .mapToInt(Integer::intValue) // Convierte los elementos de la lista a enteros primitivos.
                    .average() // Calcula el promedio de los enteros.
                    .orElse(0.0); // Si no hay elementos, devuelve 0.0 como valor predeterminado.

            // Se utiliza otro bloque `try-with-resources` para gestionar la escritura de datos.
            try (DataOutputStream dos = new DataOutputStream(System.out)) {
                // Se escribe el resultado de la media como un número de punto flotante en la salida estándar.
                dos.writeDouble(media);
                dos.flush();
            } catch (IOException ex) {
                // Maneja excepciones de entrada/salida durante la escritura de datos.
                Logger.getLogger(Hijo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
