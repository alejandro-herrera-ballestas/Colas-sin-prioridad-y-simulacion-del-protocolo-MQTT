package app;
import Clases.MensajeMQTT;
import Clases.Sensor;
import Clases.ServidorMQTT;
import co.edu.unicartagena.queue.Cola;
import co.edu.unicartagena.queue.Nodo;
import java.util.Scanner;

public class Principal {
	public static void main(String args[]){
        ServidorMQTT servidor = new ServidorMQTT();
        servidor.publicarMensaje(new MensajeMQTT(1, Sensor.S01, "28.5 °C", "10:00:01"));
        servidor.publicarMensaje(new MensajeMQTT(2, Sensor.S02, "76 %", "10:00:02"));
        servidor.publicarMensaje(new MensajeMQTT(3, Sensor.S03, "45 cm", "10:00:03"));
	}

        Scanner scanner = new Scanner(System.in);
        int op = -1;
        while (op != 0) {
            System.out.println("Ingrese una opción:");
            System.out.println("1. Publicar mensaje");
            System.out.println("2. Procesar mensaje");
            System.out.println("0. Salir");
            op = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (op) {
                case 1:
                    System.out.println("Crear la cola de mensajes");
                    break;
                case 2:
                    System.out.println("Publicar mensaje");
                    break;
                case 3:
                    System.out.println("Procesar mensaje");
                    break;
                case 4:
                    System.out.println("Simular secuencia de operaciones");
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
                    break;
                        
            }
        }
                

}