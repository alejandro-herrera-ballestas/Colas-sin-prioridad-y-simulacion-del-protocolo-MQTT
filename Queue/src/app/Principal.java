package app;
import Clases.MensajeMQTT;
import Clases.Sensor;
import Clases.ServidorMQTT;
import co.edu.unicartagena.queue.Cola;
import co.edu.unicartagena.queue.Nodo;

public class Principal {
	public static void main(String args[]){
        ServidorMQTT servidor = new ServidorMQTT();
        servidor.publicarMensaje(new MensajeMQTT(1, Sensor.S01, "28.5 °C", "10:00:01"));
        servidor.publicarMensaje(new MensajeMQTT(2, Sensor.S02, "76 %", "10:00:02"));
        servidor.publicarMensaje(new MensajeMQTT(3, Sensor.S03, "45 cm", "10:00:03"));
	}
}