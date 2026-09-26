/**
 Primera Juan 6902510051
 Herrera Alejandro 6902510014
 Aaron Hernandez 6902510046
 */

package app;
import Clases.MensajeMQTT;
import Clases.Sensor;
import Clases.ServidorMQTT;
import co.edu.unicartagena.queue.Cola;
import co.edu.unicartagena.queue.Nodo;
import java.util.Scanner;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

public class Principal {
	public static void main(String args[]) throws UnsupportedEncodingException{
         System.setOut(new PrintStream(System.out,true,"UTF-8"));
         ServidorMQTT servidor = null;

        Scanner scanner = new Scanner(System.in);
        int op = -1;
        int contador = 3; // Inicializar el contador de ID en 3, ya que los primeros tres mensajes tienen IDs 1, 2 y 3
        
        while (op != 0) {
            System.out.println("Ingrese una opción:");
            System.out.println("1. Crear la cola de mensajes");
            System.out.println("2. Publicar mensaje");
            System.out.println("3. Procesar mensaje");
            System.out.println("4. Simular secuencia de operaciones");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            op = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (op) {
                case 1:
                        servidor = new ServidorMQTT(); // Crear la cola de mensajes (punto 1 del enunciado)
                        System.out.println("Cola creada. Actualmente está vacía.");
                        break;
                case 2:
                        if (servidor == null) {
                            System.out.println("Primero debe crear la cola (opción 1).");
                            break;
                        }
                        try {
                            System.out.println("Ingrese el sensor (S01, S02, S03): ");
                            String sensorTexto = scanner.nextLine();
                            Sensor sensor = Sensor.valueOf(sensorTexto.toUpperCase()); // Convertir el texto a mayúsculas para que coincida con los valores del enum

                            System.out.println("Ingrese el payload (valor medido): ");
                            String payload = scanner.nextLine();

                            System.out.println("Ingrese el timestamp (ej: 10:00:05): ");
                            String timestamp = scanner.nextLine();

                            contador++; // Incrementar el contador de ID
                            MensajeMQTT nuevoMensaje = new MensajeMQTT(contador, sensor, payload, timestamp);

                            servidor.publicarMensaje(nuevoMensaje);
                        } catch (IllegalArgumentException e) {
                            System.out.println("Sensor inválido. Por favor ingrese S01, S02 o S03.");
                        }
                    // evitar que el usuario ingrese un sensor que no esté definido en el enum Sensor
                    break;
                case 3:
                        if (servidor == null) {
                            System.out.println("Primero debe crear la cola (opción 1).");
                            break;
                        }
                        servidor.procesarMensaje();
                        break;
                case 4:
                        if (servidor == null) {
                            System.out.println("Primero debe crear la cola (opción 1).");
                            break;
                        }

                        int idSecuencia = 0; // Variable para llevar el control del ID de los mensajes en la secuencia
                        servidor.publicarMensaje(new MensajeMQTT(++idSecuencia, Sensor.S01, "28.5 °C", "10:00:01"));
                        servidor.publicarMensaje(new MensajeMQTT(++idSecuencia, Sensor.S02, "76 %", "10:00:02"));
                        servidor.publicarMensaje(new MensajeMQTT(++idSecuencia, Sensor.S03, "45 cm", "10:00:03"));
                        servidor.procesarMensaje();
                        servidor.publicarMensaje(new MensajeMQTT(++idSecuencia, Sensor.S01, "29.1 °C", "10:00:04"));
                        servidor.procesarMensaje();
                        servidor.procesarMensaje();
                        servidor.procesarMensaje();
                        servidor.procesarMensaje(); // muestra la cola vacia
                        break;
                        // punto 4 del enunciado: Simulación de la secuencia de operaciones
                case 0:
                        System.out.println("Saliendo del programa...");
                        break;
                default:
                        System.out.println("Opción inválida. Intente nuevamente.");
                        break;
            } 
        }
    }
}