/*
 */
package Clases;

/**
 *
 * @author USER
 */
public class MensajeMQTT {
    private final int id;
    private final Sensor dispositivo;
    private final String payload;
    private final String timestamp; 
    // atributos de la clase MensajeMQTT

    public MensajeMQTT(int id, Sensor dispositivo, String payload, String timestamp) {
        this.id = id;
        this.dispositivo = dispositivo;
        this.payload = payload;
        this.timestamp = timestamp;
    }

    public int getId() { return id; }
    public Sensor getDispositivo() { return dispositivo; }
    public String getPayload() { return payload; }
    public String getTimestamp() { return timestamp; }
    // getters de la clase MensajeMQTT 

    @Override
    public String toString() {
        return "MensajeMQTT:" + "\n" + 
        "ID:" + id + "\n" + 
        "Dispositivo:" + dispositivo + "\n" + 
        "Payload:" + payload + "\n" + 
        "Timestamp:" + timestamp + "\n" + 
        "Topic:" + dispositivo.getTopic();
    }
    // mensaje de salida de la clase MensajeMQTT
    
    
}
