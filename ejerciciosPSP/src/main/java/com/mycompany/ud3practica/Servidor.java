package com.mycompany.ud3practica;

import java.net.ServerSocket;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author mihai
 */
public class Servidor {

    public static int PUERTO = 12345;

    public static void main(String[] args) {
        
        //Iniciamos el serversocket y controlamos las excepciones
        try(ServerSocket )
        //Aceptar un cliente (tiene capacidad para aceptar varios clientes)
        //Se crean los hilos de ejecucion de tareas 
        //Cada tarea tiene un identificador unico generado por el servidor
        //Usa un hilo de ejecucion dónde se ejecutará la tarea que manda el cliente(si no hay disponible, tieneque esperar)
        //Una vez procesado el hilo, tiene que mandar la respuesta al cliente
    }

    //Aqui tenemos la clase estatica(donde se implementan el hilo y los metodos al cual se manda al cliente para resolver su tarea, y debe usar sync para evitar errores
    //Se usara un monitor para implementar el FIFO
    //Los hilos qe procesen tareas tienen queser un numero fijo (por ejemplo 4) 
    //Cada tarea representa una operacion matematica (por ejemplo, suma, resta, multiplicacion y division) que es enviada por el cliente
}
