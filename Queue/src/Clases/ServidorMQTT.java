/*
 */
package Clases;

import Clases.MensajeMQTT;
import co.edu.unicartagena.queue.Cola;

/**
 Juan Primera 6902510051
 Alejandro Herera 69025100
 */
public class ServidorMQTT {

      private Cola<MensajeMQTT> cola = new Cola<>();    // Cola para almacenar los mensajes MQTT (punto 1 del enunciado)
   
       public void publicarMensaje(MensajeMQTT mensaje) {   // Método para publicar un mensaje MQTT (punto 2 del enunciado)
        MensajeMQTT m = mensaje;
        cola.encolarDato(m);
        System.out.println("Publicado -> " + m);
        System.out.println("Mensajes en cola: " + cola.getTamaño());
    }
       
        public void procesarMensaje() {     // Método para procesar un mensaje MQTT (punto 3 del enunciado)
        if (!cola.estaVacia()) {
            MensajeMQTT m = cola.decolar();
            System.out.println("Procesado -> " + m);
            System.out.println("Mensajes restantes: " + cola.getTamaño());
        } else {
            System.out.println("La cola está vacía, no hay mensajes por procesar.");
        }
    }
}

