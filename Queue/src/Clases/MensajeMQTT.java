package Clases;
/**
 Primera Juan 6902510051
 Herrera Alejandro 6902510014
 Aaron Hernandez 6902510046
 */
public class MensajeMQTT {
    private final int id;
    private final String dispositivoId;
    private final String topic;
    private final String payload;
    private final String timestamp;
    
   // atributos de la clase MensajeMQTT

       public MensajeMQTT(int id, Sensor sensor, String payload, String timestamp) {
        this.id = id;
        this.dispositivoId = sensor.name(); // pasa S01,S02 y S03
        this.topic = sensor.getTopic();
        this.payload = payload;
        this.timestamp = timestamp;
    }
    public int getId() { return id; }
    public String getDispositivoId() { return dispositivoId; }
    public String getTopic() { return topic; }
    public String getPayload() { return payload; }
    public String getTimestamp() { return timestamp; }
    // getters de la clase MensajeMQTT 

     @Override
        public String toString() {
        return "\n--- MensajeMQTT ---" +
               "\nID: " + id +
               "\nDispositivo: " + dispositivoId +
               "\nTopic: " + topic +
               "\nPayload: " + payload +
               "\nTimestamp: " + timestamp;
    }
    // mensaje de salida de la clase MensajeMQTT
}
