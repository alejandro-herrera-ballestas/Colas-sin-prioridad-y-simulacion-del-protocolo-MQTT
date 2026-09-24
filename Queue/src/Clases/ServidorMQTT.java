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
      private Cola<MensajeMQTT> cola = new Cola<>();    // Cola para almacenar los mensajes MQTT
   
       public void publicarMensaje(MensajeMQTT mensaje) {
        cola.encolarDato(mensaje);
        System.out.println("Publicado = " + mensaje);
    }
       
        public void procesarMensaje() {
        if (!cola.estaVacia()) {
            MensajeMQTT m = cola.decolar();
            System.out.println("Procesado -> " + m);
            System.out.println("Mensajes restantes: " + cola.getTamaño());
        } else {
            System.out.println("La cola está vacía, no hay mensajes por procesar.");
        }
    }
}

