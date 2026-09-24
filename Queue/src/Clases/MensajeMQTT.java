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

    @Override
    public String toString() {
        return "MensajeMQTT{" + "id=" + id + ", dispositivo=" + dispositivo + ", payload=" + payload + ", timestamp=" + timestamp + '}';
    }
    
}
